package com.basic;

//상속불가
//클래스가 final 이면 그 안의 메소드도 final
final class Test{}

class Test2{
	//overriding이 안됨
	final void go() {}
	void stop() {}
}
public class FinalTest extends Test2{
	//final field : 값 변경이 안됨, 상수
	final int x = 90;
	
	public static void main(String[] args) {
		FinalTest t = new FinalTest();
//		t.x = 100;
	}
}
