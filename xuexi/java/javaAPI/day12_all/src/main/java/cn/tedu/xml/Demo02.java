package cn.tedu.xml;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Demo02 {

	public static void main(String[] args) 
		throws Exception{
		//�����µ�XML Document ����
		Document doc = 
			DocumentHelper.createDocument();
		System.out.println(doc.asXML()); 
		//Ϊdoc��Ӹ�Ԫ��
		Element root =
			doc.addElement("students");
		System.out.println(doc.asXML()); 
		
		//Ϊ��Ԫ�������Ԫ��
		Element s1 = 
				root.addElement("student");
		s1.addElement("name").setText("Tom");
		s1.addAttribute("id", "s1");
		//...
		System.out.println(doc.asXML());
		//��docд���ļ�
		FileOutputStream out =
			new FileOutputStream("stu.xml");
		OutputFormat fmt = 
			OutputFormat.createPrettyPrint();
		XMLWriter writer = 
			new XMLWriter(out, fmt);
		writer.write(doc);
		writer.close();
	}

}







