package com.ssafy;

public class ISBNNotFoundException extends Exception {
	
	public ISBNNotFoundException() {
		System.out.println("ISBNNotFoundException 호출");
	}

	@Override
	public String toString() {
		return "ISBNNotFoundException!!";
	}
	
}
