package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Course;
import entity.Student;

public class DemoServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//ģ���ѯѧ������
		Student s = new Student();
		s.setName("cang");
		s.setAge(18);
		s.setSex("F");
		s.setInterests(
			new String[]{"����","��Ƭ","��"});
		Course c = new Course();
		c.setId(1);
		c.setCourseName("Java");
		c.setDays(80);
		s.setCourse(c);
		//ת����JSP
		//��ǰ��/Jsp3/demo
		//Ŀ�꣺/Jsp3/demo.jsp
		req.setAttribute("stu", s);
		req.getRequestDispatcher(
			"demo.jsp").forward(req, res);
	}

	
	
}







