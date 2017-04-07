package day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFile
 * ���������ڶ�д�ļ����ݵġ���д�����ǻ���ָ��Ĳ�����
 * ��:������ָ�뵱ǰλ�ý��ж�д��
 * RandomAccessFile�����ִ���ģʽ:
 * ֻ��ģʽ:�����ڶ�ȡ�ļ�����
 * ��дģʽ:���ļ����Ա༭(�ɶ�����д)
 * @author Administrator
 *
 */
public class RandomAccessFileDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * ���raf.dat�ļ����ж�д����
		 * 
		 * ���췽����
		 * RandomAccessFile(String path,String mode)
		 * RandomAccessFile(File file,String mode)
		 * ģʽ��Ӧ���ַ���:
		 * "r":ֻ��
		 * "rw"��д
		 */
		RandomAccessFile raf
			= new RandomAccessFile("raf.dat","rw");
		/*
		 * void write(int d)
		 * ��������intֵ��"�Ͱ�λ"2������Ϣд���ļ���
		 *                            vvvvvvvv
		 * 00000000 00000000 00000000 00000001
		 */
		raf.write(1);
		System.out.println("д�����!");
		//��д��Ϻ�һ��close
		raf.close();
	}
}







