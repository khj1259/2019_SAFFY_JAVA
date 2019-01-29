package com.exception;

public class MyExceptionTest {

	public static void main(String[] args) {
		MyExceptionTest m = new MyExceptionTest();
		try {
			m.go(0);
			
		} catch (MyException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void go(int num) throws MyException, Exception {
		//num >= 0 정상, num < 0 예외 발생
		if(num > 0) {
			System.out.println(++num);
		}else { // 예외 발생
			throw new MyException();
		}
	}
}
