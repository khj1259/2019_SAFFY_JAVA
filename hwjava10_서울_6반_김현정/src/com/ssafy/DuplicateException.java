package com.ssafy;

public class DuplicateException extends Exception {

	public DuplicateException() {
		System.out.println("DuplicateException 발생");
	}

	@Override
	public String toString() {
		return "DuplicateException []";
	}
	
}
