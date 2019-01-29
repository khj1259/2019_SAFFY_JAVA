package com.ssafy2;

public class Tv {
	private int number;
	private String name;
	private int price;
	private int amount;
	private int inch;
	private String type;
	
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

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
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
