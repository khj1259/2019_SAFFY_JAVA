package com.inter;
class Tom{
	int age = 50;
}
interface Hillary{
	int age = 46; // static, final
}

public class LittleTom extends Tom implements Hillary{
	int age = 23;
	
	private void test() {
		System.out.println(age);//23
		System.out.println(this.age);//23
		System.out.println(super.age);//50
		System.out.println(Hillary.age);//46
//		Hillary.age = 48; 값 변경 불가
	}
	
	public static void main(String[] args) {
		LittleTom little = new LittleTom();
		little.test();
	}
	
}
