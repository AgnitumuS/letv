package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;

import day01.DBUtil;

/**
 * ʹ��PS������������
 * @author Administrator
 *
 */
public class JDBCDemo3 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			
			//��userinfo�в���1��������
			/*
			 * ʹ��Statement
			 */
//			Statement state = conn.createStatement();
//			for(int i=0;i<10000;i++){
//				String sql 
//					= "INSERT INTO userinfo "
//					+ "VALUES "
//					+ "(seq_userinfo_id.NEXTVAL,'user"+i+"','123456',5000,'user"+i+"@tedu.com')";
//				//ÿ��ִ�У����ݿ������һ��ִ�мƻ�!
//				state.executeUpdate(sql);
//			}
			
			/*
			 * ʹ��PreparedStatement
			 */
			String sql 
				= "INSERT INTO userinfo "
				+ "VALUES "
				+ "(seq_userinfo_id.NEXTVAL,?,"
				+ "'123456',5000,?)";
			//ֻ������һ��ִ�мƻ�!
			PreparedStatement ps
				= conn.prepareStatement(sql);
			
			for(int i=0;i<100;i++){
				ps.setString(1, "user"+i);
				ps.setString(2, "user"+i+"@tedu.com");
				ps.executeUpdate();
			}
			System.out.println("�������!");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection(conn);
		}
	}
}
