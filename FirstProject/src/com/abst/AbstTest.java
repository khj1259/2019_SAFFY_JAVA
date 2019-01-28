package com.abst;

//클래스 안에 추상 메소드가 있다면 클래스도 추상이 되어야 함. 미완성 클래스
//추상 클래스를 상속받는 자식 클래스를 만들고 그 자식 클래스 안에서 부모가 가지고 있던 미완성의 추상메소드를 완성 시켜야 한다.(구현, implement)
abstract class AbstractClass{
	//추상 메소드 : 메소드의 바디{} 가 없음. 미완성 메소드. abstract 키워드를 붙여줌
	public abstract void hello();
	public void go() {}
}

class MyAbstractClass extends AbstractClass{

	@Override
	public void hello() {
		System.out.println("hello, abstract class...");
	}
}

public class AbstTest {
	
	public static void main(String[] args) {
//		AbstractClass a = new AbstractClass(); // 미완성 클래스 이므로 생성 안됨
		MyAbstractClass m = new MyAbstractClass();// 추상클래스의 자식 객체 생성
		m.hello();
	}
}
