package com.computer;

public class MyComputer {
	MainFrame frame;
	KeyBoard keyboard;
	Mouse mouse;
	Monitor monitor;
	
	public void init() {
//		frame = new MainFrame("LG", 300000, 80);
//		keyboard = new KeyBoard("LofiTec", 100000, "bluetooth");
//		mouse = new Mouse("samsung", 30000, true);
//		monitor = new Monitor("samsung", 200000, 16);
	}
	
	public void powerOn(){
		frame.powerOn();
		monitor.powerOn();
	}
	
	public void powerOff() {
		frame.powerOff();
		monitor.powerOff();
	}
	
	public void doJob() {
		keyboard.typing();
		mouse.click();
		mouse.scroll();
	}
}
