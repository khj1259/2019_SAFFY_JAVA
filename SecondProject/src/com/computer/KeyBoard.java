package com.computer;

public class KeyBoard extends Parts{
	private String type;


	public KeyBoard(String maker, int price, String type, int num) {
		super(maker, price, num);
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	void typing() {
		System.out.println("타이핑을 합니다");
		System.out.println("--------------------");
	}
	
	@Override
	void info() {
		System.out.println(this.getClass().getName());
		super.info();
		System.out.println("type : "+type);
		System.out.println("--------------------");
	}
}
