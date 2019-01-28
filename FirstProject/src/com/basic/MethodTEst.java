package com.basic;

public class MethodTEst {
	
	//method 정의 : 
	static int sum(int a, int b) {
		int result = a + b;
//		System.out.println(result);
		return result;
	}
	//overloading::한 클래스 안에서 메서드 이름이 중복되는 현상
	//파라메터 리스트로 구분 가능
	static double sum(double a, double b) {
		return a + b;
	}
	
	static int multi(int a, int b) {
		int result = a * b;
		return result;
	}
	
	static void printGreeting(String name) {
		System.out.println(name+"...be happy!");
	}
	
	static String greeing(String name) {
		return name+" welcome!";
	}
	
	static boolean reverse(boolean tf) {
		return !tf;
	}
	
	static String result(boolean a, boolean b) {
		String q = (a && b) ? "ok" : "cancel";
		return q;
	}
	
	static void loopString(int count, String msg) {
		for(int i=0; i<count; i++) {
			System.out.println(msg);
		}
	}
	
	static double getArea(int r) {
		double result = 3.14 * r * r;
		return result;
	}
	
	static double printCircum(int r) {
		double result = 2 * 3.14 * r;
		return result;
	}
	
	static int[] makeArray(int len) {
		int[] array = new int[len];
		return array;
	}
	
	static void total(int[] data) {
		int result = 0;
		for(int i=0; i<data.length; i++) {
			result += data[i];
		}
		System.out.println(result);
	}
	
	static boolean isExist(int su) {
		int[] data = {23,12,45,67,89,85,67,90,35,13,21,37};
		boolean msg = false;
		for(int i=0; i<data.length; i++) {
			if(su == data[i]) {
				msg = true;
				break;
			}
		}
		return msg;
	}
	public static void main(String[] args) {
		//메소드 사용, 호출
		System.out.println(sum(3, 6));
		int num = multi(5, 8);
		System.out.println(num);
		System.out.println(multi(3, 5));
	}
}
