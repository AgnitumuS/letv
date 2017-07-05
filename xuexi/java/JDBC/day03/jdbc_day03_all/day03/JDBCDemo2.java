package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;

import day01.DBUtil;

/**
 * ��������ִ��SQL���ʱ��Ӱ��Ч�ʵ���������:
 * 1:��������Խ���ٶ�Խ��
 * 2:������ã��������Խ���ٶ�Խ��
 * 3:Statement��PreparedStatement��ѡ�ã�
 *   ��Ϊִ�мƻ�Խ��Ч��Խ��
 * @author Administrator
 *
 */
public class JDBCDemo2 {
	public static void main(String[] args) {
		try {
			Connection conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql 
				= "INSERT INTO userinfo "
				+ "VALUES "
				+ "(seq_userinfo_id.NEXTVAL, "
				+ "?,'123456',5000,?)";
			PreparedStatement ps
				= conn.prepareStatement(sql);
			for(int i=0;i<100;i++){
				ps.setString(1, "test"+i);
				ps.setString(2, "test"+i+"@tedu.cn");
				ps.addBatch();
			}
			ps.executeBatch();
			ps.clearBatch();
			conn.commit();
			System.out.println("ִ�����!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection();
		}
	}
}








