package day07;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ʹ�û��������д�����ݵ�ע������
 * @author Administrator
 *
 */
public class BOSDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos
			= new FileOutputStream("bos.txt");
		BufferedOutputStream bos
			= new BufferedOutputStream(fos);
		
		bos.write("���!".getBytes());
		/*
		 * ǿ�ƽ���ǰ�������Ļ���������ȫ��д����
		 * ��Ҫע�⣬Ƶ��flash�����д������������
		 * д��Ч�ʡ�����д���ļ�ʱ�Ե��Ա�֤��
		 */
		bos.flush();
		//closeǰ���Զ�flush,����ֻ��������߼���
		bos.close();
	}
}







