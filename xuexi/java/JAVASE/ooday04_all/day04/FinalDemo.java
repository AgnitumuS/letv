package oo.day04;
//final����ʾ
public class FinalDemo {
	public static void main(String[] args) {
	}
}

//��ʾfinal������
final class Roo{}
//class Soo extends Roo{} //�������final���಻�ܱ��̳�
class Too{}
final class Uoo extends Too{} //��ȷ��final������Լ̳б����


class Poo{ //��ʾfinal���η���
	final void show(){}
	void test(){}
}
class Qoo extends Poo{
	//void show(){} //�������final�ķ������ܱ���д
	void test(){}
}

/*
 * final���γ�Ա���������ַ�ʽ��ʼ��:
 *   1)������ͬʱ��ʼ��
 *   2)���췽���г�ʼ��
 * final���ξֲ�������ֻҪ����֮ǰ��ʼ������
 */
class Ooo{ //��ʾfinal���α���
	final int a = 5; //����ͬʱ��ʼ��
	final int b;
	Ooo(){
		b = 8; //���췽���г�ʼ��
	}

	void show(){
		final int c; //��֮ǰ��ֵ���ɣ����ÿ��Բ���ֵ
		//a = 55; //�������final�ı������ܱ��ı�
	}
}











