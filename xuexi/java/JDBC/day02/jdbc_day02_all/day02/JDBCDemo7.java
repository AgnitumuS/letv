package day02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import day01.DBUtil;

/**
 * ������ѯ�����
 * ResultSet
 * 
 * ͨ���Խ�����ı�����һ���Եġ���ϣ���ظ�ʹ�ý����
 * �е����ݣ������Ƚ�����������õ��Ľ����java����
 * ����ʽȫ������������Ȼ���ظ�ʹ�á�
 * JDBC�ṩ��һ�ֽ����ɹ������������˼�Ǹý��������
 * ���ز鿴ÿһ����¼�����ǻ������á�
 * @author Administrator
 *
 */
public class JDBCDemo7 {	
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			Statement state = conn.createStatement();
			String sql 
				= "SELECT id,username,password,account,email "
				+ "FROM userinfo";
			
			ResultSet rs = state.executeQuery(sql);
			
			List<UserInfo> list = new ArrayList<UserInfo>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int account = rs.getInt("account");
				String email = rs.getString("email");
				UserInfo userInfo = new UserInfo(id,username,password,account,email);
				list.add(userInfo);
			}
			
			for(UserInfo u : list){
				System.out.println(u);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection(conn);
		}
	}
}








	


