package day07;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * java.io.ObjectOutputStream
 * �������������һ���߼�����ʹ�ø������Ժܷ���Ľ�
 * java�е��������ת��Ϊ�ֽں�д����
 * @author Administrator
 *
 */
public class OOSDemo {
	public static void main(String[] args) throws IOException {
		Person p = new Person();
		p.setName("����ʦ");
		p.setAge(22);
		p.setGender("Ů");
		List<String> otherInfo
			= new ArrayList<String>();
		
		otherInfo.add("��һ����Ա");
		otherInfo.add("ϲ��дë����");
		otherInfo.add("�ٽ������Ļ�����");
		otherInfo.add("�ó������Ӱ���Ͷ�����Ӱ");
		p.setOtherInfo(otherInfo);
		System.out.println(p);
		
		FileOutputStream fos
			= new FileOutputStream("person.obj");
		/*
		 * ��������������Է���Ľ�����ת��Ϊ�ֽں�д����
		 * �������ڸö�������������ļ�����������Ծ���
		 * ����д���Ķ������Ȼ���ת��Ϊһ���ֽڣ�Ȼ����
		 * �����ļ������д�뵽���ļ��С�
		 * 
		 * ����->oos->��Ϊһ���ֽ�->fos->д�뵽���ļ�
		 */
		ObjectOutputStream oos
			= new ObjectOutputStream(fos);
		/*
		 * �÷������ǽ�����д���ġ��Ὣ�ö���
		 * ת��Ϊһ���ֽڣ�����OOS�Ķ��з�����
		 * 
		 * ������ת��Ϊһ���ֽڵĹ���:�������л�
		 * �����ݴ��ڴ�ᵽӲ�̵Ĺ��̳�Ϊ:�־û�
		 */
		oos.writeObject(p);
		System.out.println("д�����!");
		oos.close();
		
	}
}



