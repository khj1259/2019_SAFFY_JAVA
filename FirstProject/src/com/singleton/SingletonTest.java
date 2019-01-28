package com.singleton;

public class SingletonTest {

	public static void main(String[] args) {
		SingletonObject s1 = SingletonObject.getInstance();
		SingletonObject s2 = SingletonObject.getInstance();
		
		System.out.println(s1 == s2);//주소값
	}
}
