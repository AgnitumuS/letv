package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import day01.DBUtil;

/**
 * 
 * ����IDɾ���û�
 * 
 * DELETE FROM userinfo
 * WHERE id=?
 * 
 * @author Administrator
 *
 */
public class JDBCDemo4 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("������Ҫɾ�����û�ID");
			int id = Integer.parseInt(scanner.nextLine());
			
			conn = DBUtil.getConnection();
			
			String sql 
				= "DELETE FROM userinfo "
				+ "WHERE id=?";
			
			PreparedStatement ps
				= conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			if(i>0){
				System.out.println("ɾ���ɹ�!");
			}else{
				System.out.println("ɾ��ʧ��!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection(conn);
		}
	}
}




