package com.util;

import java.util.ArrayList;

import com.abst.Circle;

//List 종류 : 데이터 순서 o, 중복 o

public class ArrayListTest {
	public static void main(String[] args) {
		//generic programming 기법이 적용된 클래스
		ArrayList<Circle> list3 = new ArrayList<>();
		list3.add(new Circle(5));
		list3.add(new Circle(7));
		list3.add(new Circle(10));
		
		
		
		for(Circle c : list3) {
			System.out.println("면적 : "+c.getArea());
			System.out.println("둘레 : "+c.getCircum());
			System.out.println();
		}
		
		ArrayList<String> list = new ArrayList<>();
		list.add("spring");
		list.add("summer");
		list.add("fall");
		list.add("winter");
		list.add("spring");
		list.add("winter");
		list.add("spring");
		
		System.out.println(list.size());
		
		for(String season : list) {
			System.out.println(season);
		}
		
		String x = list.get(2);//list 안에서 index위치의 데이터를 꺼냄
		System.out.println(x);
		
		list.remove(3);
		for(String season : list) {
			System.out.println(season);
		}
		
		System.out.println(list.contains("spring"));
		list.clear();//list안의 모든 데이터 삭제
		System.out.println(list.isEmpty());
	}
}
