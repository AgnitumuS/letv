package annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * ��ʾ ���ɨ��
 * 	
 * 	Ĭ�ϵ�id������ĸСд֮���������
 */
@Component("stu")
@Scope("singleton")
@Lazy(true)
public class Student {
	
	@PostConstruct
	//��ʼ������
	public void init(){
		System.out.println(
				"Student��init()...");
	}
	
	@PreDestroy
	//���ٷ���
	public void destroy(){
		System.out.println(
				"Student��destroy()...");
	}

	public Student() {
		System.out.println(
				"Student���޲ι�����...");
	}

}


