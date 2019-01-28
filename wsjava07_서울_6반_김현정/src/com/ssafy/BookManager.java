package com.ssafy;

import java.util.Calendar;

public class BookManager {
	
	private Book[] books;
	private int index;
	
	public BookManager() {
		books  = new Book[100];
	}

	//1.데이터 입력
	public void add(Book b) {
		books[index] = b;
		index++;
	}
	
	//2.전체 데이터 검색
	public Book[] search() {
		return books;
	}
	
	//3.Isbn로 정보 검색
	public Book search(String isbn) {
		for(int i=0; i<books.length; i++) {
			if(books[i] != null && books[i].getIsbn().equals(isbn)) {
				return books[i];
			}
		}
		return null;
	}
	
	//4.제목으로 검색 (파라메터로 주어진 제목을 포함하는 모든 정보)
	public Book[] searchTitle(String title) {
		Book[] arr = new Book[100];
		int idx = 0;
		for(int i=0; i<books.length; i++) {
			if(books[i] != null && books[i].getTitle().contains(title)) {
				arr[idx] = books[i];
				idx++;
			}
		}
		return arr;
	}
	
	//5.Book만 검색
	public Book[] searchBook() {
		Book[] arr = new Book[100];
		int idx = 0;
		for(int i=0; i<books.length; i++) {
			if(books[i] != null && books[i].getClass().getSimpleName().equals("Book")) {
				arr[idx] = books[i];
				idx++;
			}
		}
		return arr;
	}
	
	//6.Magazine만 검색
	public Book[] searchMagazine() {
		Book[] arr = new Magazine[100];
		int idx = 0;
		for(int i=0; i<books.length; i++) {
			if(books[i] != null && books[i].getClass().getSimpleName().equals("Magazine")) {
				arr[idx] = books[i];
				idx++;
			}
		}
		return arr;
	}
	
	//7.Magazine중 올해 잡지만 검색
	public Magazine[] search2019Mgz() {
		Magazine[] arr = (Magazine[]) searchMagazine();
		Magazine[] result = new Magazine[100];
		int idx = 0;
		Calendar a = Calendar.getInstance();
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != null && arr[i].getYear() == a.get(Calendar.YEAR)) {
				result[idx] = arr[i];
				idx++;
			}
		}
		return result;
	}
	
	//8.출판사로 검색
	public Book[] searchPublisher(String publisher) {
		Book[] arr = new Book[100];
		int idx = 0;
		for(int i=0; i<books.length; i++) {
			if(books[i] != null && books[i].getPublisher().equals(publisher)) {
				arr[idx] = books[i];
				idx++;
			}
		}
		return arr;
	}
	
	//9.가격으로 검색(주어진 가격보다 낮은 도서 검색)
	public Book[] searchPrice(int price) {
		Book[] arr = new Book[100];
		int idx=0;
		for(int i=0; i<books.length; i++) {
			if(books[i] != null && books[i].getPrice() <= price) {
				arr[idx] = books[i];
				idx++;
			}
		}
		return arr;
	}
	
	//10.저장된 모든 도서의 금액 합계
	public int totalPrice() {
		int total = 0;
		for(int i=0; i<books.length; i++) {
			if(books[i] != null) {
				total += books[i].getPrice();
			}
		}
		return total;
	}
	
	//11.저장된 모든 도서의 금액 평균
	public double avgPrice() {
		double avg = 0;
		int total = totalPrice();
		avg = total / index;
		return avg;
	}
}
