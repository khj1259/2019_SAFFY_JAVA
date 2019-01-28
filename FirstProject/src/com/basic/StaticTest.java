package com.basic;

public class StaticTest {
	static int scount;// 클래스 변수, 객체들 간에 공유됨. class area에 생성, runtime 전에 이미 만들어짐
	int count;// 인스턴스(객체) 변수, 객체 안에서 공유됨, heap에 생성, runtime시에 만들어짐

	static void hello() {// class area에 생성, runtime 전에 이미 만들어짐
		System.out.println("hello,,,");
	}
	
	static {// static block
		System.out.println("static block...1");
	}
	
	void test() {
		System.out.println(this.count);
//		System.out.println(super.num);
	}
	
	public static void main(String[] args) {
		//객체 새성을 하지 않아도 이미 생성되어 있음
		//클래스 이름으로 사용 가능
		System.out.println(++StaticTest.scount);
		StaticTest.hello();
		
		/*StaticTest s1 = new StaticTest();
		StaticTest s2 = new StaticTest();
		StaticTest s3 = new StaticTest();
		
		System.out.println(++s1.count+":"+ ++s2.count+":"+ ++s3.count);
		System.out.println(++s1.scount+":"+ ++s2.scount+":"+ ++s3.scount);
		//static 변수는 맨 처음 한번 생성 되어 Class Area에 올라가고, 
		//객체가 새로 생성되어도 객체마다 변수가 생성되는 것이 아니라, 
		//각 객체가 맨 처음 만들어진 변수를 참조해서 공유하여 쓴다.
*/		
	}
	
	static {// static block
		System.out.println("static block...2");
	}
}
