package web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * ��Servlet��������tomcat����ʱ��
 * ��ʼ��һЩ��������������Servletʹ�á�
 * ��˴�����ֻ��init()��������Ҫservice()��
 */
public class InitServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//��context���������������һ��������
		//Ĭ��ֵ��0��
		ServletContext ctx = getServletContext();
		ctx.setAttribute("count", 0);
	}

	
	
}






