package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * ִ��DDL���
 * ������userinfo
 * ���е��ֶ�:
 * id NUMBER(5)            id
 * username VARCHAR2(40)   �û���
 * password VARCHAR2(40)   ����
 * account NUMBER(8)       �˻����
 * email VARCHAR2(100)     ��������
 * @author Administrator
 *
 */
public class JDBCDemo2 {
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
				= "CREATE TABLE userinfo(" +
				  "   id NUMBER(5), " +
				  "   username VARCHAR2(40), " +
				  "   password VARCHAR2(40), " +
				  "   account NUMBER(8), " + 
				  "   email VARCHAR2(100)"+
				  ")";
			System.out.println(sql);
			
			state.execute(sql);
			System.out.println("�������!");
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}






