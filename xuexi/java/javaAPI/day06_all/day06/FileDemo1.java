package day06;

import java.io.File;
import java.io.IOException;

/**
 * java.io.File
 * ʹ��File�������ļ�
 * @author Administrator
 *
 */
public class FileDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * �ڵ�ǰ��Ŀ��Ŀ¼�´���test.txt�ļ�
		 * ֱ�Ӹ�������Ĭ���ڵ�ǰĿ¼�¡�
		 */
		File file = new File("test.txt");
		/*
		 * boolean exists()
		 * �жϵ�ǰ File��ʾ���ļ���Ŀ¼�Ƿ��Ѿ�
		 * �����ˡ�
		 */
		if(!file.exists()){
			//�������ļ�
			file.createNewFile();
			System.out.println("�������!");
		}else{
			System.out.println("���ļ��Ѵ���!");
		}
	}
}






