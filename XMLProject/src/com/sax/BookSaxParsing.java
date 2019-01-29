package com.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//sax parser 이용 : event 발생시마다 처리
public class BookSaxParsing extends DefaultHandler {

	public BookSaxParsing() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser;
		try {
			parser = factory.newSAXParser();
			// this:parsing 도중 발생하는 사건처리를 담당할 객체
//			parser.parse("xml/book.xml", this);
			parser.parse("xml/book.xml", new FindBookEventHandler("author", "이규미"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//문서의 시작인 경우
	@Override
	public void startDocument() throws SAXException {
		System.out.println("document 시작!");
	}

	//문서의 끝인 경우
	@Override
	public void endDocument() throws SAXException {
		System.out.println("document 끝!");
	}

	// uri와 localName은 네임스페이스가 없어서 사용하지 않음, qName:태그이름 , attributes:태그의 속성
	// 문서에서 시작 태그(엘리먼트)를 만났을 때
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("booklist")) {
			System.out.println("<booklist>");
		} else if (qName.equals("book")) {
			System.out.println("<book kind="+attributes.getValue("kind")+">");

		} else if (qName.equals("title")) {
			System.out.println("<title>");

		} else if (qName.equals("author")) {
			System.out.println("<author>");

		} else if (qName.equals("publisher")) {
			System.out.println("<publisher>");

		} else if (qName.equals("price")) {
			System.out.println("<price>");
			
		} else if (qName.equals("isbn")) {
			System.out.println("<isbn>");
		}
	}

	//문서에서 닫는 태그(끝나는 엘리먼트)를 만났을 때
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("booklist")) {
			System.out.println("</booklist>");

		} else if (qName.equals("book")) {
			System.out.println("</book>");

		} else if (qName.equals("title")) {
			System.out.println("</title>");

		} else if (qName.equals("author")) {
			System.out.println("</author>");

		} else if (qName.equals("publisher")) {
			System.out.println("</publisher>");

		} else if (qName.equals("price")) {
			System.out.println("</price>");
			
		} else if (qName.equals("isbn")) {
			System.out.println("</isbn>");
		}
	}

	//문서 중간에 text node 만나는 경우 호출됨
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String str = new String(ch, start, length);
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		new BookSaxParsing();

	}// main

}// class
