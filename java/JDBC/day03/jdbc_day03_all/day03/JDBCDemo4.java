package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import day01.DBUtil;

/**
 * Ҫ���û�����һ��������Ϣ:���������������ڵ�
 * Ȼ����Ҫ���û�Ϊ�ò�������3��Ա��:����,ְλ,����
 * ÿ��Ա������empno,ename,job,sal,deptno�ֶ�
 * ��ɺ�dept����Ӧ����һ���¼�¼��emp����Ӧ����3����
 * ��¼��Ҫ����һ�������н��С�
 * 
 * �����벿����:
 * IT
 * �����벿�����ڵ�:
 * BEIJING
 * 
 * �������1��Ա����Ϣ:
 * jack,CLERK,5000
 * �������2��Ա����Ϣ:
 * jackson,CLERK,5000
 * �������3��Ա����Ϣ:
 * rose,CLERK,5000
 * 
 * �������!
 * @author Administrator
 *
 */
public class JDBCDemo4 {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("�����벿����Ϣ:");
			System.out.println("�����벿������:");
			String dname = scanner.nextLine();
			System.out.println("�����벿�����ڵ�:");
			String loc = scanner.nextLine();
			
			System.out.println("������Ҫ�����Ա������:");
			int sum = Integer.parseInt(scanner.nextLine());
			
			List<String> empInfos = new ArrayList<String>();
			for(int i=1;i<=sum;i++){
				System.out.println("�������"+i+"��Ա����Ϣ:");
				String empInfo = scanner.nextLine();
				empInfos.add(empInfo);
			}		
			Connection conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String deptSql 
				= "INSERT INTO dept "
				+ "(deptno,dname,loc) "
				+ "VALUES "
				+ "(seq_dept_id.NEXTVAL,?,?)";
			PreparedStatement deptPs
				= conn.prepareStatement(deptSql,new String[]{"deptno"});
			deptPs.setString(1, dname);
			deptPs.setString(2, loc);
			int n = deptPs.executeUpdate();
			if(n>0){
				//��ȡ���ŵ�ID
				ResultSet rs = deptPs.getGeneratedKeys();
				rs.next();
				int deptno = rs.getInt(1);
				/*
				 * Statementʹ����Ϻ���Թر��ͷ���Դ��
				 * ������Ҫע�⣬��ʹ��Statement��ȡ��һ��
				 * �����������Statement�رգ���ô�ý����
				 * Ҳ���Զ��ر�!���ԣ�Ӧ���ڱ�������������
				 * �ر�Statement��PreparedStatementҲһ��
				 */
				deptPs.close();
				
				String empSql 
					= "INSERT INTO emp "
					+ "(empno,ename,job,sal,deptno) "
					+ "VALUES "
					+ "(seq_emp_id.NEXTVAL,?,?,?,?)";
				PreparedStatement empPs
					= conn.prepareStatement(empSql);
				for(String empInfo : empInfos){
					String[] infos = empInfo.split(",");
					empPs.setString(1, infos[0]);
					empPs.setString(2, infos[1]);
					empPs.setInt(3, Integer.parseInt(infos[2]));
					empPs.setInt(4, deptno);
					empPs.executeUpdate();
				}
				System.out.println("�������!");
				conn.commit();	
			}						
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection();
		}
	}
}










