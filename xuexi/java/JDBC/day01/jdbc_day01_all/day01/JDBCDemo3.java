package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * ����һ������ seq_userinfo_id
 * ���д�1��ʼ������Ϊ1
 * 
 * CREATE SEQUENCE seq_userinfo_id
 * START WITH 1
 * INCREMENT BY 1
 * @author Administrator
 *
 */
public class JDBCDemo3 {
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
			
			//4
			String sql 
				= "CREATE SEQUENCE seq_userinfo_id " +
				  "   START WITH 1 " +
				  "   INCREMENT BY 1 ";
			System.out.println(sql);
			
			state.execute(sql);
			System.out.println("���д������!");
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
