package com.tarena.shoot;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

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
	
	ShootGame(){
		flyings = new FlyingObject[2];
		flyings[0] = new Airplane();
		flyings[1] = new Bee();
		bullets = new Bullet[1];
		bullets[0] = new Bullet(100,200);
	}
	
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
		frame.add(game); //��������ӵ�������
		
		frame.setSize(WIDTH, HEIGHT); //���ô��ڿ��͸�
		frame.setAlwaysOnTop(true); //����һֱ��������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //����Ĭ�Ϲرղ���(�رմ���ʱ�˳�����)
		frame.setLocationRelativeTo(null); //���ô��ھ�����ʾ
		frame.setVisible(true); //1.���ô��ڿɼ�  2.�������paint()����
	}
}



























