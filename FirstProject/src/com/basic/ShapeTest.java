package com.basic;

public class ShapeTest {

	public static void main(String[] args) {
		//Circle 2개 생성
		//반지름 setting
		//원면적, 원둘레 출력

		//Rect 2개 생성
		//가로, 세로 setting
		//사각형 면적, 사각형 둘레 출력
		
		Circle circle = new Circle(5);
		Circle circle2 = new Circle(6);

		System.out.println("원면적:"+circle.getArea());
		System.out.println("원둘레:"+circle.getCircum());
		System.out.println("원면적:"+circle2.getArea());
		System.out.println("원둘레:"+circle2.getCircum());
		
		Rect rect = new Rect(1, 2);
		Rect rect2 = new Rect(3, 4);

		System.out.println("사각형면적:"+rect.getArea());
		System.out.println("사각형둘레:"+rect.getCircum());
		System.out.println("사각형면적:"+rect2.getArea());
		System.out.println("사각형둘레:"+rect2.getCircum());
	}

}
