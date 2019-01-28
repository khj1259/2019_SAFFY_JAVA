package com.ssafy;

public class ProductTest {
	
	public static void main(String[] args) {
		
		Tv tv = new Tv(1234, "삼성스마트TV", 800000, 50, 65, "HD");
		Refrigerator refrigerator = new Refrigerator(2345, "삼성스마트냉장고", 1300000, 100, 500);
		
		System.out.println("******************** 제품 정보 ****************");
		System.out.println(tv.toString());
		System.out.println(refrigerator.toString());
	}
}
