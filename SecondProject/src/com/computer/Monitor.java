package com.computer;

public class Monitor extends Parts{
	private double size;
	
	public Monitor(String maker, int price, double size, int num) {
		super(maker, price, num);
		this.size = size;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}


	void powerOn() {
		System.out.println("모니터를 켭니다");
		System.out.println("--------------------");
	}
	
	void powerOff() {
		System.out.println("모니터를 끕니다");
		System.out.println("--------------------");
	}
	
	@Override
	void info() {
		System.out.println(this.getClass().getName());
		super.info();
		System.out.println("size : "+size);
		System.out.println("--------------------");
	}
}
