package com.ssafy2;

public class BookTest {

	public static void main(String[] args) {
		
		Book[] bookList = new Book[5];
		Magazine[] magaList = new Magazine[5];
		
		bookList[0] = new Book("21424", "Java Pro", "김하나", "Jaen.kr", 15000, "Java 기본문법");
		bookList[1] = new Book("33455", "JDBC Pro", "김철수", "Jaen.kr", 23000);
		bookList[2] = new Book("55355", "Servlet/JSP", "박자바", "Jaen.kr", 41000, "Model2 기반");
		bookList[3] = new Book("35332", "Android App", "홍길동", "Jaen.kr", 25000, "Lightweight Framework");
		bookList[4] = new Book("35355", "OOAD 분석,설계", "소나무", "Jaen.kr", 30000);
		
		magaList[0] = new Magazine("35535", "Java World", "편집부", "Jaen.kr", 2013, 2, 7000);
		magaList[1] = new Magazine("33434", "Mobile World", "편집부", "Jaen.kr", 2013, 8, 8000);
		magaList[2] = new Magazine("75342", "Next Web", "편집부", "Jaen.kr", 2012, 8, 10000, "AJAX 소개");
		magaList[3] = new Magazine("76543", "Architecture", "편집부", "Jaen.kr", 2010, 8, 5000, "java 시스템");
		magaList[4] = new Magazine("76534", "Data Modeling", "편집부", "Jaen.kr", 2012, 8, 14000);
		
		System.out.println("**************************** 도서 목록 **************************");
		for(Book b : bookList) {
			System.out.println(b.toString());
		}
		
		System.out.println("**************************** 잡지 목록 **************************");
		for(Magazine m : magaList) {
			System.out.println(m.toString());
		}
	}
}
