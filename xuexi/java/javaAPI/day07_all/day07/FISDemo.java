package day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * java.io.FileInputStream
 * ʹ���ļ�����������ȡ�ļ�����
 * @author Administrator
 *
 */
public class FISDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream("fos.txt");
		
		byte[] data = new byte[100];
	
		int len = fis.read(data);
		System.out.println("��ȡ����"+len+"���ֽ�");
		
		/*
		 * byte[]->String
		 * ����Ĺ��췽�����Խ��������ֽ�������ָ����Χ
		 * �ڵ��ֽڰ���ϵͳĬ���ַ���ת��Ϊ�ַ���������
		 * ָ����Χ�����ǽ��ֽ������������ֽڽ���ת����
		 * ���������һ���ַ���������ָ���ַ�����
		 */
		String str = new String(data,0,len,"GBK");
		System.out.println(str);
		fis.close();
		
	}
}




