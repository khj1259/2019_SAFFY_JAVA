package com.thread;

//Runnable 구현해서 thread 사용
class Lion implements Runnable{

	//Thread가 해야되는 작업 내용을 가진 메소드, callback method
	@Override
	public void run() {
		System.out.println("thread is running..."+Thread.currentThread().getName());
	}
}

public class LionTest{
	
	public static void main(String[] args) {
		Lion l1 = new Lion(); //thread는 아님. Runnable 객체. run()는 가지고 있음
		Thread t1 = new Thread(l1, "superman");
		t1.start();
		
		Thread t2 = new Thread(l1, "batmat");
		t2.start();
		
		Thread t3 = new Thread(l1, "spiderman");
		t3.start();
		
	}
}
