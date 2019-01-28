package com.ssafy;

public class QuantityException extends Exception {

	public QuantityException() {
		System.out.println("QuantityException 호출");
	}

	@Override
	public String toString() {
		return "QuantityException!!";
	}
	
}
