package day07;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FOS�ĸ���дģʽ��׷��дģʽ
 * @author Administrator
 *
 */
public class FOSDemo2 {
	public static void main(String[] args) throws IOException {
		/*
		 * ��Ĭ����ʽ������FOS����д�����ļ��Ѿ����ڣ�
		 * ��Ὣ���ļ���������ȫ����������¿�ʼд������
		 * ����д������
		 * 
		 * ׷��д����:�ڵ�ǰ�ļ�ĩβ��ʼд��д���ݡ�ֻ��
		 * Ҫʹ�����ع��췽�����ڶ�����������true���ɡ�
		 */
		FileOutputStream fos
			= new FileOutputStream("fos.txt",true);
		
		fos.write("���".getBytes("GBK"));
		
		System.out.println("д�����!");
		fos.close();
	}
}







