package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import day01.DBUtil;

/**
 * Ҫ���û�����id�������ֵ���޸ĸ�id��Ӧ�û��������Ϣ��
 * @author Administrator
 *
 */
public class JDBCDemo5 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("������id:");
			int id = Integer.parseInt(scanner.nextLine());
			System.out.println("��������:");
			int account = Integer.parseInt(scanner.nextLine());
			
			conn = DBUtil.getConnection();
			String sql 
				= "UPDATE userinfo "
				+ "SET account=? "
				+ "WHERE id=?";
			PreparedStatement ps 
				= conn.prepareStatement(sql);
			
			ps.setInt(2, id);
			ps.setInt(1, account);
			int i = ps.executeUpdate();
			if(i>0){
				System.out.println("�޸ĳɹ�!");
			}else{
				System.out.println("�޸�ʧ��!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection(conn);
		}
	}
}
