package com.ssafy;

import java.util.ArrayList;

public interface IProductMgr {
	
	public void add(Product p) throws DuplicateException;
	public ArrayList<Product> search();
	public Product searchNum(String num) throws CodeNotFoundException;
	public ArrayList<Product> searchName(String name);
	public ArrayList<Tv> searchTV();
	public ArrayList<Refrigerator> searchRef();
	public ArrayList<Refrigerator> Ref400() throws ProductNotFoundException;
	public ArrayList<Tv> Tv50() throws ProductNotFoundException;
	public void update(String num, int price);
	public void delete(String num);
	public int totalPrice();
	
	void open();
	void close();
	void send();
}
