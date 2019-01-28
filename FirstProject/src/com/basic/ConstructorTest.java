package com.basic;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;

public class ConstructorTest {
	
	public static void main(String[] args) {
		String s = "hello";
		String s2 = new String("hello2");
		
		char[] array = {'a', 'b', 'c', 'd'};
		String s3 = new String(array);
		System.out.println(s3);
		
		Frame f = new Frame("hello");
		f.setLayout(new FlowLayout());
		Button b = new Button("press");
		Checkbox cb =  new Checkbox("checkbox");
		Checkbox cb2 = new Checkbox("checkbox2", true);
		f.add(b);
		f.add(cb);
		f.add(cb2);
		
		f.setSize(300, 300);
		f.setVisible(true);
		
	}
}
