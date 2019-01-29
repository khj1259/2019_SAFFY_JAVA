package com.ssafy;

public class CodeNotFoundException extends Exception {

	public CodeNotFoundException() {
		System.out.println("CodeNotFoundException 발생");
	}

	@Override
	public String toString() {
		return "CodeNotFoundException []";
	}

}
