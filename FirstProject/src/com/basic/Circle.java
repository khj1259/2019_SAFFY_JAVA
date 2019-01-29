package com.basic;

public class Circle {
	int r;
	
	public Circle(int r) {
		this.r = r;
	}

	public double getArea() {
		double result = Math.PI * this.r * this.r;
		return result;
	}
	
	double getCircum() {
		double result = 2 * 3.14 * this.r;
		return result;
	}
}
