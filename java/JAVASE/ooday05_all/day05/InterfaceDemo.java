package oo.day05;
//�ӿڵ���ʾ
public class InterfaceDemo {
	public static void main(String[] args) {
		//Inter5 o1 = new Inter5(); //������󣬽ӿڲ��ܱ�ʵ����
		Inter6 o2 = new Eoo(); //��������
		Inter5 o3 = new Eoo(); //��������
		/*
		 * �ӿڵ���ϰ:
		 * 1.�����ӿ�Inter1����������NUM�ͳ��󷽷�show()
		 * 2.�����ӿ�Inter2������a()��b()
		 *   ������Aoo��ʵ��Inter2�ӿ�
		 * 3.�����ӿ�Inter3������c()
		 *   ������Boo��ʵ��Inter2��Inter3�ӿ�
		 * 4.����������Coo���������󷽷�d()
		 *   ������Doo���̳�Coo��ʵ��Inter2��Inter3�ӿ�
		 * 5.�����ӿ�Inter4���̳�Inter3��������e()
		 *   ������Eoo��ʵ��Inter4
		 * 6.main()������:
		 *     Inter4 o1 = new Inter4();-----???
		 *     Inter4 o2 = new Eoo();--------???
		 *     Inter3 o3 = new Eoo();--------???
		 */
	}
}











//��ʾ�ӿڼ�ļ̳�
interface Inter5{
	void show();
}
interface Inter6 extends Inter5{
	void say();
}
class Eoo implements Inter6{
	public void say(){}
	public void show(){}
}


//��ʾ�ּ̳�����ʵ�ֽӿ�
interface Inter3{
	void show();
}
interface Inter4{
	void say();
}
abstract class Doo{
	abstract void test();
}
class Eoo1 extends Doo implements Inter3,Inter4{
	public void show(){}
	public void say(){}
	void test(){}
}






//��ʾ�ӿڵ�ʵ��
interface Inter2{
	void show();
	void say();
}
class Coo implements Inter2{
	public void show(){}
	public void say(){}
}




//��ʾ�ӿڵĻ����﷨
interface Inter1{
	public static final double PI = 3.14159; //����
	public abstract void show(); //���󷽷�
	
	int NUM = 250; //Ĭ��public static final
	void say(); //Ĭ��public abstract
	
	//int count; //������󣬳�����������ͬʱ��ʼ��
	//void sayHi(){} //������󣬽ӿ��з���Ĭ�϶��ǳ����
}











