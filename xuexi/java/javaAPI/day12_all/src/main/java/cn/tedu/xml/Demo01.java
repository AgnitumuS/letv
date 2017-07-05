package cn.tedu.xml;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Demo01 {

	public static void main(String[] args) 
		throws Exception {
		SAXReader reader = new SAXReader();
		FileInputStream in =
			new FileInputStream("demo.xml");
		//��ȡXML�ļ���doc����
		Document doc=reader.read(in);
		//doc ��ȫ����XML�ļ�������
		//doc ���õ����ڴ��еĶ���
		//System.out.println(doc.asXML()); 
		
		//��ȡXML�ĸ�Ԫ��
		//����XML�����ݵ�Ψһ��ڡ�
		Element root = doc.getRootElement();
		//System.out.println(root.asXML()); 
		
		//�����ֲ��ҷ��ص�һ��������������Ԫ��
		//Element e = root.element("book");
		//System.out.println(e.asXML());
		
//		List<Element> list=root.elements();
//		for(Element e:list){
//			//System.out.println(e.asXML());
//			System.out.println(e.getName()); 
//		}
		
		Element e = root.element("book");
		Element n = e.element("name");
		System.out.println(n.asXML());
		System.out.println(n.getText()); 
		
		Attribute attr = e.attribute("id");
		System.out.println(attr.asXML());
		System.out.println(attr.getName());
		System.out.println(attr.getValue()); 
		
		
		//����޸���doc, ����ʵ���޸�XML��д�ļ�
		Element newOne=root.addElement("book");
		newOne.addElement("name")
			.setText("18�����һ������");
		newOne.addElement("author")
			.setText("����"); 
		newOne.addAttribute("id", "b5");
		newOne.addAttribute("lang", "����"); 
		
		//�ҵ���Ԫ�ز���ɾ�������Ԫ��
		Element book = root.element("book");
		root.remove(book);
		
		Element b2 = root.element("book");
		//�޸�Ԫ�ص�����
		Element author = b2.element("author");
		author.setText("����"); 
		//�޸�����
		Attribute id = b2.attribute("id");
		id.setValue("b8"); 
		
		//дXML Document ���� ���ļ���
		FileOutputStream out = 
			new FileOutputStream("ok.xml");
		//dom4j �ṩ�˸�ʽ���ߣ��������ʱ��
		//��doc���л�ױ����Ư����Pretty��һЩ
		OutputFormat fmt = 
			OutputFormat.createPrettyPrint();
		//XMLWriter ��dom4j �ṩ�ĸ߼�����
		//��Ҫ�����ͼ����ֽ�����
		XMLWriter writer = 
			new XMLWriter(out, fmt);
		//��doc����XML��д������
		writer.write(doc);
		writer.close();
		
		
		
	}
}





