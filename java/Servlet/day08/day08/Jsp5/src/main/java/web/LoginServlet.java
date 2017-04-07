package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		String user = req.getParameter("user");
		//�״η��ʸ���Ŀʱ��Tomcat���Զ������
		//���������һ��session����ʹ��request
		//�������session��
		HttpSession session = req.getSession();
		//session�п��Դ��������͵�����
		session.setAttribute("user", user);
		//��Ӧʱ���������Զ����������session��ID
		res.sendRedirect("index");
	}
	
}







