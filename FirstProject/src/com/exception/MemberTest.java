package com.exception;

public class MemberTest {

	public static void main(String[] args) {
		NoSuchMember n = new NoSuchMember();
		try {
			new MemberTest().findMember("kim");
		} catch (NoSuchMember e) {
			e.printStackTrace();
		}
	}

	private void findMember(String name) throws NoSuchMember {
		if(name.equals("tom") || name.equals("jane")) {
			System.out.println("welcome");
		}else {
			throw new NoSuchMember();
		}
		
	}
}
