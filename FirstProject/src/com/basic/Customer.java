package com.basic;

public class Customer {
	//field
	int num;
	String id;
	String password;
	String phone;
	String address;
	String company;
	int point;
	String grade;
	String email;
	String email2;
	
	public Customer() {
		this(0,"anonymous","123");
	}

	public Customer(int num, String id, String password) {
		this(num, id, password, "000-0000-0000");
	}

	public Customer(int num, String id, String password, String phone) {
		this(num, id, password, phone, "seoul");
	}

	public Customer(int num, String id, String password, String phone, String address) {
		this(num, id, password, phone, address, "abc", 0, "c", "none", "none");
	}

	public Customer(int num, String id, String password, String phone, String address, String company, int point,
			String grade, String email, String email2) {
		this.num = num;
		this.id = id;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.company = company;
		this.point = point;
		this.grade = grade;
		this.email = email;
		this.email2 = email2;
	}
	
	
	
	
}
