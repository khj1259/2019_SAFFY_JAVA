package com.exception;

// 사용자 저의 예외 클래스 : exception 클래스를 상속 받아야 됨
public class MyException extends Exception{

	public MyException() {
		System.out.println("MyException 발생 !");
	}

	@Override
	public String toString() {
		return "MyException!!!";
	}
	
	
}
