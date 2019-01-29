package com.ssafy;

import java.util.ArrayList;

public interface IBookMgr {
	
	//도서 최초 입력 기능
	void add(Book b);
	//전체 도서 정보 출력 기능
	ArrayList<Book> search();
	//도서가 판매되어 재고 수량을 빼는 기능
	void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;
	//도서가 구매되어 재고 수량을 더하는 기능
	void buy(String isbn, int quantity) throws ISBNNotFoundException;
	//재고 도서들의 수량*금액을 하여 총 재고 금액을 구하여 리턴
	int getTotalAmount();
	//클래스 생성시에 호출디어 지며, 파일("book.dat")에 저장된 파일을 읽어서 ArayList에 저장
	void open();
	// 프로그램 종료시에 호출되어 지며, ArrayList에 있는 도서 정보를 파일로 저장한다.
	void close();
	//서버로 도서정보 전송
	void send();
}
