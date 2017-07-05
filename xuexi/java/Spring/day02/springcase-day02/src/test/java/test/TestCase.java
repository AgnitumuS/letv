package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ioc.MessageBean;

/**
 * ������
 *
 */
public class TestCase {
	@Test
	//�������÷�ʽע�뼯�����͵�ֵ��
	public void test1(){
		//����spring����
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
		"applicationContext.xml");
		//ͨ���������һ��beanʵ��
		MessageBean mb = 
				ac.getBean("msg",
						MessageBean.class);
		System.out.println(mb);
	}
	
	@Test
	//���� ��ȡproperties�ļ������ݡ�
	public void test2(){
		//����spring����
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
		"applicationContext.xml");
		//ͨ���������һ��beanʵ��
		System.out.println(
				ac.getBean("config"));
	}
	
	@Test
	//���� spring���ʽ��ȡ����bean�����ԡ�
	public void test3(){
		//����spring����
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
		"applicationContext.xml");
		//ͨ���������һ��beanʵ��
		System.out.println(
				ac.getBean("eb"));
	}
	
	
	
	
	
	
}
