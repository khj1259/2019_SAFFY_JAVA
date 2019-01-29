package com.ssafy2;

public class Refrigerator {
	private int number;
	private String name;
	private int price;
	private int amount;
	private int liter;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getLiter() {
		return liter;
	}

	public void setLiter(int liter) {
		this.liter = liter;
	}

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
