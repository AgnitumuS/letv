package day06;

import java.io.File;

/**
 * ɾ��Ŀ¼
 * @author Administrator
 *
 */
public class FileDemo5 {
	public static void main(String[] args) {
		File dir = new File("demo");
		if(dir.exists()){
			/*
			 * ɾ��Ŀ¼��һ��Ҫ�󣬸�Ŀ¼������һ��
			 * ��Ŀ¼�ſ��Խ���ɾ����
			 */
			dir.delete();
			System.out.println("ɾ�����!");
		}else{
			System.out.println("��Ŀ¼������!");
		}
	}
}





