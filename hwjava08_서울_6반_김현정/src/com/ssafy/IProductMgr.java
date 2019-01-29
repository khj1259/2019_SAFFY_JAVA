package com.ssafy;

import java.util.ArrayList;

public interface IProductMgr {
	public void add(Product p);
	public ArrayList<Product> search();
	public Product searchNum(String num);
	public ArrayList<Product> searchName(String name);
	public ArrayList<Tv> searchTV();
	public ArrayList<Refrigerator> searchRef();
	public ArrayList<Refrigerator> Ref400();
	public ArrayList<Tv> Tv50();
	public void update(String num, int price);
	public void delete(String num);
	public int totalPrice();
}
