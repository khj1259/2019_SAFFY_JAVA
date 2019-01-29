package com.ssafy;

public class Refrigerator extends Product{
//	int number;
//	String name;
//	int price;
//	int amount;
	int liter;
	
	public Refrigerator(String num, String name, int price, int stock, int liter) {
		super(num, name, price, stock);
		this.liter = liter;
	}
	
	

	public int getLiter() {
		return liter;
	}



	public void setLiter(int liter) {
		this.liter = liter;
	}



	@Override
	public String toString() {
		return "냉장고\t| 제품번호:" + getNum() + " 제품명:" + getName() + " 가격:" + getPrice() + " 수량:" + getStock()
				+ " 용량:" + liter;
	}
	
	
}
