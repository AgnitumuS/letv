package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

/**
 * ��Servlet��������һ����ͨ������(��ɾ�Ĳ�)��
 * Ҫ�����Ƕ���.doΪ��׺��
 * 
 * ·���淶��
 * 	��ѯԱ����/findEmp.do
 * 	���ӱ���Ա����/addEmp.do
 */
public class MainServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//��ȡServlet����
		String path = req.getServletPath();
		//��������ж�
		if("/findEmp.do".equals(path)) {
			findEmp(req, res);
		} else if("/addEmp.do".equals(path)) {
			addEmp(req, res);
		} else {
			throw new RuntimeException(
				"�Ҳ��������Դ.");
		}
	}

	protected void findEmp(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//��ѯȫ��Ա��
		EmpDao dao = new EmpDao();
		List<Emp> list = dao.findAll();
		//�����Ӧ��Ϣ(����Ա��ƴtable)
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		//��ǰ��/EmpManager/findEmp
		//Ŀ�꣺/EmpManager/add_emp.html
		out.println("<input type='button' value='����' onclick='location.href=\"add_emp.html\"'/>");
		out.println("<table border='1px' width='40%' cellspacing='0'>");
		out.println("	<tr>");
		out.println("		<th>���</th>");
		out.println("		<th>����</th>");
		out.println("		<th>ְλ</th>");
		out.println("		<th>����</th>");
		out.println("	</tr>");
		for(Emp e : list) {
			out.println("<tr>");
			out.println("	<td>"+e.getEmpno()+"</td>");
			out.println("	<td>"+e.getEname()+"</td>");
			out.println("	<td>"+e.getJob()+"</td>");
			out.println("	<td>"+e.getSal()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.close();
	}	
	
	protected void addEmp(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//���ձ��е�����
		String ename = req.getParameter("ename");
		String job = req.getParameter("job");
		String sal = req.getParameter("sal");
		//����Щ���ݴ������
		Emp e = new Emp();
		e.setEname(ename);
		e.setJob(job);
		if(sal != null && !sal.equals("")) {
			e.setSal(new Double(sal));
		}
		EmpDao dao = new EmpDao();
		dao.save(e);
		//�����Ӧ��Ϣ
//			res.setContentType(
//				"text/html;charset=utf-8");
//			PrintWriter out = res.getWriter();
//			out.println("<p>����ɹ�</p>");
//			out.close();
		//�ض��򵽲�ѯ����
		//��ǰ��/EmpManager/addEmp.do
		//Ŀ�꣺/EmpManager/findEmp.do
		res.sendRedirect("findEmp.do");
	}
	
}









