package com.inherit;

public class BonusTest {
	
	public void printBonus(Employee who) {
		if(who instanceof Manager) {
			System.out.println("helo,,,");
		}
		System.out.println(who.getClass());
		System.out.println(who.getBonus());
	}
	
	public static void main(String[] args) {
		BonusTest bt = new BonusTest();
		
		Employee tom = new Employee(100, "tom", 5000);
		Manager bill  = new Manager(200, "bill", 6000, 1);
		bt.printBonus(tom);
		bt.printBonus(bill);
		
	}
}
