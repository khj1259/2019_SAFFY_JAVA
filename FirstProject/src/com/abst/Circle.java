package com.abst;
//Shape의 자식 클래스, Shape가 가지고 있던 미완성 메소드 2개(getArea(), getCircum())를 완성시켜야 함
public class Circle extends Shape{
	int r;// 반지름
	
	public Circle(int r) {
		this.r = r;
	}

	@Override
	public double getArea() {// 원면적
		
		return Math.PI * r * r;
	}

	@Override
	public double getCircum() {// 원둘레

		return 2 * Math.PI * r;
	}

}
