package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) 
		throws ServletException, IOException {
		//1.ʹ��request������������
		
		//2.ʹ��response������Ӧ����
		//2.1����״̬��
		//��������Tomcat�Զ�����
		//2.2������Ϣͷ
		res.setContentType("text/html");
		//2.3����ʵ������
		PrintWriter out = res.getWriter();
		out.println("<h1>Hello</h1>");
		out.close();
	}

	

}








