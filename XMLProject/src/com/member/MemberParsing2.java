package com.member;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MemberParsing2 {

	public static void main(String[] args) {
		MemberParsing2 m = new MemberParsing2();
		m.process();
	}

	private void process() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document doc = parser.parse("xml/member.xml");
			
			NodeList members = doc.getElementsByTagName("member");
			int length = members.getLength();
			for(int i=0; i<length; i++) {
				Node  member = members.item(i);//member 한사람
				NodeList child = member.getChildNodes();//모든 자식 노드
				
				for(int j=0; j<child.getLength(); j++) {
					Node child1 = child.item(j);
					String nodeName = child1.getNodeName();//노드이름
					if(nodeName.equals("name")) {
						//이름 출력
						System.out.println(child1.getLastChild().getNodeValue());
					}else if(nodeName.equals("address")) {
						//주소 출력
						System.out.println(child1.getLastChild().getNodeValue());
					}
				}
				
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
	}
}
