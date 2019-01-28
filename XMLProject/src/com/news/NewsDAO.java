package com.news;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewsDAO {
	List<News> list;// 파싱된 결과가 저장되어 있는 리스트
	String url = "http://api.newswire.co.kr/rss/industry/600";
	Document doc;

	public NewsDAO() throws Exception {
		list = new ArrayList<>();
		
		// 준비작업
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
//		InputStream is = new URL(url).openConnection().getInputStream();
//		doc = parser.parse(is);
		doc = parser.parse(url);
	}//constructor

	public List<News> getNewsData() throws Exception{

		NodeList items = doc.getElementsByTagName("item");
		
		for (int i = 0; i < items.getLength(); i++) {
			News w = new News();
			Node item = items.item(i);//item tag 한개
			
			NodeList childs = item.getChildNodes();//item tag 의 자식들

			for (int j = 0; j < childs.getLength(); j++) {
				Node child = childs.item(j);// 자식 노드중 한개. ex) <title></title>
				String nodeName = child.getNodeName();//자식 노드 이름 ex) title
				
				if (nodeName.equals("title")) {
					w.setTitle(child.getLastChild().getNodeValue());
				} else if (nodeName.equals("pubDate")) {
					w.setPubDate(child.getLastChild().getNodeValue());
				}
			}
			list.add(w);
		}
		return list;

	}// end of process();

}// end of class
