package oo.day06;
//�����ڲ������ʾ
public class NstInnerClassDemo {
	public static void main(String[] args) {
		//1.������Inter2��һ�����࣬û������
		//2.Ϊ�����ഴ����һ���������ý�o1
		//3.�������е�Ϊ���������
		Inter2 o1 = new Inter2(){
			
		};
		
		//1.������Inter2��һ�����࣬û������
		//2.Ϊ�����ഴ����һ���������ý�o2
		//3.�������е�Ϊ���������
		Inter2 o2 = new Inter2(){
			
		};
		
		final int num = 5;
		//1.������Inter3��һ�����࣬û������
		//2.Ϊ�����ഴ����һ���������ý�o3
		//3.��������Ϊ���������
		Inter3 o3 = new Inter3(){
			public void show(){
				System.out.println("showshow");
				System.out.println(num); //num���final
			}
		};
		o3.show();
	}
}

interface Inter3{
	public void show();
}

interface Inter2{
}




















