package day06;

import java.io.File;

/**
 * ɾ��һ�����������Ŀ¼
 * @author Administrator
 *
 */
public class FileDemo8 {
	public static void main(String[] args) {
		/*
		 * ����ǰĿ¼�µ�aĿ¼ɾ��
		 */
		File dir = new File("a");
		deleteFile(dir);
	}
	/**
	 * ��������File��ʾ���ļ���Ŀ¼ɾ��
	 * @param f
	 */
	public static void deleteFile(File f){
		if(f.isDirectory()){
			//����Ŀ¼�µ���������ɾ��
			File[] subs = f.listFiles();
			for(File sub : subs){
				deleteFile(sub);
			}
		}
		f.delete();
	}
}
/*
 * ���дһ�δ��룬���ó���20
 * Ҫ��:����1+2+3+4+...100
 * ÿ��һ�����һ�ν��
 * �������5050
 * �����в��ó���for,while�ؼ���
 */





