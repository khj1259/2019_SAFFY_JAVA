package com.computer;

public class Mouse extends Parts{
	private boolean wireless;
	
	public Mouse(String maker, int price, boolean wireless, int num) {
		super(maker, price, num);
		this.wireless = wireless;
	}
	
	public boolean isWireless() {
		return wireless;
	}

	public void setWireless(boolean wireless) {
		this.wireless = wireless;
	}

	void click() {
		System.out.println("마우스를 클릭 합니다");
		System.out.println("--------------------");
	}
	
	void scroll() {
		System.out.println("스크롤을 합니다");
		System.out.println("--------------------");
	}
	
	@Override
	void info() {
		System.out.println(this.getClass().getName());
		super.info();
		System.out.println("wireless : "+wireless);
		System.out.println("--------------------");
	}
}
