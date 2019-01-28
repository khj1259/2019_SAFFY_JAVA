package com.computer;

public class ComputerTest {
	
	public static void main(String[] args) {
		ComputerManager man = new ComputerManager(5);
		man.add(new Monitor("LG", 300000, 25.2, 1));
		man.add(new Monitor("SAMSUNG", 350000, 28.2, 2));
		man.add(new Mouse("LOGITEC", 75000, true, 3));
		man.add(new KeyBoard("LG", 100000, "type-A", 4));
		man.add(new MainFrame("LG", 850000, "intel", 5));
		man.add(new Monitor("ABC", 450000, 50.2, 6));
		
		System.out.println("\n모든 데이터");
		Parts[] p = man.allParts();
		for(Parts pp : p) {
			if(pp != null) {
				pp.info();
			}
		}
		
		System.out.println("\n부품 검색");
		Parts p1 = man.findPart(3);
		p1.info();
		
		System.out.println("\n부품 삭제");
		man.deletePart(1);
		p = man.allParts();
		for(Parts pp : p) {
			if(pp != null) {
				pp.info();
			}
		}
	}
}
