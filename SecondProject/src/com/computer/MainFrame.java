package com.computer;

public class MainFrame extends Parts{
	private String cpu;
	
	public MainFrame(String maker, int price, String cpu, int num) {
		super(maker, price, num);
		this.cpu = cpu;
	}
	
	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	void powerOn() {
		System.out.println("본체를 켭니다");
		System.out.println("--------------------");
	}
	
	void powerOff() {
		System.out.println("본체를 끕니다");
		System.out.println("--------------------");
	}
	
	@Override
	void info() {
		System.out.println(this.getClass().getName());
		super.info();
		System.out.println("cpu : "+cpu);
		System.out.println("--------------------");
	}
}
