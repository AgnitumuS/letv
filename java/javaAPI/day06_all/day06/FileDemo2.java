package day06;

import java.io.File;

/**
 * ɾ��һ���ļ�
 * @author Administrator
 *
 */
public class FileDemo2 {
	public static void main(String[] args) {
		/*
		 * ɾ����ǰĿ¼�µ�test.txt
		 */
		File file = new File("test.txt");
		if(file.exists()){
			//ɾ��File��ʾ���ļ���Ŀ¼
			file.delete();
			System.out.println("ɾ�����!");
		}else{
			System.out.println("���ļ�������!");
		}
	}
}







