package com.ssafy;

public class CarMgr {
	private Car[] cars = new Car[100];
	private int index;
	
	public void add(Car c) {
		cars[index] = c;
		index++;
	}
	
	public Car[] search() {
		return cars;
	}
	
	public Car search(String num) {
		for(int i=0; i<cars.length; i++) {
			if(cars[i].getNum().equals(num)) {
				return cars[i];
			}
		}
		return null;
	}
	
	public Car[] search(int price) {
		Car[] arr = new Car[100];
		int idx=0;
		for(int i=0; i<cars.length; i++) {
			if(cars[i] != null && cars[i].getPrice() <= price) {
				arr[idx] = cars[i];
				idx++;
			}
		}
		return arr;
	}
	
	public void update(String num, int price) {
		for(int i=0; i<cars.length; i++) {
			if(cars[i] != null && cars[i].getNum().equals(num)) {
				cars[i].setPrice(price);
				System.out.println("수정되었습니다");
			}
		}
		
	}
	
	public void delete(String num) {
		for(int i=0; i<cars.length; i++) {
			if(cars[i] != null && cars[i].getNum().equals(num)) {
				cars[i] = null;
				System.out.println("삭제되었습니다");
			}
		}
		
		for(int i=0; i<cars.length-1; i++) {
			if(cars[i] == null && cars[i+1] != null) {
				cars[i] = cars[i+1];
				cars[i+1] = null;
			}
		}
		
	}
	
	public int size() {
		int su = 0;
		for(int i=0; i<cars.length; i++) {
			if(cars[i] != null) {
				su++;
			}
		}
		return su;
	}
	
	public int totalPrice() {
		int total = 0;
		for(int i=0; i<cars.length; i++) {
			if(cars[i] != null) {
				total += cars[i].getPrice();
			}
		}
		return total;
	}
	
}
