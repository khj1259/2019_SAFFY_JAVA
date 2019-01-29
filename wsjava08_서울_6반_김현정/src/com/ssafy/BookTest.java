package com.ssafy;

import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		IBookMgrImpl mgr = new IBookMgrImpl();
		
		while(true) {
			System.out.println("<<< 도서관 관리 프로그램 >>>");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 전체 데이터 검색");
			System.out.println("3. Isbn로 정보 검색");
			System.out.println("4. 제목으로 검색");
			System.out.println("5. Book만 검색");
			System.out.println("6. Magazine만 검색");
			System.out.println("7. Magazine중 올해 잡지만 검색");
			System.out.println("8. 출판사로 검색");
			System.out.println("9. 가격으로 검색(주어진 가격보다 낮은 도서 검색)");
			System.out.println("10. 저장된 모든 도서의 금액 합계");
			System.out.println("11. 저장된 모든 도서의 금액 평균");
			System.out.println("0. 종료");
			System.out.println("원하는 번호를 선택하세요 > ");
			
			int menu = sc.nextInt();
			Book[] arr = null;
			Book b = null;
			switch (menu) {
			case 1:
				System.out.print("책/잡지 (b/m) :");
				String v = sc2.nextLine();
				System.out.print("isbn : ");
				String isbn = sc2.nextLine();
				System.out.print("title : ");
				String title = sc2.nextLine();
				System.out.print("author : ");
				String author = sc2.nextLine();
				System.out.print("publisher : ");
				String publisher = sc2.nextLine();
				System.out.print("price : ");
				int price = sc.nextInt();
				System.out.print("desc :");
				String desc = sc2.nextLine();
				if(v.equals("m")){
					System.out.print("year :");
					int year = sc.nextInt();
					System.out.print("month :");
					int month = sc.nextInt();
					
					b = new Magazine(isbn, title, author, publisher, year, month, price, desc);
				}else{
					b = new Book(isbn, title, author, publisher, price, desc);
				}
				
				mgr.add(b);
				break;
			case 2:
				for(Book book : mgr.search()) {
					System.out.println(book.toString());
				}
				break;
			case 3:
				System.out.print("검색할 Isbn > ");
				String isbn1 = sc2.nextLine();
				for(Book book : mgr.searchIsbn(isbn1)) {
					System.out.println(book.toString());
				}	
				break;
			case 4:
				System.out.print("검색할 도서제목 > ");
				String title1 = sc2.nextLine();
				for(Book book : mgr.searchTitle(title1)) {
					System.out.println(book.toString());
				}	
				break;
			case 5:
				for(Book book : mgr.searchBook()) {
					System.out.println(book.toString());
				}	
				break;
			case 6:
				for(Book book : mgr.searchMagazine()) {
					System.out.println(book.toString());
				}	
				break;
			case 7:
				for(Book book : mgr.search2019Mgz()) {
					System.out.println(book.toString());
				}
				break;
			case 8:
				System.out.print("검색할 출판사 > ");
				String publ = sc2.nextLine();
				for(Book book : mgr.searchPublisher(publ)) {
					System.out.println(book.toString());
				}
				break;
			case 9:
				System.out.print("검색할 가격 > ");
				int price1 = sc.nextInt();
				for(Book book : mgr.searchPrice(price1)) {
					System.out.println(book.toString());
				}
				break;
			case 10:
				System.out.println("전체 도서 금액 합계 : "+ mgr.totalPrice());
				break;
			case 11:
				System.out.println("전체 도서 금액 평균 : "+ mgr.avgPrice());
				break;
			case 0:
				
				break;
			default:
				System.out.println("잘못 입력 하셨습니다");
				break;
			}
			if(menu == 0) break;
		}
	}//end of main
}//end of class
