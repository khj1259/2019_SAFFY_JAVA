package com.member;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MemberParsing {

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		
		//dom tree 제일 위에 있는 가상 노드를 가리킴
		Document doc = parser.parse("xml/member.xml");
		
		//root 엘리먼트를 가리킴
		Element root = doc.getDocumentElement();
		
		System.out.println("well-formed xml!!!");
		
		//태그 이름 기준으로 검색
		NodeList names = root.getElementsByTagName("name");
		NodeList adds = root.getElementsByTagName("address");
		int length = names.getLength();
		int length2 = adds.getLength();
		
		for(int i=0; i<length; i++) {
			Node name = names.item(i); // name element 한개 <name>tommy</name>
			Node text = name.getFirstChild(); // text node 인 tommy가 나옴
			System.out.println(text.getNodeValue()); // text node에서 값을 뽑아야 하므로 getNodeValue()
		}
		
		for(int i=0; i<length2; i++) {
			Node address = adds.item(i);
			Node text = address.getFirstChild();
			System.out.println(text.getNodeValue());
		}
	}

}
