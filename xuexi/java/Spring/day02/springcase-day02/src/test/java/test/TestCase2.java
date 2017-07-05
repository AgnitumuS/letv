package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotation.Hotel;
import annotation.Manager;
import annotation.Restaurant;
import annotation.Student;

public class TestCase2 {
	@Test
	//���� ���ɨ��
	public void test1(){
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				"app.xml");
		Student stu = 
				ac.getBean("stu",Student.class);
		System.out.println(stu);
	}
	
	@Test
	//���� ������
	public void test2(){
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				"app.xml");
		Student stu = 
				ac.getBean("stu",Student.class);
		Student stu2 = 
				ac.getBean("stu",Student.class);
		System.out.println(stu == stu2);
	}
	
	@Test
	//���� �ӳټ���
	public void test3(){
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				"app.xml");
		
	}
	
	@Test
	//���� ����������صķ�����
	public void test4(){
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				"app.xml");
		Student stu = 
				ac.getBean("stu",Student.class);
		System.out.println(stu);
		ac.close();
	}
	
	@Test
	//���� @Autowired�����ע�롣
	public void test5(){
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				"app.xml");
		Restaurant rest = 
				ac.getBean("rest",
						Restaurant.class);
		System.out.println(rest);
		Hotel hotel = 
				ac.getBean("hotel",Hotel.class);
		System.out.println(hotel);
	}
	
	@Test
	//���� @Resource�����ע�롣
	public void test6(){
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				"app.xml");
		Manager mg = ac.getBean("manager",
				Manager.class);
		System.out.println(mg);
	}
	
	@Test
	//���� @Value��
	public void test7(){
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				"app.xml");
		Manager mg = ac.getBean("manager",
				Manager.class);
		System.out.println(mg);
	}
	
	
	
	
}
