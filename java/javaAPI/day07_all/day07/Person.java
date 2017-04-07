package day07;

import java.io.Serializable;
import java.util.List;

/**
 * ʹ�ø�����Զ������Ķ����д����
 * 
 * ������Ҫ��ObjectOutputStreamд���Ķ���
 * ������ʵ��Serializable�ӿڡ�
 * @author Administrator
 *
 */
public class Person implements Serializable{
	/**
	 *  ��һ����ʵ����Serializalble�ӿں�Ӧ��
	 *  ����һ������serialVersionUID.�ó�����ֵ
	 *  ��ʾ��ǰ��İ汾�š�
	 *  �ð汾�ŵ�ֱֵ��Ӱ���ŷ����л��Ľ����
	 *  ����ָ���ó�������ô��ǰ���ʵ���ڱ�
	 *  ObjectOutputStream�������л�ʱ���Զ�����һ��
	 *  �汾�Ų����������л�����ֽ��С������ɵİ汾����
	 *  ���ݵ�ǰ��Ľṹ��ֻҪ��ǰ��������Լ�����û�з�
	 *  ���ı䣬�汾���ǲ����ã�����һ���ı䣬��ô�汾��
	 *  �ǻ�仯�ġ�
	 *  Ϊ�˿��Կ��Ʒ����л��Ľ�����汾��Ӧ�����ж��塣
	 *  
	 *  �汾�Ŷ��ڷ����л���Ӱ�죺
	 *  ��ʹ��ObjectInputStream���ж������л�ʱ������
	 *  ������ֽ��������Ķ���İ汾���Ƕ��٣�Ȼ���ں͸ö���
	 *  �������൱ǰ�İ汾�űȶԣ���һ�£�����Խ��з����л���
	 *  ����һ�������л����׳��쳣������������з����л���
	 *  
	 *  ���������л����ֽ������Ķ���Ľṹ�������������е�
	 *  �ṹ��һ��ʱ�����汾��һ�£�������ü���ģʽ����:
	 *  ��Ȼ�е����Ծͻ�ԭ���Ѿ�û�е���������ԡ�
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String gender;
	/*
	 * һ�������ڽ������л���õ����ֽ��������ȵ�ǰ
	 * ������洢������Ҫ��ܶࡣ���ö����ĳЩ����
	 * �����л�ʱ����Ҫ����ô����ʹ��transient�ؼ���
	 * ������ԣ�������ǰ���������л�����ֽ��оͲ���
	 * ������Щ���Ե�ֵ�ˡ��Ӷ��ﵽ�˶���"����"��Ч����
	 * transient�ؼ��ֳ������л�ʱ��ʾ���Ժ����⣬û��
	 * �����κ����á�
	 *
	 */
	private transient List<String> otherInfo;
	public Person(){
		
	}
	public Person(String name, int age, String gender, List<String> otherInfo) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.otherInfo = otherInfo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<String> getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(List<String> otherInfo) {
		this.otherInfo = otherInfo;
	}
	
	public String toString(){
		return name+","+age+","+gender+","+otherInfo;
	}
}





