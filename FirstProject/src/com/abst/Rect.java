package com.abst;
//Shape의 자식 클래스, Shape가 가지고 있던 미완성 메소드 2개(getArea(), getCircum())를 완성시켜야 함
public class Rect extends Shape{
	int width;
	int height;
	
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {//사각형 면적
		
		return width * height;
	}

	@Override
	public double getCircum() {//사각형 둘레

		return 2 * (width + height);
	}
	
}
