package com.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {

	public static void main(String[] args) throws Exception{
		Customer c = new Customer(123, "tommy lee", "la");
		
		//객체 저장
		FileOutputStream fos = new FileOutputStream("save.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(c);
		oos.close();
		fos.close();
		
		//저장된 객체 읽기
		FileInputStream fis = new FileInputStream("data.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Customer c2 = (Customer) ois.readObject();
		
		System.out.println(c2.getNum());
		System.out.println(c2.getName());
		System.out.println(c2.getAddress());
		
	}
}
