package day05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue
 * ����
 * ����Ҳ���Դ��һ��Ԫ�أ����Ǵ�ȡԪ�ر���
 * ��ѭ:�Ƚ��ȳ�ԭ��
 * @author Administrator
 *
 */
public class QueueDemo {
	public static void main(String[] args) {
		/*
		 * LinkedListҲʵ���˶��нӿڣ���Ϊ������
		 * ����һ��Ԫ�أ�������β��ɾ�졣���÷��϶���
		 * ���ص㡣
		 */
		Queue<String> queue 
			= new LinkedList<String>();
		/*
		 * boolean offer(E e)
		 * ��Ӳ��������β׷��һ����Ԫ�ء�
		 */
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		queue.offer("five");
		queue.offer("six");
		System.out.println(queue);
		/*
		 * E poll()
		 * ���Ӳ������Ӷ��׻�ȡԪ�أ���ȡ���Ԫ��
		 * �ʹӶ����б�ɾ���ˡ�
		 */
		String str = queue.poll();
		System.out.println(str);
		System.out.println(queue);
		
		/*
		 * E peek()
		 * ���ö���Ԫ�أ����ǲ������Ӳ���
		 */
		//[two,three,four]
		str = queue.peek();
		System.out.println(str);//two
		System.out.println(queue);//[two,three,four]
	
		System.out.println("������ʼ");
		System.out.println("size:"+queue.size());
//		for(int i=queue.size();i>0;i--){
//			str = queue.poll();
//			System.out.println("Ԫ��:"+str);
//		}
		while(queue.size()>0){
			str = queue.poll();
			System.out.println("Ԫ��:"+str);
		}
		
		System.out.println("�������");
		System.out.println(queue);
	
	}
}




