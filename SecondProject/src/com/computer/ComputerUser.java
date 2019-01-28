package com.computer;

public class ComputerUser {
	
	public static void main(String[] args) {
		MyComputer computer = new MyComputer();
		computer.init();
		computer.powerOn();
		computer.doJob();
		computer.powerOff();
	}
}
