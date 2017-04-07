package day05;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map
 * Map����������һ���������еı��
 * ��key-value�Ե���ʽ���Ԫ�ء�
 * ��Map��key�������ظ�(�ظ�������key��equals�ж�)
 * ���õ�ʵ����Ϊ:HashMap
 * @author Administrator
 *
 */
public class MapDemo1 {
	public static void main(String[] args) {
		Map<String,Integer> map 
			= new HashMap<String,Integer>();
		
		/*
		 * V put(K k,V v)
		 * ��������key-value�Դ���Map
		 * ����MapҪ��key�������ظ�������ʹ��Map
		 * ���е�key����һ���µ�valueʱ�Ĳ�����
		 * �滻value,��ô����ֵΪ��keyԭ����Ӧ��
		 * value������һ���µ�key,�򷵻�ֵΪnull��
		 * 
		 */
		Integer value = map.put("����", 99);
		System.out.println("old:"+value);
		map.put("��ѧ", 98);
		map.put("Ӣ��", 97);
		map.put("����", 96);
		map.put("��ѧ", 99);
		System.out.println(map);
		
		value = map.put("����", 98);
		System.out.println(map);
		System.out.println("old:"+value);
		
		
		/*
		 * V get(K k)
		 * ���ݸ�����key��ȡ��Ӧ��value������ǰ
		 * Map��û�и�����key���򷵻�ֵΪnull
		 */
		value = map.get("��ѧ");
		System.out.println("��ѧ:"+value);
		value = map.get("����");
		System.out.println("����:"+value);
		
		/*
		 * V remove(K k)
		 * ɾ��������key����Ӧ��key-value�ԡ�
		 * ����ֵΪ��ɾ����key-value���е�value��
		 */
		System.out.println("ɾ����ѧ");
		value = map.remove("��ѧ");
		System.out.println(map);
		System.out.println("old:"+value);
		
	}
}







