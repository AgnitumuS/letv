package day06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile�ṩ�˿��Է����д
 * java�в�ͬ�����������ݵķ�����
 * @author Administrator
 *
 */
public class RandomAccessFileDemo3 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
			= new RandomAccessFile(
				"raf.dat","rw"	
			);
		/*
		 * long getFilePointer()
		 * �÷������Ի�ȡ��ǰRandomAccessFile��
		 * ָ��λ�á�
		 * �մ�����RAFָ��λ�����ļ���ʼ�������±�
		 * ��ʽ��ʾ�����Ե�һ���ֽ�λ��Ϊ0.
		 */
		long pos = raf.getFilePointer();
		System.out.println("pos:"+pos);
		
		int imax = Integer.MAX_VALUE;
		/*
		 * һ����д��4���ֽڣ���������intֵ��Ӧ��
		 * 32λ2����ȫ��д��
		 */
		raf.writeInt(imax);
		System.out.println("pos:"+raf.getFilePointer());
		
		
		//һ����д��8���ֽ�
		double d = 123.123;
		raf.writeDouble(d);
		System.out.println("pos:"+raf.getFilePointer());
		
		
		//һ����д��8���ֽ�
		long l = 1234;
		raf.writeLong(l);
		System.out.println("pos:"+raf.getFilePointer());
		
		/*
		 * void seek(long pos)
		 * ��ָ���ƶ���ָ��λ�ô�
		 */
		System.out.println("��ָ���ƶ����ļ���ʼ��");
		raf.seek(0);
		System.out.println("pos:"+raf.getFilePointer());
		/*
		 * int readInt()
		 * ������ȡ4���ֽڣ���ת��Ϊintֵ���ء�
		 * ����ȡ���ļ�ĩβ���׳�EOFException
		 */
		int i = raf.readInt();
		System.out.println(i);
		System.out.println("pos:"+raf.getFilePointer());
		
		
		//��ȡlongֵ
		raf.seek(12);
		l = raf.readLong();
		System.out.println(l);
		System.out.println("pos:"+raf.getFilePointer());
		
		//��ȡdoubleֵ
		raf.seek(4);
		d = raf.readDouble();
		System.out.println(d);
		System.out.println("pos:"+raf.getFilePointer());
		raf.close();
		
	}
}









