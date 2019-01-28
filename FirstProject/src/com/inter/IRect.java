package com.inter;
//IShape 인터페이스를 구현(완성)하는 자식 클래스
//인터페이스를 implements 해도 상속 관계가 성립함
public class IRect implements IShape{
	int width, height;
	
	public IRect(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getCircum() {
		return 2 * (width + height);
	}
	
}
