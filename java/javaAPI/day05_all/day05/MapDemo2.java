package day05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * ����Map
 * ����Map�����ַ�ʽ:
 * �������е�key
 * �������е�key-value��
 * �������е�value(��Բ�����)
 * @author Administrator
 *
 */
public class MapDemo2 {
	public static void main(String[] args) {
		Map<String,Integer> map
			= new HashMap<String,Integer>();
		map.put("����", 99);
		map.put("��ѧ", 98);
		map.put("Ӣ��", 97);
		map.put("����", 96);
		map.put("��ѧ", 99);
		System.out.println(map);
		
		/*
		 * �������е�key
		 * Set<K> keySet()
		 * �÷����Ὣ��ǰMap�����е�key����һ��
		 * Set���Ϻ󷵻ء���ô�����ü��Ͼ͵��ڱ���
		 * �����е�key
		 */
		Set<String> keySet = map.keySet();
		for(String key : keySet){
			System.out.println("key:"+key);
		}
		
		/*
		 * ����ÿһ���ֵ��
		 * Map��ÿһ���ֵ�Զ�����Map���ڲ���:
		 * java.util.Map.Entry��һ��ʵ����ʾ�ġ�
		 * Entry������������getKey,getValue������
		 * �ֱ��ȡ��һ���ֵ���е�key��value��
		 * 
		 * Set<Entry> entrySet
		 * �÷����ὫMap��ÿһ���ֵ��(Entryʵ��)
		 * ����һ��Set���Ϻ󷵻ء�
		 */
		Set<Entry<String,Integer>> entrySet 
							= map.entrySet();
		
		for(Entry<String,Integer> e:entrySet){
			String key = e.getKey();
			Integer value = e.getValue();
			System.out.println(key+":"+value);
		}
		
		/*
		 * �������е�value
		 * Collection values()
		 * �÷����Ὣ��ǰMap�����е�value����һ��
		 * ���Ϻ󷵻ء�
		 */
		Collection<Integer> values = map.values();
		for(Integer value : values){
			System.out.println("value:"+value);
			
		}
		
	}
}







