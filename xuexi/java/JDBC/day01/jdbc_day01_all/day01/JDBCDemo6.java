package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Ҫ���û������û��������룬�Լ�����
 * Ȼ��ʵ��ע�Ṧ��(�����û���Ϣ���뵽userinfo��
 * �У�idʹ����������)
 * @author Administrator
 *
 */
public class JDBCDemo6 {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("��ӭע��!");
			System.out.println("�������û���:");
			String username = scanner.nextLine();
			
			System.out.println("����������:");
			String password = scanner.nextLine();
			
			System.out.println("�����������ַ:");
			String email = scanner.nextLine();
			
			
			
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
				  "(seq_userinfo_id.NEXTVAL,'"+username+"','"+password+"',5000,'"+email+"')";
			System.out.println(sql);
			
			int i = state.executeUpdate(sql);
			if(i>0){
				System.out.println("ע��ɹ�!");
			}else{
				System.out.println("ע��ʧ��!");
			}
			
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}





