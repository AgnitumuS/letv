package day07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ʹ�û�������߶�дЧ��
 * 
 * �������Ǹ߼�����
 * 
 * �߼���:�߼��������������������ģ�Ŀ���Ǽ�����
 *       �Ķ�д�������߼������������ڣ���Ϊû�����塣
 * �ͼ���:�ͼ�������ʵ�����д���ݵ���������Դ��ȷ��
 * 
 *       
 * @author Administrator
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream("zhj.flv");
		BufferedInputStream bis
			= new BufferedInputStream(fis);
		
		
		FileOutputStream fos
			= new FileOutputStream("zhj_cp1.flv");
		BufferedOutputStream bos
			= new BufferedOutputStream(fos);
		
		int d = -1;
		long start = System.currentTimeMillis();
		/*
		 * �������ڲ���һ���ֽ����飬��Ϊ������������һ��
		 * ����read������ȡһ���ֽ�ʱ��������ʵ���϶�ȡ��
		 * �����ֽڣ����������ڲ����ֽ������У�Ȼ�󷵻ص�һ
		 * ���ֽڣ��������ٴε���read����ʱ�����Ͳ�����ȥ
		 * ��ȡ�ˣ������ֽڽ��ֽ������еڶ����ֽڷ��ء�ֱ��
		 * ��ǰ�ֽ������������ֽ�ȫ�����غ󣬲Ż����´�read
		 * ����ʱ�ٴζ�ȡ�����ֽڲ������ֽ����顣
		 * ���Ի�����Ҳ������һ�ζ�д����ֽڣ����ٶ�д����
		 * ����ߵĶ�дЧ�ʡ�
		 * 
		 */
		while((d=bis.read())!=-1){
			bos.write(d);
		}
		long end = System.currentTimeMillis();
		
		System.out.println("�������!��ʱ:"+(end-start)+"ms");
		fis.close();
		fos.close();
	}
}









