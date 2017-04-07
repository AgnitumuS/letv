package com.tarena.shoot;

import java.util.Random;

/** С�۷�: �Ƿ����Ҳ�ǽ��� */
public class Bee extends FlyingObject implements Award {
	private int xSpeed = 1; //x�����߲�����
	private int ySpeed = 2; //y�����߲�����
	private int awardType; //����������(0��1)
	
	/** ���췽�� */
	public Bee(){
		image = ShootGame.bee; //ͼƬ
		width = image.getWidth(); //��
		height = image.getHeight(); //��
		Random rand = new Random(); //���������
		x = rand.nextInt(ShootGame.WIDTH-this.width); //x:0��(���ڿ�-�۷��)֮�ڵ������
		y = -this.height; //y:�����۷�ĸ�
		awardType = rand.nextInt(2); //0��1֮�������� 0�������ֵ 1������
	}
	
	/** ��дgetType() */
	public int getType(){
		return awardType; //���ؽ�������(0��1)
	}

	/** ��дstep() */
	public void step(){
		x+=xSpeed; //x+(���������)
		y+=ySpeed; //y+(����)
		if(x>=ShootGame.WIDTH-this.width){ //x>=(���ڿ�-�۷��)ʱ��x-(����)
			xSpeed = -1;
		}
		if(x<=0){ //x<=0ʱ��x+(����)
			xSpeed = 1;
		}
	}

	/** ��дoutOfBounds() */
	public boolean outOfBounds(){
		return this.y>=ShootGame.HEIGHT; //�۷��y>=���ڵĸߣ���ΪԽ��
	}
}






