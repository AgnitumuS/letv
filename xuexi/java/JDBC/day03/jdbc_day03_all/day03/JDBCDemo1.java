package day03;

import java.sql.Connection;
import java.sql.Statement;

import day01.DBUtil;

/**
 * ����ִ��SQL��䡣
 * ����������һ���������ݿ����˷�������SQL��䣬
 * �Ӷ����������ݿ����˵�����ͨѶ�����ִ��Ч�ʡ�
 * @author Administrator
 *
 */
public class JDBCDemo1 {
	public static void main(String[] args) {
		try {
			Connection conn = DBUtil.getConnection();
			Statement state = conn.createStatement();
			
			//��userinfo���в���100����¼
			for(int i=0;i<100;i++){
				String sql 
					= "INSERT INTO userinfo "
					+ "VALUES "
					+ "(seq_userinfo_id.NEXTVAL, "
					+ "'test"+i+"','123456',5000, "
					+ "'test"+i+"@tedu.cn')";
				//���̽�SQL���������ݿ�����
//				state.executeUpdate(sql);
				//���һ�����������൱���Ȼ����ڱ��ء�
				state.addBatch(sql);		
			}
			/*
			 * ִ������������֮ǰ���������SQL���
			 * һ���Է��͸����ݿ�����
			 * ������������Ч�ļ���������ô��������
			 * �����ݿ����˵�ͨѶЧ�ʡ�
			 */
			state.executeBatch();
			//��ձ����������б�
			state.clearBatch();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection();
		}
	}
}







