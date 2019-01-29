package com.ssafy;

public class Refrigerator {
	int number;
	String name;
	int price;
	int amount;
	int liter;
	
	public Refrigerator(int number, String name, int price, int amount, int liter) {
		this.number = number;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.liter = liter;
	}

	@Override
	public String toString() {
		return "냉장고\t| 제품번호:" + number + " 제품명:" + name + " 가격:" + price + " 수량:" + amount
				+ " 용량:" + liter;
	}
	
	
}
