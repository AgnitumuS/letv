package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondFilter implements Filter {

	public void destroy() {
		System.out.println("����SecondFilter");
	}

	public void doFilter(ServletRequest arg0, 
		ServletResponse arg1, FilterChain chain)
		throws IOException, ServletException {
		System.out.println("SecondFilterǰ");
		chain.doFilter(arg0, arg1);
		System.out.println("SecondFilter��");
	}

	//Tomcat����ʱ�Զ����ô˷����������ڵ���ǰ��
	//�����Filter����һ��config����Ȼ�����
	//config��ȡweb.xml�еĲ��������������
	public void init(FilterConfig cfg) throws ServletException {
		System.out.println("��ʼ��SecondFilter");
		System.out.println(
			cfg.getInitParameter("city"));
	}

}





