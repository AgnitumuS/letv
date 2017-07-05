package web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//��ȡ����Ĳ���
		String user = req.getParameter("user");
		
		//�������cookie�����ں�����������ʾ����
		//1��cookieֻ�ܴ�һ���ֵ�ԣ�����ֵ
		//�������ַ�����
		Cookie c1 = new Cookie("user",user);
		//����cookie����ʱ�䣬
		//��ʱ��������Զ�ɾ������
		c1.setMaxAge(6000);
		//����cookie���͸�����������䱣�档
		res.addCookie(c1);
		
		//CookieĬ�ϲ���ֱ�Ӵ����ģ����򱨴�
		//��Ҫ�����ı���(ASKII)����ܱ��档
		Cookie c2 = new Cookie("city",
			URLEncoder.encode("����", "utf-8"));
		res.addCookie(c2);
		
		//�ض�����ҳ
		res.sendRedirect("index");
	}
	
}




