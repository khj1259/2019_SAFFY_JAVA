package com.ssafy;

public class NotFoundException extends Exception {
	
	public NotFoundException() {
		System.out.println("NotFoundException 발생");
	}

	@Override
	public String toString() {
		return "NotFoundException []";
	}
}
