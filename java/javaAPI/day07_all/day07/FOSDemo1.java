package day07;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * �ļ������
 * java.io.FileOutputStream
 * ��һ���ͼ�����������ָ���ļ���д���ֽڡ�
 * @author Administrator
 *
 */
public class FOSDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * ���ļ�fos.txt��д������
		 * д��һ���ַ�����
		 * Ħ��Ħ������ħ��Ĳ�����  
		 */
		String str = "���";
		/*
		 * String->byte[]
		 * 
		 * byte[] getBytes()
		 * ����ǰ�ַ�������ϵͳĬ�ϵ��ַ���ת��Ϊ
		 * ��Ӧ��һ���ֽڡ�
		 * 
		 * byte[] getBytes(String csn)
		 * ���ݸ������ַ�������ǰ�ַ���ת��Ϊһ��
		 * �ֽڡ��������ַ���:
		 * GBK:������룬����ռ2�ֽ�
		 * UTF-8:unicode��һ���Ӽ�����������
		 *       ռ3���ֽ�
		 * ISO8859-1:ŷ�ޱ��뼯����֧�����ġ�
		 */
		byte[] data = str.getBytes("GBK");
		
		//RandomAccessFile��ʽ
		RandomAccessFile raf
			= new RandomAccessFile(
				"fos.txt","rw"	
			);
		//�Ȱ�ָ���ƶ����ļ�ĩβ������ʵ��׷�Ӳ���
		raf.seek(raf.length());
		raf.write(data);
		raf.close();
		
		//FileOutputStream��ʽ
//		FileOutputStream fos
//			= new FileOutputStream("fos.txt");
//		fos.write(data);
//		fos.close();
		
		
	}
}






