package com.ssafy.news;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class NewsDAODOMImpl implements INewsDAO {

	List<News> list;

	public NewsDAODOMImpl() {
		list = new ArrayList<>();

	}

	@Override
	public List<News> getNewsList(String url) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document doc = parser.parse(url);

			NodeList items = doc.getElementsByTagName("item");
			for (int i = 0; i < items.getLength(); i++) {
				News n = new News();
				
				Node item = items.item(i);
				NodeList childs = item.getChildNodes();

				for (int j = 0; j < childs.getLength(); j++) {
					Node child = childs.item(j);
					String nodeName = child.getNodeName();
					if (nodeName.equals("title")) {
						n.setTitle(child.getLastChild().getNodeValue());
					} else if (nodeName.equals("description")) {
						n.setDesc(child.getLastChild().getNodeValue());
					} else if (nodeName.equals("link")){
						n.setLink(child.getLastChild().getNodeValue());
					}
				}
				list.add(n);
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public News search(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	private void connectNews(String url) {

	}

}
