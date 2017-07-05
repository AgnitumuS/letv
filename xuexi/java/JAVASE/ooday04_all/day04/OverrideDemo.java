package oo.day04;
//��д����ʾ
public class OverrideDemo {
	public static void main(String[] args) {
		/*
		Aoo o1 = new Aoo();
		o1.show(); //����show
		Boo o2 = new Boo();
		o2.show(); //����show
		Aoo o3 = new Boo();
		o3.show(); //����show
		*/
		
		//���ؿ����ã���д������
		Goo goo = new Goo();
		Eoo o = new Foo(); //��������
		goo.test(o);
		
		/*
		 * 1.������Eoo������show()�����"����show"
		 * 2.������Foo�̳�Eoo����дshow()�����"����show"
		 * 3.������Goo������:
		 *    void test(Eoo o){
		 *      ���"���Ͳ���"
		 *      o.show();
		 *    }
		 *    void test(Foo o){
		 *      ���"���Ͳ���"
		 *      o.show();
		 *    }
		 * 4.main()������:
		 *    Goo goo = new Goo();
		 *    Eoo o = new Foo(); //��������
		 *    goo.test(o);
		 */
	}
}

class Goo{
	void test(Eoo o){
		System.out.println("���Ͳ���");
		o.show();
	}
	void test(Foo o){
		System.out.println("���Ͳ���");
		o.show();
	}
}
class Eoo{
	void show(){
		System.out.println("����show");
	}
}
class Foo extends Eoo{
	void show(){
		System.out.println("����show");
	}
}















/*
 * ��д��Ҫ��ѭ"��ͬ��Сһ��"ԭ��:һ�㶼��һģһ����
 * 1.��ͬ:
 *   1)����������ͬ
 *   2)�����б���ͬ
 * 2.��С:
 *   1)���෽���ķ���ֵ����С�ڻ���ڸ����
 *     1.1)void�ͻ�������ʱ��������ͬ
 *     1.2)��������ʱ��С�ڻ����
 *   2)���෽���׳����쳣С�ڻ���ڸ����-------�쳣
 * 3.һ��:
 *   1)���෽���ķ���Ȩ�޴��ڻ���ڸ����----�������η�
 */

//���������С
class Coo{
	void sayHi(){}
	double show(){return 0.0;}
	Coo test(){return null;}
	Doo say(){return null;}
}
class Doo extends Coo{
	void sayHi(){} //voidʱ������ͬ
	double show(){return 1;} //��������ʱ������ͬ
	Doo test(){return null;} //С�ڸ���
	//Coo say(){return null;} //���������������ʱ����С�ڻ����
}









class Aoo{
	void show(){
		System.out.println("����show");
	}
}
class Boo extends Aoo{
	void show(){
		super.show(); //���ø����show����
		System.out.println("����show");
	}
}









