package com.basic;
//자동차를 위한 클래스, 클래스 설계
public class Car {
	//객체와 배열은 생성만 해도 기본값으로 채워져 있음
	//데이터,  field
	int num; // 0
	String model; // null
	String owner; // null
	
	//생성자: 1.클래스 이름과 동일한 함수명 2.리턴 타입은 적지 않음
	//객체를 생성할 때 자동 호출됨(초기화 작업 수행)
	
	//this() : 한 클래스 안에서 다른 생성자를 호출하는 메소드
	Car() {//default 생성자 - parameter X
		this(0);
	}
	
	public Car(int num) {
		this(num, "xyz");
	}
	
	Car(int num, String model) {
		this(num, model, "anonymous");
	}

	Car(int num, String model, String owner) {
		this.num = num;
		this.model = model;
		this.owner = owner;
	}



	/**method:일, 동작, 기능을 하는 단위*/
	void run() {
		System.out.println("run method...");
	}
	void stop() {
		System.out.println("stop method...");
	}
	void info() {
		System.out.println("num:"+num);
		System.out.println("model:"+model);
		System.out.println("owner:"+owner);
	}
	
//	@Override
//	public String toString() {
//		return "자동차 클래스를 나타냅니다";
//	}
	
	public static void main(String[] args) {
		System.out.println(StaticTest.scount);
		StaticTest.hello();
		
		System.out.println(Math.pow(2, 3));// 2의 3승
		System.out.println(Math.max(2, 3));//max
		System.out.println(Math.min(2, 3));//min
		System.out.println(Math.random() * 10 + 1);//random 값 0~1 미만
		
		//Car 클래스를 이용한 객체 생성
		Car c1 = new Car();
		Car c2 = new Car(7890, "k5");
		Car c3 = new Car(5612, "morning", "kim");
		System.out.println(c1);
		System.out.println(c1.toString()); //윗 줄 c1과 똑같음

		c1.info();
		System.out.println();

		c2.info();
		System.out.println();

		c3.info();

		//		 c1.run();
		//		 c1.stop();
	}
}
