package annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ��ʾ ʹ��@Resource���������ע�롣
 *
 */
@Component("manager")
public class Manager {
	private Waiter wt;
	@Value("#{config.pagesize}")
	//@ValueҲ������ӵ���Ӧ��set����ǰ�档
	private String pageSize;
	@Value("����")
	//@ValueҲ��������ע��������͵�ֵ
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public Manager() {
		System.out.println(
				"Manager���޲ι�����...");
	}

	@Override
	public String toString() {
		return "Manager [wt=" + wt + ", pageSize=" + pageSize + ", name=" + name + "]";
	}

	public Waiter getWt() {
		return wt;
	}

	@Resource(name="wt")
	/*
	 * name����ָ����ע���bean��id,
	 * �����ָ�����ᰴ��byType�ķ�ʽ
	 * ��ע�롣
	 */
	public void setWt(Waiter wt) {
		System.out.println("Manager��setWt()...");
		this.wt = wt;
	}
	
}
