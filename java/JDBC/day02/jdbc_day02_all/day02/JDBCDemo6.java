package day02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import day01.DBUtil;

/**
 * �鿴�����Ԫ����
 * 
 * ��������˿��Բ鿴��ѯ�������⣬Ҳ���Բ鿴
 * ����������Ԫ���ݣ���:�鵽���ٸ��ֶΣ��ֶν�ʲô����
 * ����Ϣ
 * @author Administrator
 *
 */
public class JDBCDemo6 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			
			Statement state
				= conn.createStatement();
			
			String sql 
				= "SELECT * FROM userinfo";
			
			ResultSet rs 
				= state.executeQuery(sql);
			//��ȡ�����Ԫ���ݶ���
			ResultSetMetaData rsmd 
				= rs.getMetaData();
			//��ȡ�������ѯ���ֶ���
			int colCount 
				= rsmd.getColumnCount();
			System.out.println(
				"�ܹ���ѯ��:"+colCount+"���ֶ�");
			
			//�鿴ÿ���ֶε�����
			for(int i=1;i<=colCount;i++){
				String colName = rsmd.getColumnName(i);
				System.out.println(colName);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection(conn);
		}
	}
}








