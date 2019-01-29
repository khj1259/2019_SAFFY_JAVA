package com.ssafy;
//회원정보
public class User {
	private String name;
	private int age;
	private String id;
	private String pw;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, int age, String id, String pw) {
		this.name = name;
		this.age = age;
		this.id = id;
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", id=" + id + ", pw=" + pw + "]";
	}
	
}
