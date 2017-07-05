package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * ��ʾ ʹ��@Autowired�����
 * ����ע��(set����)��
 */
@Component("rest")
public class Restaurant {
//	@Autowired
//	@Qualifier("wt")
	/*
	 * ������ע��Ҳ����ֱ����ӵ�����ǰ�档
	 * ��ʱ����Ӧ��set�������Բ�Ҫ��
	 */
	private Waiter wt;
	
	public Restaurant() {
		System.out.println(
				"Restaurant���޲ι�����...");
	}

	@Override
	public String toString() {
		return "Restaurant [wt=" + wt + "]";
	}

	public Waiter getWt() {
		return wt;
	}

	@Autowired  
	/*
	 * ���û��ʹ��@Qualifier��ָ����ע���
	 * bean��id,��spring����Ĭ�ϻᰴ��byType
	 * �ķ�ʽ�����ע�롣
	 */
	public void setWt(@Qualifier("wt") Waiter wt) {
		System.out.println(
				"Restaurant��setWt()...");
		this.wt = wt;
	}
	
}
