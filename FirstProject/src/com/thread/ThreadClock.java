package com.thread;

import java.util.Date;

public class ThreadClock implements Runnable{

	public ThreadClock() {
		//thread 생성, start
		Thread t = new Thread(this); // this : 자기자신의 run메소드를 실행하도록 자기 자신인 Runnable객체를 인자로 줌
		t.start();
	}
	
	public static void main(String[] args) {
		ThreadClock clock = new ThreadClock();
	}

	@Override
	public void run() {
		//thread가 해야 하는 작업 내용 : 1초 간격으로 콘솔에 시간 출력하기
		while(true) {
			Date d = new Date();
			System.out.println(d.toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
