package com.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
//Set : 중복 x, 순서 x
public class HashSetTest {
	
	public static void main(String[] args) {
		//TreeSet : 내용물이 정렬되는 set (알파벳 순서)
		TreeSet<String> set2 = new TreeSet<>();
		set2.add("steve");
		set2.add("apple");
		set2.add("orange");
		set2.add("mail");
		System.out.println(set2);
		System.out.println(set2.toString());
		
		
		HashSet<String> set = new HashSet<>();
		set.add("one");
		set.add("two");
		set.add("one");
		set.add("three");
		set.add("two");
		
		//iterator() : set안에 이쓴 모든 데이터를 꺼냄
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) { // Iterator안에 데이터가 있다면
			String val = iter.next(); // Iterator안에서 데이터 한개를 꺼냄
			System.out.println(val);
		}
		
		for(String num : set) {
			System.out.println(num);
		}
		set.remove("two");
		System.out.println(set);
	}
	
}
