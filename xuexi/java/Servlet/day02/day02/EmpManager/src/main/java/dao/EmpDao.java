package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Emp;

public class EmpDao {
	
	/**
	 * ģ���ѯԱ��
	 */
	public List<Emp> findAll() {
		List<Emp> list = new ArrayList<Emp>();
		
		Emp e1 = new Emp();
		e1.setEmpno(1);
		e1.setEname("��ɮ");
		e1.setJob("�쵼");
		e1.setSal(9000.0);
		list.add(e1);
		
		Emp e2 = new Emp();
		e2.setEmpno(2);
		e2.setEname("���");
		e2.setJob("��ʦ��");
		e2.setSal(5000.0);
		list.add(e2);
		
		Emp e3 = new Emp();
		e3.setEmpno(3);
		e3.setEname("�˽�");
		e3.setJob("��ʦ��");
		e3.setSal(6000.0);
		list.add(e3);
		
		return list;
	}

}







