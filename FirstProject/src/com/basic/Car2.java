package com.basic;
public class Car2 {
	int num; // 0
	String model; // null
	String owner; // null
	
	
	Car2() {
		this(0);
	}
	
	public Car2(int num) {
		this(num, "xyz");
	}
	
	Car2(int num, String model) {
		this(num, model, "anonymous");
	}

	Car2(int num, String model, String owner) {
		this.num = num;
		this.model = model;
		this.owner = owner;
	}


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
	
	public static void main(String[] args) {
		 Car2 c1 = new Car2();
		 Car2 c2 = new Car2(7890, "k5");
		 Car2 c3 = new Car2(5612, "morning", "kim");
		 c1.info();
		 System.out.println();
		 
		 c2.info();
		 System.out.println();
		 
		 c3.info();
	}
	
}
