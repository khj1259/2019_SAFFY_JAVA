package com.basic;

public class Rect {
	int width;
	int height;
	
	public Rect(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	int getArea() {
		int result = this.width * this.height;
		return result;
	}
	
	int getCircum() {
		int result = (this.width * 2) + (this.height * 2);
		return result;
	}
}
