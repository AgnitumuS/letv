package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//1.������������
		String name = req.getParameter("userName");
		String pwd = req.getParameter("password");
		String sex = req.getParameter("sex");
		String[] interests = 
			req.getParameterValues("interest");
		//2.����ҵ��
		System.out.println(name);
		System.out.println(pwd);
		System.out.println(sex);
		if(interests != null) {
			for(String interest : interests) {
				System.out.println(interest);
			}
		}
		//3.������Ӧ����
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<p>ע��ɹ�</p>");
		out.close();
	}

	
	
}








