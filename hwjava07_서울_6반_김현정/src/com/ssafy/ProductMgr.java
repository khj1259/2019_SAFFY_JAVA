package com.ssafy;

public class ProductMgr {
	private Product[] products;
	private int index;
	
	public ProductMgr() {
		products  = new Product[100];
	}
	
	//상품 저장
	public void add(Product p) {
		products[index] = p;
		index++;
	}
	
	//전체 상품 검색
	public Product[] search() {
		return products;
	}
	
	//상품번호로 상품 검색
	public Product search(String num) {
		boolean tf = false;
		for(int i=0; i<products.length; i++) {
			if(products[i] != null && products[i].getNum().equals(num)) {
				tf = true;
				return products[i];
			}
		}
		if(!tf) System.out.println("일치하는 상품이 없습니다");
		return null;
	}
	
	//상품명으로 상품 검색
	public Product[] searchName(String name) {
		boolean tf = false;
		Product[] arr = new Product[100];
		int idx = 0;
		for(int i=0; i<products.length; i++) {
			if(products[i] != null && products[i].getName().contains(name)) {
				arr[idx] = products[i];
				idx++;
				tf = true;
			}
		}
		if(!tf) System.out.println("일치하는 상품이 없습니다");
		return arr;
	}
	
	//Tv정보만 검색
	public Tv[] searchTV() {
		Product[] arr = new Tv[100];
		int idx = 0;
		for(int i=0; i<products.length; i++) {
			if(products[i] != null && products[i].getClass().getSimpleName().equals("Tv")) {
				arr[idx] = products[i];
				idx++;
			}
		}
		return (Tv[]) arr;
	}
	
	//Refrigerator만 검색
	public Refrigerator[] searchRef() {
		Product[] arr = new Refrigerator[100];
		int idx = 0;
		for(int i=0; i<products.length; i++) {
			if(products[i] != null && products[i].getClass().getSimpleName().equals("Refrigerator")) {
				arr[idx] = products[i];
				idx++;
			}
		}
		return (Refrigerator[]) arr;
	}
	
	//400L 이상의 Refrigerator 검색
	public Refrigerator[] Ref400() {
		Refrigerator[] arr = searchRef();
		Refrigerator[] result = new Refrigerator[100];
		int idx = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != null && (arr[i].getLiter() >= 400)) {
				result[idx] = arr[i];
				idx++;
			}
		}
		return result;
	}
	
	//50inch 이상의 TV검색
	public Tv[] Tv50() {
		Tv[] arr = searchTV();
		Tv[] result = new Tv[100];
		int idx = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != null && (arr[i].getInch() >= 50)) {
				result[idx] = arr[i];
				idx++;
			}
		}
		return result;
	}
	
	//상품 번호와 가격을 입력받아 가격을 변경
	public void update(String num, int price) {
		boolean tf = false;
		for(int i=0; i<products.length; i++) {
			if(products[i] != null && products[i].getNum().equals(num)) {
				products[i].setPrice(price);
				System.out.println("수정되었습니다");
				tf = true;
			}
		}
		if(!tf) System.out.println("일치하는 상품이 없습니다");
	}
	
	//상품번호로 상품 삭제
	public void delete(String num) {
		boolean tf = false;
		for(int i=0; i<products.length; i++) {
			if(products[i] != null && products[i].getNum().equals(num)) {
				products[i] = null;
				System.out.println("삭제되었습니다");
				tf = true;
			}
		}
		if(tf == false) {
			System.out.println("일치하는 상품이 없습니다");
		}else {
			for(int i=0; i<products.length-1; i++) {
				if(products[i] == null && products[i+1] != null) {
					products[i] = products[i+1];
					products[i+1] = null;
				}
			}
		}
		
	}
	
	//전체 재고 상품 금액 구하기
	public int totalPrice() {
		int total = 0;
		for(int i=0; i<products.length; i++) {
			if(products[i] != null) {
				total += products[i].getPrice();
			}
		}
		return total;
	}
}
