package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import day01.DBUtil;

/**
 * Statementͨ������ִ�о�̬SQL��䡣
 * ��̬SQL:SQL���ݲ������κζ�̬��Ϣ��
 * 
 * Statementִ�зǾ�̬SQL����������:
 * 1:��SQL����Ƕ�̬ƴ�ӵģ���ô�����SQLע�빥��
 * 2:��������ֵ�仯����SQL���岢û�б仯ʱ������ִ��
 *   ����SQL�������ݿ����ܿ�����
 *   
 *   
 * PreparedStatement
 * ר������ִ�к��ж�̬���ݵ�SQL��䡣
 * �����Statementִ�ж�̬SQL���������㡣
 * 
 * PSִ�е���Ԥ����SQL������̬��Ϣ��"?"����ʽռλ��
 * ���ݿ��ڽ���Ԥ����SQL�󣬻�����ִ�мƻ������ǽ�����
 * �Ĺ������Ǵ��붯̬��Ϣ���ɣ����ִ��Ҳ�޷Ǿ��Ƕ��
 * ���붯̬��Ϣ�����ǿ�������ͬһ��ִ�мƻ��ˡ�
 * �ͺ���JAVA�����ж��巽������̬��Ϣ������Ϊ������
 * ��ε��÷������벻ͬ�������ɣ����Ƿ�������ÿ�ζ�
 * ���¶��塣
 *   
 *   
 * @author Administrator
 *
 */
public class JDBCDemo2 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			
			String sql 
				= "SELECT id,username,password,account,email "
				+ "FROM userinfo "
				+ "WHERE username=? AND password=? ";
			/*
			 *	�ڴ���PS��ͬʱ��Ҫ��Ԥ����SQL��䴫�룬��
			 *  ͨ��Connectionר�ݸ����ݿ��ˣ���ʱ�����ݿ�
			 *  �Ὣִ�мƻ����ɣ����ǲ�����ִ�иüƻ�����Ϊ
			 *  ������Ȼȷ���ˣ����ǻ�ȱ�پ�������ݡ� 
			 */
			PreparedStatement ps
				= conn.prepareStatement(sql);
			
			ps.setString(1,"jack");
			ps.setString(2, "1' OR '1'='1");
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				int account = rs.getInt("account");
				System.out.println("��ӭ��!�������Ϊ:"+account);
			}else{
				System.out.println("�û������������!");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection(conn);
		}
	}
}







