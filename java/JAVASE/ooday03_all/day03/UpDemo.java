package oo.day03;
//�������͵���ʾ
public class UpDemo {
	public static void main(String[] args) {
		Coo o1 = new Coo();
		o1.c = 1;
		o1.say();
		//o1.d = 2; //������󣬸����ܷ����ӵ�
		
		Doo o2 = new Doo();
		o2.d = 1;
		o2.show();
		o2.c = 2;
		o2.say(); //��ȷ���ӿ��Է��ʸ�
		
		Coo o3 = new Doo(); //��������
		o3.c = 1;
		o3.say();
		//o3.d = 2; //��������ܵ����ʲô�������õ�����
	}
}

class Coo{
	int c;
	void say(){}
}
class Doo extends Coo{
	int d;
	void show(){}
}

















