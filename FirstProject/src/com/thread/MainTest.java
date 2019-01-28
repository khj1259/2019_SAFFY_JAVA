package com.thread;

public class MainTest implements Runnable{

	public MainTest() {
		Thread t = new Thread(this);
		t.start();
		try {
			t.join(); // t의 작업이 끝날때 까지 t를 기다려 줌
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void test() {
		System.out.println("test method...");
	}
	
	public static void main(String[] args) {
		new MainTest().test();
		//test()는 main 스레드가 실행
		//main스레드가 사용자 정의 스레드보다 우선순위가 높다
	}

	@Override
	public void run() {	//thread가 수행하는 메서드
		System.out.println("thread ...run()");
	}
}
