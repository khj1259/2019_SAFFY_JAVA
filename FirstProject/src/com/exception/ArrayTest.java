package com.exception;
//runtime exception : java.lang.ArrayIndexOutOfBoundsException
public class ArrayTest {
	
	public static void main(String[] args) {
		int[] arr  = {1,2,3,4,5};
		
		//exception handling
		for (int i = 0; i <= arr.length; i++) {
			try {
				System.out.println(arr[i] +": hello");
			}catch (ArrayIndexOutOfBoundsException q) { // q : 발생한 예외 정보를 담고 있는 변수
				System.out.println("oops..");
				System.out.println(q.getMessage());
			}
		}
		System.out.println("done..");
	}
}
