package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindDeptServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest arg0, 
		HttpServletResponse arg1) throws ServletException, IOException {
		//ʹ��context��ȡweb.xml��Ԥ�õĲ�����
		//�ö����е����ݿ��Ա����е�Servlet���á�
		ServletContext ctx = getServletContext();
		System.out.println(
			ctx.getInitParameter("size"));
		//ʹ��context��ȡtomcat����ʱ��ʼ���ı�����
		//������+1�������û�context��
		Object obj = ctx.getAttribute("count");
		int c = new Integer(obj.toString())+1;
		ctx.setAttribute("count", c);
		//��ȡcontext�����µı���
		System.out.println(
			ctx.getAttribute("count"));
		
	}

	
	
}




