package com.ssafy;

import java.io.Serializable;

public class Product implements Serializable {
	private String num;
	private String name;
	private int price;
	private int stock;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String num, String name, int price, int stock) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return num + "\t" + name + "\t" + price + "\t" + stock;
	}
	
	
}
