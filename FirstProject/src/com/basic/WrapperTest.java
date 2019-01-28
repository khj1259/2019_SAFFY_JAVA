package com.basic;

public class WrapperTest {
	
	public static void main(String[] args) {
		int count = 123;//기본형
		count++;//124
		//int -> Integer
		Integer i = new Integer(count);
		i++;//125  auto-unboxing후에 연산 실행하고 다시 auto-boxing해서 Integer 객체로 만듦
		System.out.println(i);
		
		String snum = "567";
		int num = Integer.parseInt(snum);
		System.out.println(++num);
		
		double d = 3.14;
		//Wrapper class 로 바꾸기
		Double d2 = new Double(d);
		
		String snum2 = "2.56";
		//snum2를 double타입으로 바꾸기
		double d3 = Double.parseDouble(snum2);
		
	}
}
