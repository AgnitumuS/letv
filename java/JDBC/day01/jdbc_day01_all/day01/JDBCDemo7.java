package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * �鿴Ա����Ϣ
 * empno,ename,sal,job,deptno
 * 
 * Ҫ���û���������ҳ����ÿҳ�鿴����Ŀ��
 * Ȼ��鿴����
 * ��:�鿴�ڶ�ҳ��ÿҳ��ʾ5�����鿴�����ݰ��չ��ʽ���
 * @author Administrator
 *
 */
public class JDBCDemo7 {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("������ÿҳ��ʾ����Ŀ��:");
			int pageSize = Integer.parseInt(scanner.nextLine());
			
			System.out.println("������ҳ��:");
			int page = Integer.parseInt(scanner.nextLine());
			
			int start = (page-1)*pageSize+1;
			int end = pageSize*page;
			
			
			
			//1 ��ͬ�����ݿ��ַ������ݲ�һ��
			Class.forName(
				"oracle.jdbc.driver.OracleDriver");
			
			//2 url��ͬ���ݿ��ʽ��ͬ
			Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@192.168.201.209:1521:orcl", 
				"fancq", 
				"zaq12wsx"
			);
			System.out.println("�������ݿ�ɹ�!");
			
			//3
			Statement state = conn.createStatement();
			/*
			 * SELECT *
			 * FROM(SELECT ROWNUM rn,t.*
			 *      FROM(SELECT empno,ename,sal,job,deptno
			 *           FROM emp
			 *           ORDER BY sal DESC) t
			 *      WHERE ROWNUM<=10)
			 * WHERE rn>=6
			 */
			String sql 
				= "SELECT * "+
			      "FROM(SELECT ROWNUM rn,t.* "+
				  "     FROM(SELECT empno,ename,sal,job,deptno "+
			      "          FROM emp "+
				  "          ORDER BY sal DESC) t "+
			      "     WHERE ROWNUM<="+end+") "+
				  "WHERE rn>="+start;
			System.out.println(sql);
			ResultSet rs = state.executeQuery(sql);
			while(rs.next()){
				int rn = rs.getInt("rn");
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				int sal = rs.getInt("sal");
				String job = rs.getString("job");
				int deptno = rs.getInt("deptno");
				System.out.println(rn+","+empno+","+ename+","+sal+","+job+","+deptno);
			}
			
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
			
			
			
	}
}
