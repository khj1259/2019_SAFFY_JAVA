package com.ssafy;

public class ExisedException extends Exception {
	
	public ExisedException() {
		System.out.println("ExisedException 발생");
	}

	@Override
	public String toString() {
		return "ExisedException []";
	}
}
