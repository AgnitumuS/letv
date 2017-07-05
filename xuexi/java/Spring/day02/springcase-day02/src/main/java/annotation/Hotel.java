package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * ��ʾ ʹ��@Autowired���������ע��
 * ����������ʽ��
 */
@Component("hotel")
public class Hotel {
	private Waiter wt;
	
	public Hotel() {
		System.out.println(
				"Hotel���޲ι�����...");
	}
	
	@Autowired
	public Hotel(@Qualifier("wt") Waiter wt) {
		System.out.println(
				"Hotel�Ĵ��ι�����...");
		this.wt = wt;
	}

	@Override
	public String toString() {
		return "Hotel [wt=" + wt + "]";
	}
	
}
