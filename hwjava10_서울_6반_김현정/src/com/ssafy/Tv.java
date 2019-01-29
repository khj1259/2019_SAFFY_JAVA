package com.ssafy;

public class Tv extends Product{
//	int number;
//	String name;
//	int price;
//	int amount;
	int inch;
	String type;
	
	public Tv(String num, String name, int price, int stock, int inch, String type) {
		super(num, name, price, stock);
		this.inch = inch;
		this.type = type;
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



	@Override
	public String toString() {
		return "Tv\t|제품번호:" + getNum() + " 제품명:" + getName() + " 가격:" + getPrice() + " 수량:" + getStock() + " 인치:" + inch
				+ " 디스플레이타입:" + type;
	}

	
	

}
