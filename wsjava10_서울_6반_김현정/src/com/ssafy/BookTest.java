package com.ssafy;

import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		BookMgrImpl mgr = new BookMgrImpl();
		
		boolean systemON = true;
		while(systemON) {
			System.out.println("<<< 도서 재고 관리 프로그램 >>>");
			System.out.println("1. 최초 도서 정보 입력");
			System.out.println("2. 전체 도서 검색");
			System.out.println("3. 도서 판매");
			System.out.println("4. 도서 구매");
			System.out.println("5. 총 재고 금액");
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
				System.out.print("price : ");
				int price = sc.nextInt();
				System.out.print("quantity :");
				int quantity = sc.nextInt();
				if(v.equals("m")){
					System.out.print("month :");
					int month = sc.nextInt();
					b = new Magazine(isbn, title, price, quantity, month);
				}else{
					b = new Book(isbn, title, price, quantity);
				}
				mgr.add(b);
				break;
			case 2:
				for(Book book : mgr.search()) {
					System.out.println(book.toString());
				}
				break;
			case 3:
				System.out.print("판매한 도서의 Isbn > ");
				String isbn1 = sc2.nextLine();
				System.out.print("판매 권수 > ");
				int quantity1 = sc.nextInt();
				try {
					mgr.sell(isbn1, quantity1);
				} catch (QuantityException | ISBNNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.print("구매한 도서의 Isbn > ");
				String isbn11 = sc2.nextLine();
				System.out.print("구매 권수 > ");
				int quantity11 = sc.nextInt();
				try {
					mgr.buy(isbn11, quantity11);
				} catch (ISBNNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.println("총 재고 금액 : "+mgr.getTotalAmount());
				break;
			case 0:
				systemON = false;
				mgr.close();
				break;
			default:
				System.out.println("잘못 입력 하셨습니다");
				break;
			}
		}
	}//end of main
}//end of class
