package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import day01.DBUtil;

/**
 * �Զ���������
 * ��ʵ�ʿ����о����й������������磬�����һ�����ţ�
 * ����Ϊ�ò�����Ӽ���Ա����
 * ͨ�����������Զ����ɵģ�����ʹ�����У���ô��ͳ���
 * ��һ�����⣬���һ�����ź󣬸��������������ɲ�����
 * ��dept���У�������emp���в���ò���Ա��ʱ����emp
 * ���е�deptno�ֶ���Ҫ����ò��ŵĲ��ű�ţ���λ�ȡ
 * ������ű����һ�����⡣
 * @author Administrator
 *
 */
public class JDBCDemo3 {
	public static void main(String[] args) {
		try {
			Connection conn = DBUtil.getConnection();
			/*
			 * �ڲ���dept��Ϣ��ͬʱ�������ɵ�����
			 */
			String sql
				= "INSERT INTO dept "
				+ "(deptno,dname,loc)"
				+ "VALUES "
				+ "(seq_dept_id.NEXTVAL,?,?)";
			/*
			 * ����PreparedStatement��ͬʱ��ָ��
			 * ͨ����PSִ��SQL��Ӱ��ļ�¼�и����ֶΣ�
			 * �Ի�ȡ��ֵ
			 */
			PreparedStatement ps
				= conn.prepareStatement(
					sql, new String[]{"deptno"}
				);
			
			ps.setString(1, "IT");
			ps.setString(2, "BEIJING");
			int n = ps.executeUpdate();//��������
			if(n>0){
				//��ȡ����ĸ�����¼��ָ���ֶε�ֵ
				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				//��ȡ�˲���Ĳ�����Ϣ�Ĳ��źŵ�ֵ
				int id = rs.getInt(1);
				System.out.println("�ò��ź�:"+id);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection();
		}
		
	}
}









