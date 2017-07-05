package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiServlet extends HttpServlet {
	
	private Double sal = 1000.0;

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		synchronized(this) {
			//��н
			sal += 100.0;
			//���������ӳ�8S
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//����������
			res.setContentType(
					"text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<p>����:"+sal+"</p>");
			out.close();
		}
	}

	
	
}






