package day06;

import java.io.File;

/**
 * ʹ��File����һ��Ŀ¼
 * @author Administrator
 *
 */
public class FileDemo3 {
	public static void main(String[] args) {
		/*
		 * �ڵ�ǰĿ¼�´���һ����Ϊdemo��Ŀ¼
		 */
		File dir = new File("demo");
		
		if(!dir.exists()){
			//������Ŀ¼
			dir.mkdir();
			System.out.println("�������!");
		}else{
			System.out.println("��Ŀ¼�Ѵ���!");
		}
	}
}



