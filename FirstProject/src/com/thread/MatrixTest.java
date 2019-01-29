package com.thread;

class Matrix extends Thread{
	int num;//자기가 맡은 단 값
	
	public Matrix(int num) {
		this.num = num;
	}

	//thread가 해야할 작업 내용을 가지고 있는 메소드 : 
	//자기가 맡은 단 한개를 출력
	public void run() {
		for(int i=1; i<=9; i++) {
			System.out.print(num+" x "+i+" = "+(num*i)+"\t");
		}
		System.out.println();
	}
}
public class MatrixTest {

	public static void main(String[] args) throws InterruptedException {
		
		for(int i=2; i<=9; i++) {
			Matrix m = new Matrix(i);
			m.start();
			m.join();
		}
		
	}
}
