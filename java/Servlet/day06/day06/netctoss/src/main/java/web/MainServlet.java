package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CostDao;
import entity.Cost;

public class MainServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletPath();
		if("/findCost.do".equals(path)) {
			//��ѯ�����ʷ�
			findCost(req, res);
		} else if("/toAddCost.do".equals(path)) {
			//�������ʷ�ҳ
			toAddCost(req, res);
		} else {
			throw new RuntimeException(
				"��Ч�ķ���·��.");
		}
	}
	
	protected void toAddCost(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//ת��������ҳ��
		//��ǰ��/netctoss/toAddCost.do
		//Ŀ�꣺/netctoss/WEB-INF/cost/add.jsp
		req.getRequestDispatcher(
			"WEB-INF/cost/add.jsp")
			.forward(req, res);
	}
	
	protected void findCost(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		//��ѯ���е��ʷ�
		CostDao dao = new CostDao();
		List<Cost> list = dao.findAll();
		//ת������ѯҳ��
		//��ǰ��/netctoss/findCost.do
		//Ŀ�꣺/netctoss/WEB-INF/cost/find.jsp
		req.setAttribute("costs", list);
		req.getRequestDispatcher(
			"WEB-INF/cost/find.jsp")
			.forward(req, res);
	}
	
}







