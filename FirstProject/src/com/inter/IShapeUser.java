package com.inter;

public class IShapeUser {
	
	public static void main(String[] args) {
		
		IShape[] is = new IShape[3];
		is[0] = new ICircle(10);
		is[1] = new IRect(5, 8);
		is[2] = new ICircle(15);
		
		for(IShape i : is) {
			System.out.println(i.getClass().getName());
			System.out.println("면적 : "+i.getArea());
			System.out.println("둘레 : "+i.getCircum());
		}
	}
}
