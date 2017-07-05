package com.tarena.shoot;
import java.awt.image.BufferedImage;
/** Ӣ�ۻ�: �Ƿ����� */
public class Hero extends FlyingObject {
	private int life; //��
	private int doubleFire; //����ֵ
	private BufferedImage[] images; //ͼƬ����(����ͼƬ�л�)
	private int index; //Э��ͼƬ�л�
	
	/** ���췽�� */
	public Hero(){
		image = ShootGame.hero0; //ͼƬ
		width = image.getWidth();   //��
		height = image.getHeight(); //��
		x = 150; //x:�̶���ֵ
		y = 400; //y:�̶���ֵ
		life = 3; //Ĭ��3����
		doubleFire = 0; //Ĭ�ϻ���ֵΪ0������������
		images = new BufferedImage[]{ShootGame.hero0,ShootGame.hero1}; //����ͼƬhero0��hero1
		index = 0; //Э���л�
	}

	/** ��дstep() */
	public void step(){ //10������һ��
		image = images[index++/10%images.length]; //ÿ100�����л�һ��
		
		/*
		//ÿ100������һ��
		index++;
		int a = index/10;
		int b = a%2;
		image = images[b];
		*/
		/*
		 * 10M  index=1  a=0 b=0
		 * 20M  index=2  a=0 b=0
		 * 30M  index=3  a=0 b=0
		 * 40M  index=4  a=0 b=0
		 * ...
		 * 100M index=10 a=1 b=1
		 * 110M index=11 a=1 b=1
		 * ...
		 * 200M index=20 a=2 b=0
		 * 210M index=21 a=2 b=0
		 * ...
		 * 300M index=30 a=3 b=1
		 * ...
		 */
	}

	/** Ӣ�ۻ������ӵ� */
	public Bullet[] shoot(){
		int xStep = this.width/4; //1/4Ӣ�ۻ��Ŀ�
		int yStep = 20; //y��������20
		if(doubleFire>0){ //˫������
			Bullet[] bs = new Bullet[2];
			bs[0] = new Bullet(this.x+1*xStep,this.y-yStep); //x:Ӣ�ۻ���x+1/4Ӣ�ۻ��Ŀ� y:Ӣ�ۻ���y-20
			bs[1] = new Bullet(this.x+3*xStep,this.y-yStep); //x:Ӣ�ۻ���x+3/4Ӣ�ۻ��Ŀ� y:Ӣ�ۻ���y-20
			doubleFire-=2; //����һ��˫�����������ֵ��2
			return bs;
		}else{ //��������
			Bullet[] bs = new Bullet[1];
			bs[0] = new Bullet(this.x+2*xStep,this.y-yStep); //x:Ӣ�ۻ���x+2/4Ӣ�ۻ��Ŀ� y:Ӣ�ۻ���y-20
			return bs;
		}
	}

	/** Ӣ�ۻ���������ƶ�  x:����x���� y:����y���� */
	public void moveTo(int x,int y){
		this.x = x - this.width/2;  //Ӣ�ۻ���x=����x-1/2Ӣ�ۻ��Ŀ�
		this.y = y - this.height/2; //Ӣ�ۻ���y=����y-1/2Ӣ�ۻ��ĸ�
	}

	/** ��дoutOfBounds() */
	public boolean outOfBounds(){
		return false; //����Խ��
	}
}








