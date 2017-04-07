package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 	1.Filter��������������֮��Ĺ���ҵ��
 *    ���¼��־���������дʵȡ�
 *	2.ʹ��Filter������⣬�����޸��κ�Servlet��
 *	   ֻ��Ҫ�½�Filter�����ü��ɣ����Լ���̶�
 *    �Ľ���ҵ������Servlet֮�����϶ȡ�
 */
public class FirstFilter implements Filter {

	//��Tomcat�ر�ʱ�Զ�����Filter
	public void destroy() {
		System.out.println("����FirstFilter");
	}

	public void doFilter(ServletRequest req, 
		ServletResponse res, FilterChain chain)
		throws IOException, ServletException {
		System.out.println("FirstFilterǰ");
		//����doFilter()�����������ִ�У�
		//��û�е��ô˷����������жϣ�ֱ����Ӧ��
		//�������ִ�У�����ú�����Filter��
		//�����յ���Servlet���ڴ˹�����Filter
		//��Filter֮���������õģ������κ�
		//Filter�������жϣ����ᵼ�º�����Filter
		//�޷�ִ�У����ǹ�ϵ������һ����������ۣ�
		//��˸ö������������FilterChain��
		//������������ù���ͼ��
		chain.doFilter(req, res);
		System.out.println("FirstFilter��");
	}

	//Filter��Tomcat����ʱֻ��������ʼ��һ�Σ�
	//�������ǵ����ġ�
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("��ʼ��FirstFilter");
	}

}



