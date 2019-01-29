package com.ssafy;

import java.util.ArrayList;

public class ProductMgrImpl implements IProductMgr{
	ArrayList<Product> list;
	
	public ProductMgrImpl() {
		list = new ArrayList<>();
	}
	
	@Override
	public void add(Product p) {
		list.add(p);
		
	}

	@Override
	public ArrayList<Product> search() {
		return list;
	}

	@Override
	public Product searchNum(String num) {
		Product tmp = null;
		
		for(Product p : list) {
			if(p.getNum().equals(num)) {
				tmp = p;
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Product> searchName(String name) {
		ArrayList<Product> tmp = new ArrayList<>();
		
		for(Product p : list) {
			if(p.getName().equals(name)) {
				tmp.add(p);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Tv> searchTV() {
		ArrayList<Tv> tmp = new ArrayList<>();
		
		for(Product p : list) {
			if(p instanceof Tv) {
				tmp.add((Tv) p);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Refrigerator> searchRef() {
		ArrayList<Refrigerator> tmp = new ArrayList<>();
		
		for(Product p : list) {
			if(p instanceof Refrigerator) {
				tmp.add((Refrigerator) p);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Refrigerator> Ref400() {
		ArrayList<Refrigerator> tmp = new ArrayList<>();
		
		for(Refrigerator b : searchRef()) {
			if( b.getLiter() >= 400) {
				tmp.add(b);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Tv> Tv50() {
		ArrayList<Tv> tmp = new ArrayList<>();
		
		for(Tv b : searchTV()) {
			if( b.getInch() >= 50) {
				tmp.add(b);
			}
		}
		return tmp;
	}

	@Override
	public void update(String num, int price) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getNum().equals(num)) {
				list.get(i).setPrice(price);
			}
		}
	}

	@Override
	public void delete(String num) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getNum().equals(num)) {
				list.remove(i);
			}
		}
	}

	@Override
	public int totalPrice() {
		int total=0;
		for(Product p : list) {
			total += p.getPrice();
		}
		return total;
	}

}
