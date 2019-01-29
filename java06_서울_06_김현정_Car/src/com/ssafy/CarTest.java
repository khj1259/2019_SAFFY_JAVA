package com.ssafy;

import java.util.Scanner;

public class CarTest{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		CarMgr mgr = new CarMgr();
		
		while(true) {
			System.out.println("<<< 자동차 관리 프로그램 >>>");
			System.out.println("1. 자동차 정보 입력");
			System.out.println("2. 차량 정보 전체 검색");
			System.out.println("3. 차량 번호 검색");
			System.out.println("4. 차량 가격 검색(이하)");
			System.out.println("5. 차량 가격 수정");
			System.out.println("6. 차량 정보 삭제");
			System.out.println("7. 차량 대수 조회");
			System.out.println("8. 전체 차량 금액 합계");
			System.out.println("0. 종료");
			System.out.println("원하는 번호를 선택하세요.");
			
			int menu = sc.nextInt();
			Car[] arr = null;
			switch (menu) {
			case 1:
				System.out.print("차량번호 : ");
				String num = sc2.nextLine();
				System.out.print("모델 : ");
				String model = sc2.nextLine();
				System.out.print("가격 : ");
				int price = sc.nextInt();
				Car c = new Car(num, model, price);
				mgr.add(c);
				break;
			case 2:
				arr = mgr.search();
				System.out.println("번호\t모델\t가격");
				for(int i=0; i<arr.length; i++) {
					if(arr[i] != null) {
						System.out.println(arr[i].getNum()+"\t|"+arr[i].getModel()+
								"\t|"+arr[i].getPrice());
					}
				}
				break;
			case 3:
				System.out.print("검색할 차량번호 : ");
				Car car = mgr.search(sc2.nextLine());
				System.out.println("번호\t모델\t가격");
				System.out.println(car.getNum()+"\t"+car.getModel()+"\t"+car.getPrice());
				break;
			case 4:
				System.out.print("검색할 가격 : ");
				arr = mgr.search(sc.nextInt());
				System.out.println("번호\t모델\t가격");
				for(int i=0; i<arr.length; i++) {
					if(arr[i] != null) {
						System.out.println(arr[i].getNum()+"\t|"+arr[i].getModel()+
								"\t|"+arr[i].getPrice());
					}
				}
				break;
			case 5:
				System.out.print("수정할 차량의 번호 : ");
				String su = sc2.nextLine();
				System.out.print("수정할 가격 : ");
				int pri = sc.nextInt();
				mgr.update(su, pri);
				break;
			case 6:
				System.out.print("삭제할 차량의 번호 : ");
				mgr.delete(sc2.nextLine());
				break;
			case 7:
				System.out.println("저장된 차량 대수 : "+ mgr.size());
				break;
			case 8:
				System.out.println("저장된 차량의 금액 합계 : "+ mgr.totalPrice());
				break;
			default:
				System.out.println("잘못 입력 하셨습니다");
				break;
			}
			if(menu == 0) break;
		}
		
	}//end of main
}//end of class
