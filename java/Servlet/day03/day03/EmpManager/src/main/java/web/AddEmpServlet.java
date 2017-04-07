package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

public class AddEmpServlet extends HttpServlet {

	@Override
	protected void service(
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
//		res.setContentType(
//			"text/html;charset=utf-8");
//		PrintWriter out = res.getWriter();
//		out.println("<p>����ɹ�</p>");
//		out.close();
		//�ض��򵽲�ѯ����
		//��ǰ��/EmpManager/addEmp
		//Ŀ�꣺/EmpManager/findEmp
		res.sendRedirect("findEmp");
	}

	
	
}







