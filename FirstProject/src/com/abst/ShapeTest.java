package com.abst;

public class ShapeTest {
	
	public static void main(String[] args) {
		
		Shape[] s = new Shape[5];
		Circle c1 = new Circle(6);
		Circle c2 = new Circle(10);
		Rect r1 = new Rect(5, 8);
		Rect r2 = new Rect(7, 10);
		TriAngle t = new TriAngle(3, 3, 5, 4);
		
		s[0] = c1;
		s[1] = c2;
		s[2] = r1;
		s[3] = r2;
		s[4] = t;
		
		System.err.println("error test...");
		for( Shape x : s ) {
			System.out.println(x.getClass().getSimpleName());
			System.out.println("면적:"+x.getArea());
			System.out.println("둘레:"+x.getCircum());
			System.out.println("--------------------------");
		}
		
	}
}
