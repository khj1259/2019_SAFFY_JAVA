package com.ssafy;

import java.util.ArrayList;

public class IBookMgrImpl implements IBookMgr{
	ArrayList<Book> list;
	
	public IBookMgrImpl() {
		list = new ArrayList<>();
	}
	
	@Override
	public void add(Book b) {
		list.add(b);
	}

	@Override
	public ArrayList<Book> search() {
		return list;
	}

	@Override
	public ArrayList<Book> searchIsbn(String isbn) {
		ArrayList<Book> tmp = new ArrayList<>();
		
		for(Book b : list) {
			if(b.getIsbn().equals(isbn)) {
				tmp.add(b);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Book> searchTitle(String title) {
		ArrayList<Book> tmp = new ArrayList<>();
		
		for(Book b : list) {
			if(b.getTitle().equals(title)) {
				tmp.add(b);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Book> searchBook() {
		ArrayList<Book> tmp = new ArrayList<>();
		
		for(Book b : list) {
			if(!(b instanceof Magazine)) {
				tmp.add(b);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Magazine> searchMagazine() {
		ArrayList<Magazine> tmp = new ArrayList<>();
		
		for(Book b : list) {
			if(b instanceof Magazine) {
				tmp.add((Magazine) b);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Magazine> search2019Mgz() {
		ArrayList<Magazine> tmp = new ArrayList<>();
		
		for(Magazine b : searchMagazine()) {
			if( b.getYear() == 2019) {
				tmp.add(b);
			}
		}
		return tmp;
	}
	
	@Override
	public ArrayList<Book> searchPublisher(String publisher) {
		ArrayList<Book> tmp = new ArrayList<>();
		
		for(Book b : list) {
			if(b.getPublisher().equals(publisher)) {
				tmp.add(b);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Book> searchPrice(int price) {
		ArrayList<Book> tmp = new ArrayList<>();
		
		for(Book b : list) {
			if(b.getPrice() <= price) {
				tmp.add(b);
			}
		}
		return tmp;
	}

	@Override
	public int totalPrice() {
		int total=0;
		for (Book b : list) {
			total += b.getPrice();
		}
		return total;
	}

	@Override
	public double avgPrice() {
		int total = totalPrice();
		double avg = total / list.size();
		return avg;
	}

}
