package com.ssafy;

public class ProductNotFoundException extends Exception {

	public ProductNotFoundException() {
		System.out.println("ProductNotFoundException 발생");
	}

	@Override
	public String toString() {
		return "ProductNotFoundException []";
	}
	
	
}
