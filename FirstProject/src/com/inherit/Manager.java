package com.inherit;

class Out{// top-level class
	protected class In {}// inner class
	private class In2 {}
}

//super class
class Employee{
	private int num;
	private String name;
	private int salary;
	
	public Employee(int num, String name, int salary) {
		this.num = num;
		this.name = name;
		this.salary = salary;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}
 
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getBonus() {
		return salary * 0.3;
	}
	
	public String info() {
		return "num:" + num + " name:" + name + "salary:" + salary; 
	}
}

//sub
public class Manager extends Employee {
	int mcode;
	
	public Manager(int num, String name, int salary, int mcode) {
		super(num, name, salary);// 부모의 생성자 호출
		this.mcode = mcode;
	}
	
	@Override
	public double getBonus() {
		return getSalary() * 0.5;
	}

	public static void main(String[] args) {
		Employee[] list = new Employee[3];
		
		Employee e = new Employee(456, "ellen", 3000);
		Manager m = new Manager(123, "bill", 5000, 100);
		
		list[0] = m;
		list[1] = new Manager(147, "potter", 6000, 200);
		list[2] = e;
		
		for(Employee x : list) {
			System.out.println(x.getName());
			System.out.println(x.getBonus());
		}
		
		
	}
}
