package day07;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * java.io.ObjectInputStream
 * �������������߼�����ʹ�ø������Ժܷ���Ľ���ȡ����
 * �ֽ�ת��Ϊ��Ӧ�Ķ���ǰ���Ƕ�ȡ���ֽڱ����Ǿ���
 * ObjectOutputStream���л������õ��ġ�
 * @author Administrator
 *
 */
public class OISDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis
			= new FileInputStream(
				"person.obj"
			);
		
		ObjectInputStream ois
			= new ObjectInputStream(fis);
		/*
		 * Object readObject()
		 * �÷�����ͨ��fis���ֽڴ��ļ��ж�ȡ������
		 * Ȼ��[�����л�]�ɶ���󷵻ء�
		 */
		Person p = (Person)ois.readObject();
		
		System.out.println(p);
		
		ois.close();
		
	}
}





