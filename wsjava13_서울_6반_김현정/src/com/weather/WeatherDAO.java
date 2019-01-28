package com.weather;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeatherDAO {

	private static WeatherDAO instance;

	List<Weather> list;// 파싱된 결과가 저장되어 있는 리스트
	String url = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1168064000";
	Document doc;

	private WeatherDAO() throws Exception {
		connectXML();
	}// constructor

	public static WeatherDAO getInstance() throws Exception {
		if (instance == null) {
			instance = new WeatherDAO();
		}
		return instance;
	}//end of getInstance()

	public void connectXML() throws Exception {
		list = new ArrayList<>();
		// 준비작업
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		doc = parser.parse(url);
	}// end of connectXML()

	public List<Weather> getWeatherList() {

		NodeList datas = doc.getElementsByTagName("data");

		for (int i = 0; i < datas.getLength(); i++) {
			Weather w = new Weather();
			Node data = datas.item(i);// data tag 한개

			NodeList childs = data.getChildNodes();// data tag 의 자식들

			for (int j = 0; j < childs.getLength(); j++) {
				Node child = childs.item(j);// 자식 노드중 한개.
				String nodeName = child.getNodeName();// 자식 노드 이름

				if (nodeName.equals("hour")) {
					w.setHour(child.getLastChild().getNodeValue());
				} else if (nodeName.equals("temp")) {
					w.setTemp(child.getLastChild().getNodeValue());
				} else if (nodeName.equals("wfKor")) {
					w.setWfKor(child.getLastChild().getNodeValue());
				} else if (nodeName.equals("reh")) {
					w.setReh(child.getLastChild().getNodeValue());
				}
			}
			list.add(w);
		}
		return list;

	}// end of getWeatherList();

}// end of class
