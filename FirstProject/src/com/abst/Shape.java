package com.abst;

//추상 클래스, 도형 클래스, 부모 클래스, 그 안에 추상메소드 + 구상메소드 같이 나올 수 있음
//자식 클래스에게 타입을 물려주는 효과가 있음(타입 상속)
public abstract class Shape {
	//추상 메소드(abstract method)
	public abstract double getArea();//도형의 면적 구하는 메소드
	public abstract double getCircum();//도형의 둘레 구하는 메소드
	
	//구상 메소드(concrete method)
	public void hello() {
		System.out.println("hello, Shape");
	}
}
