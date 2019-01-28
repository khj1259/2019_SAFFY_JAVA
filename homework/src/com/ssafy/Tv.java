package com.ssafy;

public class Tv {
	int number;
	String name;
	int price;
	int amount;
	int inch;
	String type;
	
	public Tv(int number, String name, int price, int amount, int inch, String type) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.inch = inch;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Tv\t|제품번호:" + number + " 제품명:" + name + " 가격:" + price + " 수량:" + amount + " 인치:" + inch
				+ " 디스플레이타입:" + type;
	}

	
	

}
