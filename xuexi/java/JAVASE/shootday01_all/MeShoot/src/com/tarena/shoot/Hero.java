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
}








