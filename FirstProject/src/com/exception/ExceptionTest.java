package com.exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 9, b = 0, c = 0;
		int[] ar = {1,2,3};
		try {
			System.out.println(ar[-9]);
			c = a / b;
		}catch (Exception e) { 
			System.out.println("exception 발생~");
		}finally {
			System.out.println("finally...");
		}
		/*catch (ArithmeticException e) {
			System.out.println("111"+e.getMessage());
			
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("222"+e.getMessage());
		}*/
		System.out.println(c);
	}
}
