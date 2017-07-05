package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC��java�����ݿ�����
 * java�ṩ��һ��ͨ�õ��������ݿ�Ľ������
 * JDBC��һ�ױ�׼�Ľӿڡ���ͬ�����ݿ��ṩ�̶��ṩ��
 * һ��JDBC��ʵ���࣬����ʵ��������ͨ����Ϊ���ݿ��
 * ��������
 * �����ĺô����ڣ����ǵĳ���ֻ��Ҫ����JDBC�Ľӿڣ�
 * Ȼ�����ͳһ�ĵ��÷�ʽ�Ϳ����ˣ�������ݲ�ͬ�����ݿ�
 * ִ�в�ͬ�Ĵ��롣
 * JDBC�г��ýӿ�:
 * DriverManager
 * ������ز�ͬ���ݿ�������������������ݿ������
 * 
 * Connection
 * ��ʾ�����ݿ�����ӣ�������������봴��Statement
 * 
 * Statement
 * ����ִ��SQL���
 * 
 * ResultSet
 * ��ʾ��ѯ�������
 * 
 * JDBC�������ݿ�ʹ�ù���
 * 1:��������
 * 2:ͨ��DriverManager����������������(Connection)
 * 3:ͨ��Connection��������ִ��SQL��Statement
 * 4:ͨ��Statementִ��SQL���
 * 5:��ִ�е���DQL��䣬��ô���Ի�÷��صĲ�ѯ
 *   �����ResultSet,����ResultSet�Դﵽ��ȡ
 *   ��ѯ���ݵ�Ŀ�ġ�
 * 6:�����ظ�ִ��4,��ִ�в�ͬSQL���
 * 7:ȫ��������Ϻ�ر�Connection�ͷ���Դ��  
 * 
 * @author Administrator
 *
 */
public class JDBCDemo1 {
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
			
			String sql = "SELECT ename,job,sal,deptno FROM emp";
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
				
				System.out.println(ename+","+job+","+sal+","+deptno);
			}
			
			
			
			//�ر������ͷ���Դ
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}






