package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * ִ��DML����
 * @author Administrator
 *
 */
public class JDBCDemo5 {
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
			
			String sql 
				= "INSERT INTO userinfo " + 
				  "(id,username,password,account,email) "+ 
				  "VALUES "+
				  "(seq_userinfo_id.NEXTVAL,'jack','123456',5000,'jack@tedu.cn')";
			System.out.println(sql);
			/*
			 * Ĭ������£�JDBC�Զ��ύ��������ÿ��ִ��
			 * DML��������ύ�ˡ�
			 */
			int i = state.executeUpdate(sql);
			if(i>0){
				System.out.println("����ɹ�!");
			}else{
				System.out.println("����ʧ��!");
			}
			
			
			
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}




