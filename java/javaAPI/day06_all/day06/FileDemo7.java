package day06;

import java.io.File;
import java.io.FileFilter;

/**
 * ��ȡһ��Ŀ¼�µĲ������ݡ�
 * (��ȡ���������Ĳ�������)
 * @author Administrator
 *
 */
public class FileDemo7 {
	public static void main(String[] args) {
		/*
		 * ��ȡ��ǰĿ¼��������"."��ͷ������
		 */
		File dir = new File(".");
		MyFilter filter = new MyFilter();
		
		/*
		 * ʹ�������ڲ�����ʽ����һ����ȡ��ǰĿ¼
		 * �������ļ��Ĺ�������
		 */
		FileFilter filter1 = new FileFilter(){
			public boolean accept(File file){
				return file.isFile();
			}
		};
		
		/*
		 * ���ص�listFiles�����Ὣ�Ὣ�������
		 * ����һ�ι����������Ǹ÷���ֻ�Ὣ���������
		 * accept����������ء�
		 */
		File[] subs = dir.listFiles(filter1);
		for(File sub : subs){
			System.out.println(sub.getName());
		}
	}
}
class MyFilter implements FileFilter{

	public boolean accept(File file) {
		//��������:��������"."��ͷ
		String name = file.getName();
		System.out.println("���ڹ���:"+name);
		return name.startsWith(".");
	}
	
}







