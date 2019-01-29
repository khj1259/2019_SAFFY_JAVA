package com.ssafy;

import java.util.ArrayList;

public interface IBookMgr {
	public void add(Book b);
	public ArrayList<Book> search();
	
	public ArrayList<Book> searchIsbn(String isbn);
	public ArrayList<Book> searchTitle(String title);
	public ArrayList<Book> searchBook();
	public ArrayList<Magazine> searchMagazine();
	public ArrayList<Magazine> search2019Mgz();
	
	public ArrayList<Book> searchPublisher(String publisher);
	public ArrayList<Book> searchPrice(int price);
	public int totalPrice();
	public double avgPrice();
}
