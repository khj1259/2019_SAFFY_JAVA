package com.thread;

//동기화(synchronization) : 멀티 thread가 공유데이터에 접근해서 작업할 때, 동시 접근이 안되도록 락을 거는 일.
//순차실행이 되는 결과. 코드 내에서 동기화 부분은 최소화 시키는 것이 좋음
public class SyncTest implements Runnable{

	public SyncTest() { //thread 생성, start
		Thread tom = new Thread(this, "tom");
		Thread jerry = new Thread(this, "jerry");
		
		tom.start();
		jerry.start();
	}
	
	public static void main(String[] args) {
		new SyncTest();
	}

	@Override
	public void run() {//thread가 수행하는 메소드
		//인터페이스로부터 나온 run()메소드에는 synchronized를 붙일 수 없으므로 별도의 메서드를 만들어서 실행시킴
		kitchen();
		bedroom();
	}

	private synchronized void bedroom() { // 동기화 키워드 synchronized : 락기능 - 같은 메서드에 스레드가 동시에 접근 불가
		String name = Thread.currentThread().getName();
		System.out.println(name+" 침실에 들어옴");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(name+" 침실에서 나감");
	}

	private synchronized void kitchen() {
		String name = Thread.currentThread().getName();
		System.out.println(name+" 부엌에 들어옴");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(name+" 부엌에서 나감");
	}
}
