package com.thread;

//Thread 상속 받아서 thread 사용
class Tiger extends Thread{
	
	//thread 가 해야되는 작업 내용을 가진 메소드, callback method
	public void run() {
		System.out.println("thread is running..."+getName());
	}
}

public class TigerTest {

	public static void main(String[] args) {
		Tiger t1 = new Tiger(); //thread 생성
		t1.start(); // thread가 실행
		t1.run();	// main이 실행

		Tiger t2 = new Tiger();
		t2.start();
		
		Tiger t3 = new Tiger();
		t3.start();
	}
}
