package day03;

import java.util.List;
import java.util.Scanner;

import day02.UserInfo;

/**
 * ����û�������ҵ���߼���
 * @author Administrator
 *
 */
public class UserInfoService {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("��ӭ�����û�����ϵͳ��");
		System.out.println("������Ҫ���������:");
		System.out.println("1:ע�����");
		System.out.println("2:��¼����");
		System.out.println("3:�鿴�����û�����");
		System.out.println("4:��ҳ�鿴�û���Ϣ����");
		System.out.println("5:�޸��û�����");
		System.out.println("6:ɾ���û�����");
		System.out.println("7:ת�˲���");
		
		int index = Integer.parseInt(scanner.nextLine());
		switch(index){
			case 1:
				reg();
				break;
			case 2:
				login();
				break;
			case 3:
				showAll();
				break;
			case 4:
				showAllByPage();
				break;
			case 5:
				
			case 6:	
				
			case 7:		
		}
	}
	public static void showAllByPage(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ÿҳ��ʾ������:");
		int pageSize = Integer.parseInt(scanner.nextLine());
		System.out.println("������Ҫ�鿴��ҳ:");
		int page = Integer.parseInt(scanner.nextLine());
		UserInfoDAO dao = new UserInfoDAO();
		List<UserInfo> list = dao.findAllByPage(page, pageSize);
		for(UserInfo userInfo : list){
			System.out.println(userInfo);
		}
	}
	
	/**
	 * �鿴�����û���ҵ���߼�
	 */
	public static void showAll(){
		UserInfoDAO dao = new UserInfoDAO();
		List<UserInfo> list = dao.findAll();
		System.out.println("�û���:"+list.size()+"��");
		for(UserInfo userInfo : list){
			System.out.println(userInfo);
		}
	}
	
	/**
	 * ע�Ṧ�ܵ�ҵ���߼�
	 */
	public static void reg(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("��ӭע��:");
		System.out.println("�������û���:");
		String username = scanner.nextLine();
		System.out.println("����������:");
		String password = scanner.nextLine();
//		System.out.println("���ظ�����:");
//		String repassword = scanner.nextLine();
		System.out.println("����������:");
		String email = scanner.nextLine();
		
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(username);
		userInfo.setPassword(password);
		userInfo.setEmail(email);
		userInfo.setAccount(5000);
		
		UserInfoDAO dao = new UserInfoDAO();
		boolean tf = dao.save(userInfo);
		if(tf){
			System.out.println("ע��ɹ�!");
		}else{
			System.out.println("ע��ʧ��!");
		}
	}
	/**
	 * ��¼���ܵ�ҵ���߼�����
	 */
	public static void login(){
		
	}
}






