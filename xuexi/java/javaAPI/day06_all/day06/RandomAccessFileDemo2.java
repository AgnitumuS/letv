package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ���ļ��ж�ȡ�ֽ�
 * @author Administrator
 *
 */
public class RandomAccessFileDemo2 {
	public static void main(String[] args) throws IOException {
		/*
		 * ��raf.dat�ļ��ж�ȡ�ֽ�
		 */
		RandomAccessFile raf
			= new RandomAccessFile(
				"raf.dat","r"
			);
		
		/*
		 * int read()
		 * ��ȡ1���ֽڣ�����int��ʽ���ء�
		 * ������ֵΪ-1,���ʾ��ȡ�����ļ�ĩβ
		 * ��:EOF(end of file)
		 * 
		 * 00000000 00000000 00000000 00000001
		 */
		int d = raf.read();
		System.out.println(d);
		
		raf.close();
		
	}
}





