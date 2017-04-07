package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ������߶�дЧ�ʣ���Ҫͨ�����ÿ�ζ�д��������
 * �����ٶ�д�Ĵ����ﵽ��
 * ��дӲ�̵Ĵ���Խ�࣬��дЧ��Խ�
 * @author Administrator
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src
			= new RandomAccessFile(
				"zhj.flv","r"	
			);
		RandomAccessFile desc
			= new RandomAccessFile(
				"zhj_copy1.flv","rw"	
			);
		
		/*
		 * һ�ζ�ȡһ���ֽڵķ���:
		 * int read(byte[] data)
		 * һ���Զ�ȡ��������data��length���ֽڣ�
		 * ���ҽ���ȡ���ֽ�ȫ�����뵽data������.
		 * ����ֵΪʵ�ʶ�ȡ�����ֽ�������Ϊ-1�����ʾ
		 * ����û�ж�ȡ���κ��ֽ�(�ļ�ĩβ)
		 */
		//10k
		byte[] buf = new byte[1024*10];
		int len = -1;
		
		long start = System.currentTimeMillis();
		while((len = src.read(buf))!=-1){
			/*
			 * void write(byte[] data)
			 * ���������ֽ������е������ֽ�һ����д��
			 * 
			 * void write(byte[] d,int s,int len)
			 * �����������д��±�Ϊs�����ֽڿ�ʼ������len
			 * ���ֽ�һ����д��
			 */
			desc.write(buf,0,len);
		}
		long end = System.currentTimeMillis();
		System.out.println("�������!��ʱ:"+(end-start)+"ms");
		
		src.close();
		desc.close();
	}
}






