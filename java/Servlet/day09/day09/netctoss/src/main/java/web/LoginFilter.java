package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest req, 
		ServletResponse res, FilterChain chain)
		throws IOException, ServletException {
		//Tomcat�ǻ���HTTPЭ��ģ���˵������
		//request��response���Ǻ�HTTP��صġ�
		//��˿��Խ����ǽ���ת�͡�
		HttpServletRequest request = 
			(HttpServletRequest) req;
		HttpServletResponse response = 
			(HttpServletResponse) res;
		//�жϵ�ǰ�����Ƿ�Ϊ��Ҫ�ų���������
		//����ǣ��򲻶Դ�������м�顣
		String p = request.getServletPath();
		for(String path : paths) {
			if(p.equals(path)) {
				//��ǰ������Ҫ��飬
				//���������ִ�м��ɡ�
				chain.doFilter(request, response);
				return;
			}
		}
		//���Դ�session�л�ȡ�˺�
		HttpSession session = request.getSession();
		String adminCode = (String)
			session.getAttribute("adminCode");
		if(adminCode == null) {
			//δ��¼���ض��򵽵�¼ҳ��
			response.sendRedirect(
				request.getContextPath()+"/toLogin.do");
		} else {
			//�ѵ�¼���������ִ��
			chain.doFilter(request, response);
		}
	}

	//��Ҫ�ų���������·��
	private String[] paths;
	
	public void init(FilterConfig cfg) throws ServletException {
		String excludePath = 
			cfg.getInitParameter("excludePath");
		paths = excludePath.split(",");
	}

}




