package com.abst;
//Shape의 자식 클래스, Shape가 가지고 있던 미완성 메소드 2개(getArea(), getCircum())를 완성시켜야 함
public class TriAngle extends Shape{
	int a, b, bottom;
	int height;
	
	public TriAngle(int a, int b, int bottom, int height) {
		this.a = a;
		this.b = b;
		this.bottom = bottom;
		this.height = height;
	}

	@Override
	public double getArea() {//삼각형의 넓이
		
		return (bottom * height) / 2;
	}

	@Override
	public double getCircum() {//삼각형의 둘레
		
		return a + b + bottom;
	}

}
