package com.ssafy2;

public class ProductTest {
	
	public static void main(String[] args) {
		
		Tv[] tvList = new Tv[3];
		Refrigerator[] refList = new Refrigerator[3];
		
		tvList[0] = new Tv(1234, "삼성스마트TV", 800000, 60, 65, "UHD");
		tvList[1] = new Tv(5678, "LG스마트TV", 700000, 50, 70, "HD");
		tvList[2] = new Tv(4567, "삼성TV", 500000, 55, 40, "HD");

		refList[0] = new Refrigerator(2345, "삼성스마트냉장고", 2000000, 80, 600);
		refList[1] = new Refrigerator(5434, "LG스마트냉장고", 1800000, 100, 500);
		refList[2] = new Refrigerator(9483, "김치 냉장고", 1200000, 55, 600);
		
		System.out.println("******************** 제품 정보 *******************");
		for(Tv t : tvList) {
			System.out.println(t.toString());
		}
		for(Refrigerator r : refList) {
			System.out.println(r.toString());
		}
	}
}
