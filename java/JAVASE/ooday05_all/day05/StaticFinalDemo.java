package oo.day05;
//static final��������ʾ
public class StaticFinalDemo {
	public static void main(String[] args) {
		System.out.println(Aoo.PI); //ͨ��������������
		//Aoo.PI = 3.1415926; //������󣬳������ܱ��ı�
		
		
		//1.����Boo.class����������
		//2.count�����ڷ�������
		//3.���������л�ȡcount�����
		System.out.println(Boo.count);
		
		//����ʱ�Զ��滻Ϊ�����ֵ---Ч�ʸ�
		//�൱��System.out.println(5);
		System.out.println(Boo.NUM);
	}
}

class Boo{
	public static final int NUM = 5; //����
	public static int count = 8; //��̬����
}

class Aoo{
	public static final double PI = 3.1415926;
	//public static final int NUM; //������󣬱�������ͬʱ��ʼ��
}


















