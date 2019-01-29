package com.inherit;

public class CEO extends Employee{

	public CEO(int num, String name, int salary) {
		super(num, name, salary);
	}

	@Override
	public double getBonus() {
		return getSalary() * 0.7;
	}
	
	

}
