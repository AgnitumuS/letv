package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author Administrator
 *
 */
public class SortListDemo2 {
	public static void main(String[] args) {
		List<String> list
			= new ArrayList<String>();
		
		list.add("����ʦ");
		list.add("����ʦ");
		list.add("С����ʦ");
		
		System.out.println(list);
		MyComparator com = new MyComparator();
		/*
		 * ���ص�sort����Ҫ����һ������ıȽ���
		 * �÷�������Ҫ�󼯺�Ԫ�ر���ʵ��Comparable
		 * �ӿڣ�����Ҳ����ʹ�ü���Ԫ������ıȽϹ���
		 * �����ˣ����Ǹ��ݸ������������ıȽ����ıȽ�
		 * ����Լ���Ԫ�ؽ�������
		 * ʵ�ʿ�����Ҳ�Ƽ�ʹ�����ַ�ʽ���򼯺�Ԫ�أ���
		 * ����Ԫ�����Զ���ġ�
		 * �����Ƚ���ʱҲ�Ƽ�ʹ�������ڲ������ʽ��
		 */
		Collections.sort(list,com);
		System.out.println(list);
		//�����ڲ�����ʽ����
		Comparator<String> com1 = new Comparator<String>(){
			public int compare(String o1, String o2) {
				return o2.length()-o1.length();
			}
			
		};
		Collections.sort(list,com1);
		System.out.println(list);
	}
}
/**
 * ����һ������ıȽ���
 * @author Administrator
 *
 */
class MyComparator 
			implements Comparator<String>{
	/**
	 * �÷�����������o1��o2�ıȽ�
	 * ������ֵ>0:o1>o2
	 * ������ֵ<0:o1<o2
	 * ������ֵ=0:�����������
	 */
	public int compare(String o1, String o2) {
		/*
		 * �ַ������ַ���Ĵ�
		 */
		return o1.length()-o2.length();
	}

	
}








