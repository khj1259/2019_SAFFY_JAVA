package com.singleton;

// Singletone Pattern : 메모리 상에서 생성된 객체가 하나임을 보장하는 디자인 패턴

public class SingletonObject {
	//1.field : static
	private static SingletonObject instance;
	
	//2.생성자 : private
	private SingletonObject() {}
	
	//3.객체 생성 메소드 : static
	public static SingletonObject getInstance() {
		if(instance == null) {
			instance = new SingletonObject();
		}
		return instance;
	}
	
	public void test() {
		System.out.println("hello...");
	}
}
