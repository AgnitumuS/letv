package oo.day05;
//���п�ϵͳ
public class UnionPayTest {
	public static void main(String[] args) {
		ICBCImpl card1 = new ICBCImpl(); //���п�
		ICBC     card2 = new ICBCImpl(); //���п�
		UnionPay card3 = new ICBCImpl(); //������-���п�
	}
}

interface UnionPay{ //�����ӿ�
	public double getBalance(); //��ѯ���
	public boolean drawMoney(double number); //ȡǮ
	public boolean checkPwd(String input); //��������Ƿ���ȷ
}
interface ICBC extends UnionPay{
	public void payOnline(double number); //����֧��
}
interface ABC extends UnionPay{
	public boolean payTelBill(String phoneNum,double sum); //֧���绰��
}
class ICBCImpl implements ICBC{
	public double getBalance(){return 0.0;}
	public boolean drawMoney(double number){return true;}
	public boolean checkPwd(String input){return true;}
	public void payOnline(double number){}
}
class ABCImpl implements ABC{
	public double getBalance(){return 0.0;}
	public boolean drawMoney(double number){return true;}
	public boolean checkPwd(String input){return true;}
	public boolean payTelBill(String phoneNum,double sum){return true;}
}








