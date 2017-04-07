package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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
		//1.1����������
		System.out.println(
			"��������:"+req.getMethod());
		System.out.println(
			"Servlet·��:"+req.getServletPath());
		System.out.println(
			"Э������:"+req.getProtocol());
		//1.2������Ϣͷ
		//��Ϣͷ�е����ݰ��ռ�ֵ�����洢���ǿ��Ա����ġ�
		//headNames��key�ĵ�����
		Enumeration<String> e = req.getHeaderNames();
		while(e.hasMoreElements()) {
			String key = e.nextElement();
			String value = req.getHeader(key);
			System.out.println(
					key + ":" + value);
		}
		//1.3����ʵ������
		//��������û�з���ҵ�����ݣ�ʵ������Ϊ��
		
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








