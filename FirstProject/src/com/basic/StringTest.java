package com.basic;

public class StringTest {
	
	public static void main(String[] args) {
		String s = "mylimeorange";
		String m = "mylimeorange";
		String t = new String("mylimeorange");
		
		System.out.println(s.length());
		System.out.println(s.charAt(3));//인덱스가 3인 글자
		
		System.out.println(s.indexOf("i"));//i의 인덱스
		String s2 = s.substring(2, 7);// 인덱스가 2~6까지 부분 문자열
		System.out.println(s2);
		
		if(s == t) { // 주소값 비교
			System.out.println("s == t");
		}
		if(s.equals(t)) { // 내용 비교
			System.out.println("s.equals(t)");
		}
		s.toUpperCase();//소문자 -> 대문자
		System.out.println(s);
		
		s.concat("hello");//문자열 결합
		System.out.println(s);
		
		s = s + "hello";
		System.out.println(s);
		
		//원본에 수정 가능
		StringBuilder sb = new StringBuilder("mylimeorange");
		sb.append("hello");//문자열 결합
		System.out.println(sb.toString());
		
		System.out.println(sb.length());
		sb.setLength(5);
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
	}
}
