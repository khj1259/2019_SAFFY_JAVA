package com.inherit;

class GrandParent{}
//super class, parent class, base class
class Parent extends GrandParent {
	//field
	String name = "Tom";
	String address = "Seoul";
	
	public Parent() {
		System.out.println("Parent 생성자 입니다");
	}

	void printName() {
		System.out.println("name:" + name);
	}
	
	public void printAddress() {
		System.out.println("address:" + address);
	}
}

//sub class, child class, derived class
public class Child extends Parent{
	String email;
	
	public Child() {
		System.out.println("Child 생성자 입니다");
	}
	
	//Method Overriding : 부모 클래스로부터 상속받은 메소드 중 자식 클래스에서 재정의 하는 일
	@Override
	protected void printName() {
		System.out.println("name: Tomson");
	}
	
	public void callSuper() {
		super.printName();
	}
	
	public static void main(String[] args) {
		//다형성 : 동일한 타입의 생성 객체를 다양한 타입으로 가리킬 수 있는 현상
		Parent cc = new Child();
		Child c = (Child)cc;
//		GrandParent c2 = new Child();
//		Object c = new Child();
		
//		Child c = new Child();
//		System.out.println(c.name);
		c.printName();// Child name
//		super.printName();// super, this 는 static 메소드 안에서는 사용 불가
//		c.callSuper();
		c.printAddress();
		
		
	}

}
