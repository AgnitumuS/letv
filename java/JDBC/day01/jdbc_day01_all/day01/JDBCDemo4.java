package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * �鿴ÿ��Ա���Ĺ��ţ����֣�ְλ��нˮ�����źţ�
 * �������ƣ��Լ��������ڵ�
 * 
 * SELECT e.empno,e.ename,e.job,e.sal,
 *        d.deptno,d.dname,d.loc
 * FROM emp e,dept d
 * WHERE e.deptno=d.deptno       
 * @author Administrator
 *
 */
public class JDBCDemo4 {
	public static void main(String[] args) {
		try {
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
			 * 4 Statement����ִ�е�SQL���Ĳ�ͬ
			 *   �ṩ����Ӧ�ļ���ִ�з���
			 *   
			 * boolean execute(String sql)
			 * ͨ������ִ��DDL��䣬��ʵ�����κ���䶼����
			 * �ø÷���ִ��
			 * 
			 * int executeUpdate(String sql)
			 * ר������ִ��DML��䣬����ֵΪִ�и�SQL��Ӱ��
			 * ���ݿ���ж���������
			 * 
			 * 
			 * ResultSet executeQuery(String sql)  
			 * ר������ִ��DQL��䣬����ֵΪ��ѯ�Ľ����  
			 */
			
			String sql = "SELECT e.empno,e.ename,e.job,e.sal,d.deptno,d.dname,d.loc FROM emp e,dept d WHERE e.deptno=d.deptno";
			//ִ�в�ѯ���
			ResultSet rs = state.executeQuery(sql);
			/*
			 * ���������
			 * ResultSet�ṩ�˷���:
			 * boolean next()
			 * �÷�����ʱ��ǰ��������±�ʾһ����¼����
			 * �����������һ����¼���ͱ�ʾ��������true,
			 * ��������Ѿ�û�м�¼�ˣ��򷵻�false��
			 * �ڱ��������ʱ��������ִ��һ��next������
			 * ��Ϊ�����ָ��Ĭ���ڵ�һ����¼֮�ϡ�
			 */
			while(rs.next()){
				/*
				 * ResultSet�ṩ�˻�ȡָ���ֶ�ֵ�ķ���
				 * String getString(String colName)
				 * int getInt(String colName)
				 * double getDouble(String colName)
				 * �����������͵���ط�������������ĸ����ֶ�
				 * ���;������ֶ����ַ������͵���getString
				 * �ֶ��������͵���getInt...
				 * 
				 * ����һ�����ط�����
				 * ��:getString(int index)
				 * ������ʾ�ڼ����ֶΣ���1��ʼ��
				 * 
				 */
				//��ȡԱ������
				String ename = rs.getString("ename");
				//��ȡְλ
				String job = rs.getString("job");
				//��ȡ����
				int sal = rs.getInt("sal");
				//��ȡ���ź�
				int deptno = rs.getInt("deptno");
				//������
				String dname = rs.getString("dname");
				//�������ڵ�
				String loc = rs.getString("loc");
				System.out.println(ename+","+job+","+sal+","+deptno+","+dname+","+loc);
			}
			
			
			
			//�ر������ͷ���Դ
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


