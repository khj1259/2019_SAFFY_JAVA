package com.thread;


class MyThread extends Thread{
	
	@Override
	public void run() {
		System.out.println("name:"+getName());
	}
}

public class PriorityTest {

	public static void main(String[] args) {
		MyThread m1 = new MyThread();
		MyThread m2 = new MyThread();
		MyThread m3 = new MyThread();
		System.out.println(m1.getPriority()); 
		
		m1.setPriority(Thread.MIN_PRIORITY);//우선순위 지정 1
		m2.setPriority(Thread.NORM_PRIORITY);//우선순위 지정 5(기본)
		m3.setPriority(Thread.MAX_PRIORITY);//우선순위 지정 10
		//우선순위를 지정해도 순서는 보장할 수 없다
		//순서를 보장하려면 join()을 써야 함!
		
		m1.start();
		m2.start();
		m3.start();
	}
}
