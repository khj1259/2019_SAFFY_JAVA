package com.computer;

public abstract class Parts {
	private String maker;
	private int price;
	private int num;//부품 번호
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Parts(String maker, int price) {
		this.maker = maker;
		this.price = price;
	}
	
	public Parts(String maker, int price, int num) {
		this.maker = maker;
		this.price = price;
		this.num = num;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	void info() {
		System.out.println("num : "+getNum());
		System.out.println("maker : "+getMaker());
		System.out.println("price : "+getPrice());
	}
}
