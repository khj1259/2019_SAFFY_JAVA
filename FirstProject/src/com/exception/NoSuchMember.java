package com.exception;

import java.util.Arrays;

public class NoSuchMember extends Exception{

	public NoSuchMember() {
		System.out.println("NoSuchMember 발생");
	}

	@Override
	public String toString() {
		return "NoSuchMember!!";
	}
	
	
}
