package com.news;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class NewsParsing {
	public static void main(String[] args) {
		new NewsParsing().process();
	}//end of main

	private void process() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document doc = parser.parse("xml/news.xml");

			NodeList items = doc.getElementsByTagName("item");
			int length = items.getLength();
			for (int i = 0; i < length; i++) {
				Node item = items.item(i);
				NodeList childs = item.getChildNodes();

				for (int j = 0; j < childs.getLength(); j++) {
					Node child = childs.item(j);
					String nodeName = child.getNodeName();
					if (nodeName.equals("title")) {
						System.out.println(child.getLastChild().getNodeValue());
					} else if (nodeName.equals("pubDate")) {
						System.out.println(child.getLastChild().getNodeValue());
					}
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	}//end of process();
	
}//end of class
