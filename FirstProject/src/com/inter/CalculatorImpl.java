package com.inter;

public class CalculatorImpl implements Calculator {

	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int sub(int a, int b) {
		return a - b;
	}

	@Override
	public int multi(int a, int b) {
		return a * b;
	}

	@Override
	public int divide(int a, int b) {
		return a / b;
	}
	
}
