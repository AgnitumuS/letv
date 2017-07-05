package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import day01.DBUtil;

/**
 * ת�˲���
 * ���������û�����Ȼ�����һ��ת�˽�����Ϊ:
 * ��һ���û����ڶ����û�ת��ָ���Ľ�
 * 
 * jack
 * rose
 * 5000
 * 
 * 95000
 * 105000
 * 
 * UPDATE userinfo
 * SET account=account+?       ת��
 * WHERE username=?
 * 
 * UPDATE userinfo
 * SET account=account-?       ת��
 * WHERE username=?
 * 
 * @author Administrator
 *
 */
public class JDBCDemo9 {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("������ת���˺�:");
			String outUser = scanner.nextLine();
			
			System.out.println("������ת���˺�:");
			String inUser = scanner.nextLine();
			
			System.out.println("������ת�˽��:");
			int account = Integer.parseInt(
							scanner.nextLine());
			/*
			 * JDBC�л�ȡConnectionʱ��Ĭ�����Զ��ύ����ģ�
			 * Ҳ����˵ֻҪִ��һ��SQL�����ύһ������
			 * 
			 */
			Connection conn = DBUtil.getConnection();
			/*
			 * ȡ���Զ��ύ����
			 */
			conn.setAutoCommit(false);
			//ת������
			String sqlOut 
				= "UPDATE userinfo "
				+ "SET account = account-? "
				+ "WHERE username=?";
			PreparedStatement psOut
				= conn.prepareStatement(sqlOut);
			psOut.setInt(1, account);
			psOut.setString(2, outUser);
			int n = psOut.executeUpdate();
			if(n>0){
				System.out.println("ת���������");
			}else{
				System.out.println("ת������ʧ��");
				System.out.println("ת��ʧ��!");
				return;
			}
			//ת�����
			String sqlIn
				= "UPDATE userinfo "
				+ "SET account=account+? "
				+ "WHERE username=?";
			PreparedStatement psIn
				= conn.prepareStatement(sqlIn);
			psIn.setInt(1, account);
			psIn.setString(2, inUser);
			n = psIn.executeUpdate();
			if(n>0){
				System.out.println("ת��������");
				System.out.println("ת�����!");
				//�ύ����
				conn.commit();
			}else{
				System.out.println("ת�����ʧ��");
				System.out.println("ת��ʧ��");
				//�ع�����
				conn.rollback();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection();
		}
	}
}








