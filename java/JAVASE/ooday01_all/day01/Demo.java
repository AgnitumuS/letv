package oo.day01;
//�������ͻ��Ⱥ���Null
public class Demo {
	public static void main(String[] args) {
		/*
		Cell c1 = new Cell();
		Cell c2 = c1; //ָ��ͬһ������
		c1.row = 2;
		c2.row = 5;
		System.out.println(c1.row); //5��������һ�����޸Ļ�Ӱ������һ��
		
		int a = 5;
		int b = a; //��ֵ
		a = 8;
		b = 88;
		System.out.println(a); //8��������һ�����޸Ĳ���Ӱ������һ��
		*/
		
		Cell c = new Cell();
		c.row = 2;
		c = null; //�գ�û��ָ���κζ���
		c.row = 2; //NullPointerException�쳣
		
	}
}


















