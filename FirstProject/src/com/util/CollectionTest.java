package com.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		//1.allAll
		Collections.addAll(list, "apple","orange","banana");
		System.out.println(list.toString());
		
		//2.sort
		Collections.sort(list);
		System.out.println(list.toString());
		Collections.sort(list, Comparator.reverseOrder()); //반대로 내림차순 정렬
		System.out.println(list.toString());
		
		//3.search
		System.out.println(Collections.binarySearch(list, "banana"));//0부터
		System.out.println(Collections.binarySearch(list, "grape"));//1부터, -는 없다는 의미
		
		//4.copy
		ArrayList<String> fruit = new ArrayList<>();
		Collections.addAll(fruit, "one","two","three");
		Collections.copy(fruit, list);//destination, source
		System.out.println(fruit.toString());
		
		//5.fill
		Collections.fill(list, "here i am");
		System.out.println(list.toString());
		
	}
}
