package com.tarena.shoot;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Arrays;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/** �������� */
public class ShootGame extends JPanel {
	public static final int WIDTH = 400;  //���ڿ�
	public static final int HEIGHT = 654; //���ڸ�
	
	public static BufferedImage background; //����ͼ
	public static BufferedImage start;      //����ͼ
	public static BufferedImage pause;      //��ͣͼ
	public static BufferedImage gameover;   //��Ϸ����ͼ
	public static BufferedImage airplane;   //�л�
	public static BufferedImage bee;        //С�۷�
	public static BufferedImage bullet;     //�ӵ�
	public static BufferedImage hero0;      //Ӣ�ۻ�0
	public static BufferedImage hero1;      //Ӣ�ۻ�1
	
	private Hero hero = new Hero(); //Ӣ�ۻ�����
	private FlyingObject[] flyings = {}; //����(�л�+С�۷�)�������
	private Bullet[] bullets = {}; //�ӵ��������
	
	static{ //��ʼ����̬��Դ(ͼƬ)
		try{
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/** ���ɵ���(�л�+С�۷�)���� */
	public FlyingObject nextOne(){
		Random rand = new Random(); //�������������
		int type = rand.nextInt(20); //����0��19֮��������
		if(type < 4){ //�����<4ʱ�����۷����
			return new Bee();
		}else{ //�����Ϊ4��19֮��ʱ���صл�����
			return new Airplane();
		}
	}
	
	int flyEnteredIndex = 0; //�����볡����
	/** ����(�л�+С�۷�)�볡 */
	public void enterAction(){ //10������һ��
		flyEnteredIndex++; //ÿ10�����1
		if(flyEnteredIndex%40==0){ //ÿ400(10*40)������һ��
			FlyingObject one = nextOne(); //��ȡ����(�л�+С�۷�)����
			flyings = Arrays.copyOf(flyings,flyings.length+1); //����
			flyings[flyings.length-1] = one; //�����ɵĵ��˶�����ӵ���������һ��Ԫ����
		}
	}
	
	/** ������(�л���С�۷䡢�ӵ���Ӣ�ۻ�)��һ�� */
	public void stepAction(){ //10������һ��
		hero.step(); //Ӣ�ۻ���һ��
		for(int i=0;i<flyings.length;i++){ //�������е���
			flyings[i].step(); //������һ��
		}
		for(int i=0;i<bullets.length;i++){ //���������ӵ�
			bullets[i].step(); //�ӵ���һ��
		}
	}
	
	int shootIndex = 0; //�ӵ��볡����
	/** �ӵ��볡(Ӣ�ۻ������ӵ�) */
	public void shootAction(){ //10������һ��
		shootIndex++; //ÿ10�����1
		if(shootIndex%30==0){ //ÿ300(10*30)������һ��
			Bullet[] bs = hero.shoot(); //��ȡ�ӵ�����
			bullets = Arrays.copyOf(bullets,bullets.length+bs.length); //����(bs�м���Ԫ�ؾ����󼸸�����)
			System.arraycopy(bs,0,bullets,bullets.length-bs.length,bs.length); //�����׷��
		}
	}
	
	/** ɾ��Խ��ĵ���(�л�+С�۷�)���ӵ� */
	public void outOfBoundsAction(){
		int index = 0; //1.��Խ�����������±�  2.��Խ����˵ĸ���
		FlyingObject[] flyingLives = new FlyingObject[flyings.length]; //��Խ���������
		for(int i=0;i<flyings.length;i++){ //�������е���
			FlyingObject f = flyings[i]; //��ȡÿһ������
			if(!f.outOfBounds()){ //����Խ��
				flyingLives[index] = f; //����Խ��ĵ��˶�����ӵ���Խ�����������
				index++; //1.��Խ����������±���һ 2.��Խ����˸�����һ
			}
		}
		flyings = Arrays.copyOf(flyingLives,index); //����Խ��ĵ��˸��Ƶ�flyings�У�indexΪ��Խ����˵ĸ�������flyings���³���
		
		index = 0; //����
		Bullet[] bulletLives = new Bullet[bullets.length]; //��Խ���ӵ�����
		for(int i=0;i<bullets.length;i++){ //���������ӵ�
			Bullet b = bullets[i]; //��ȡÿһ���ӵ�
			if(!b.outOfBounds()){ //����Խ��
				bulletLives[index] = b; //����Խ����ӵ�������ӵ���Խ���ӵ�������
				index++; //1.��Խ���ӵ������±���һ  2.��Խ���ӵ�������һ
			}
		}
		bullets = Arrays.copyOf(bulletLives, index); //����Խ����ӵ����Ƶ�bullets�У�indexΪ��Խ���ӵ��ĸ�������bullets���³���
	}
	
	/** ���������ִ�� */
	public void action(){
		//��������������
		MouseAdapter l = new MouseAdapter(){
			/** ��д����ƶ��¼� */
			public void mouseMoved(MouseEvent e){
				int x = e.getX(); //��ȡ����x����
				int y = e.getY(); //��ȡ����y����
				hero.moveTo(x, y); //Ӣ�ۻ���������ƶ�
			}
		};
		this.addMouseListener(l); //�����������¼�
		this.addMouseMotionListener(l); //������껬���¼�
		
		Timer timer = new Timer(); //������ʱ������
		int intervel = 10; //ʱ����(�Ժ���Ϊ��λ)
		timer.schedule(new TimerTask(){
			public void run(){ //10������һ��--��ʱ�ɵ��Ǹ���
				enterAction(); //����(�л�+С�۷�)�볡
				stepAction();  //��������һ��
				shootAction(); //�ӵ��볡(Ӣ�ۻ������ӵ�)
				outOfBoundsAction(); //ɾ��Խ��ĵ���(�л�+С�۷�)���ӵ�
				repaint(); //�ػ�--����paint()����
			}
		},intervel,intervel);
	}
	
	/** ��дpaint() g:���� */
	public void paint(Graphics g){
		g.drawImage(background,0,0,null); //������ͼ
		paintHero(g); //��Ӣ�ۻ�����
		paintFlyingObjects(g); //������(�л�+С�۷�)����
		paintBullets(g); //���ӵ�����
	}
	/** ��Ӣ�ۻ����� */
	public void paintHero(Graphics g){
		g.drawImage(hero.image,hero.x,hero.y,null); //��Ӣ�ۻ�����
	}
	/** ������(�л�+С�۷�)���� */
	public void paintFlyingObjects(Graphics g){
		for(int i=0;i<flyings.length;i++){ //��������(�л�+С�۷�)����
			FlyingObject f = flyings[i]; //��ȡÿһ������
			g.drawImage(f.image,f.x,f.y,null); //������(�л�+С�۷�)����
		}
	}
	/** ���ӵ����� */
	public void paintBullets(Graphics g){
		for(int i=0;i<bullets.length;i++){ //�����ӵ�����
			Bullet b = bullets[i]; //��ȡÿһ���ӵ�
			g.drawImage(b.image,b.x,b.y,null); //���ӵ�����
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fly"); //����
		ShootGame game = new ShootGame(); //���
		frame.add(game); //�������ӵ�������
		frame.setSize(WIDTH, HEIGHT); //���ô��ڿ�͸�
		frame.setAlwaysOnTop(true); //����һֱ��������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����Ĭ�Ϲرղ���(�رմ���ʱ�˳�����)
		frame.setLocationRelativeTo(null); //���ô��ھ�����ʾ
		frame.setVisible(true); //1.���ô��ڿɼ�  2.�������paint()����
		
		game.action(); //���������ִ��
	}
}




























