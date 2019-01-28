package com.basic;

public class MainTest {
	
	public static void main(String[] args) {
//		int x = 200;
//		System.out.println(x);
		for(int i=0; i<args.length; i++) {
			System.out.println(args[i]);
		}
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		System.out.println(x+y);
	}
}
