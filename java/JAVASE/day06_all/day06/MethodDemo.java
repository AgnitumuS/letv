package day06;
//��������ʾ
public class MethodDemo {
	public static void main(String[] args) {
		//say();
		//say();
		
		//sayHi(); //��������в�����봫��
		//sayHi(250); //������󣬲������Ͳ�ƥ��
		//sayHi("zhangsan",25); //������󣬲���������ƥ��
		//sayHi("zhangsan"); //String name="zhangsan"
		//sayHi("lisi"); //String name="lisi"
		//sayHi("wangwu"); //String name="wangwu"
		
		//double a = getNum(); //getNum()��ֵ����return����Ǹ���
		//System.out.println(a);
		
		//int m = plus(5,6); //int a=5,int b=6
		//System.out.println(m);
		
		int num1=5,num2=6;
		int m = plus(num1,num2); //int a=1,int b=6
		System.out.println(m);
		
		//a(); //����Ƕ�׵���
		
		System.out.println("over");
	}
	
	
	
	
	
	
	
	//�в��з���ֵ
	public static int plus(int a,int b){
		//int num = a+b;
		//return num; //���ص���num����Ǹ���
		return a+b;
	}
	
	//�޲��з���ֵ
	public static double getNum(){
		//return; //������󣬱��뷵��ֵһ��ֵ
		//return "Hi"; //������󣬷���ֵ���Ͳ�ƥ��
		return 8.88; //1.����������ִ��  2.���ؽ�������÷�
	}
	
	//�в��޷���ֵ-------�вθ����
	public static void sayHi(String name){
		System.out.println("��Һã��ҽ�"+name);
		return; //1.����������ִ��
	}
	
	//�޲��޷���ֵ
	public static void say(){
		System.out.println("��Һã��ҽ�WKJ");
	}
	
	public static void a(){
		System.out.println(111);
		b();
		System.out.println(222);
	}
	public static void b(){
		System.out.println(333);
	}
	
}












