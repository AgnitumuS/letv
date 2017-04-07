package day05;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.io.File
 * File��ÿһ��ʵ�����Ա�ʾ�ļ�ϵͳ�е�һ���ļ���
 * Ŀ¼
 * ʹ��File����:
 * 1:�����ļ���Ŀ¼������(��:��С�����֣��޸�ʱ���)
 * 2:�����ļ���Ŀ¼(������ɾ���ļ���Ŀ¼)
 * 3:����Ŀ¼�е���������
 * ���ǲ�����:
 * �����ļ����ݡ�
 * @author Administrator
 *
 */
public class FileDemo1 {
	public static void main(String[] args) {
		File file = new File(
			"."+File.separator+"demo.txt"		      
		);
		//��ȡ����
		String name = file.getName();
		System.out.println("name:"+name);
		
		//��С(ռ�õ��ֽ���)
		long length = file.length();
		System.out.println("��С:"+length+"�ֽ�");
	
		//�Ƿ�Ϊ�ļ�
		boolean isFile = file.isFile();
		System.out.println("���ļ�:"+isFile);
		
		//�Ƿ�ΪĿ¼
		boolean isDir = file.isDirectory();
		System.out.println("��Ŀ¼:"+isDir);
		
		//�Ƿ�Ϊ�����ļ�
		boolean isHidden = file.isHidden();
		System.out.println("�Ƿ�����:"+isHidden);
		
		//����޸�ʱ��
		long time = file.lastModified();
		
		Date date = new Date(time);
		SimpleDateFormat sdf
			= new SimpleDateFormat(
				"yyyy��M��d�� HH:mm:ss"	
			);
		System.out.println(sdf.format(date));
		//�Ƿ��д
		boolean canWrite = file.canWrite();
		System.out.println("��д:"+canWrite);
		
		
	}
}







