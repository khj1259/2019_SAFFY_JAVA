package com.ssafy;

public class Magazine extends Book{
	private int year;
	private int month;
	
	public Magazine(String isbn, String title, String author, String publisher, int year, int month, int price,
			String desc) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}
	
	public Magazine(String isbn, String title, String author, String publisher, int year, int month, int price) {
		super(isbn, title, author, publisher, price);
		this.year = year;
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "Magazine [year=" + year + ", month=" + month + ", getIsbn()=" + getIsbn() + ", getTitle()=" + getTitle()
				+ ", getAuthor()=" + getAuthor() + ", getPublisher()=" + getPublisher() + ", getPrice()=" + getPrice()
				+ ", getDesc()=" + getDesc() + "]";
	}

	
	
	
}
