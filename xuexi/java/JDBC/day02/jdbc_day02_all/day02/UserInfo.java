package day02;
/**
 * ��һ�����ÿһ��ʵ��ר�������洢һϵ��
 * ���ݣ�ûû���κ�ҵ���߼���������ô����
 * ��ÿһ��ʵ������:ֵ���� VO ValueObject
 * 
 * ����ǰ���ÿһ��ʵ����ʾ�������ݿ���ĳ�ű��
 * һ����¼ʱ����ô����Ҳ��Ϊ:ʵ����
 * @author Administrator
 *
 */
public class UserInfo {
	private int id;
	private String username;
	private String password;
	private int account;
	private String email;
	
	public UserInfo(){
		
	}

	public UserInfo(int id, String username, String password, int account, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.account = account;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString(){
		return id+","+username+","+password+","+account+","+email;
	}
	
}
