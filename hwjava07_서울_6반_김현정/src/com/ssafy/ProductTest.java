package com.ssafy;

import java.util.Scanner;

public class ProductTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		ProductMgr mgr = new ProductMgr();
		
		while(true) {
			System.out.println("<<< 재고 관리 프로그램 >>>");
			System.out.println("1. 상품 정보 입력");
			System.out.println("2. 상품 정보 전체 검색");
			System.out.println("3. 상품번호로 검색");
			System.out.println("4. 상품명으로 검색");
			System.out.println("5. Tv정보만 검색");
			System.out.println("6. 냉장고만 검색");
			System.out.println("7. 400L 이상의 냉장고 검색");
			System.out.println("8. 50inch 이상의 TV 검색");
			System.out.println("9. 상품 가격 변경");
			System.out.println("10. 상품  삭제");
			System.out.println("11. 전체 재고 상품 금액");
			System.out.println("0. 종료");
			System.out.println("원하는 번호를 선택하세요 > ");
			
			int menu = sc.nextInt();
			Product[] arr = null;
			Product p = null;
			switch (menu) {
			case 1:
				System.out.print("냉장고/TV? (r/t) :");
				String v = sc2.nextLine();
				System.out.print("제품번호 : ");
				String num = sc2.nextLine();
				System.out.print("제품명 : ");
				String name = sc2.nextLine();
				System.out.print("가격 : ");
				int price = sc.nextInt();
				System.out.print("재고수량 : ");
				int stock = sc.nextInt();
				if(v.equals("r")){
					System.out.print("liter :");
					int liter = sc.nextInt();
					p = new Refrigerator(num, name, price, stock, liter);
				}else{
					System.out.print("inch :");
					int inch = sc.nextInt();
					System.out.print("type :");
					String type = sc2.nextLine();
					p = new Tv(num, name, price, stock, inch, type);
					
				}
				mgr.add(p);
				break;
				
			case 2:
				arr = mgr.search();
				for(int i=0; i<arr.length; i++) {
					if(arr[i] != null) {
						System.out.println(arr[i].toString());
					}
				}
				break;
			case 3:
				System.out.print("검색할 상품번호 > ");
				Product pro = mgr.search(sc2.nextLine());
				System.out.println("---------------------------------------------------------");
				if(pro != null) {
					System.out.println(pro.toString());
				}
				break;
			case 4:
				System.out.print("검색할 상품명 > ");
				arr = mgr.searchName(sc2.nextLine());
				System.out.println("---------------------------------------------------------");
				for(int i=0; i<arr.length; i++) {
					if(arr[i] != null) {
						System.out.println(arr[i].toString());
					}
				}
				break;
			case 5:
				arr = mgr.searchTV();
				System.out.println("---------------------------------------------------------");
				for(int i=0; i<arr.length; i++){
					if(arr[i] != null) {
						System.out.println(arr[i].toString());
					}
				}
				break;
			case 6:
				arr = mgr.searchRef();
				System.out.println("---------------------------------------------------------");
				for(int i=0; i<arr.length; i++){
					if(arr[i] != null) {
						System.out.println(arr[i].toString());
					}
				}
				break;
			case 7:
				arr = mgr.Ref400();
				System.out.println("---------------------------------------------------------");
				for(int i=0; i<arr.length; i++){
					if(arr[i] != null) {
						System.out.println(arr[i].toString());
					}
				}
				break;
			case 8:
				arr = mgr.Tv50();
				System.out.println("---------------------------------------------------------");
				for(int i=0; i<arr.length; i++){
					if(arr[i] != null) {
						System.out.println(arr[i].toString());
					}
				}
				break;
			case 9:
				System.out.print("변경할 상품의 상품번호 > ");
				String su = sc2.nextLine();
				System.out.print("수정할 가격 : ");
				int pri = sc.nextInt();
				mgr.update(su, pri);
				break;
			case 10:
				System.out.print("삭제할 상품의 번호 > ");
				mgr.delete(sc2.nextLine());
				break;
			case 11:
				System.out.println("전체 재고 상품 금액 : "+ mgr.totalPrice());
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
