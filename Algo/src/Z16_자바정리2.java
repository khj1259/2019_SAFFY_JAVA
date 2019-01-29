/**
 * 자바정리2
 */
public class Z16_자바정리2 {
	public Z16_자바정리2() {
		// TODO Auto-generated constructor stub
	}
	public Z16_자바정리2(int a) {
		// TODO Auto-generated constructor stub
	}
	static void a(boolean x, int y) {}
	static void a(int y, boolean x) {}
	static void a(boolean x) {}
	static void a(int x) {}
	static void a() {}
	
	public static void main(String[] args) {
//		overloading 오버로딩 : 하나의 클래스 내에서 동일한 메서드명을 사용하는 기법
//					조건 : 매개변수의 개수 or 타입 or 순서가 달라야 한다 
//		overriding 오버라이딩:	두 클래스(부모-자식)관계에서 부모클래스의 메서드를 자식클래스에서 재정의 하는 기법 
		a();
		C c = new C();
		c.print();
//		new Man(); // abstract class는 객체생성 불가
	} // end of main
}// end of class

interface Movable {
	void move();
}
interface Fightable {
	void fight();
}
interface Attackable extends Movable, Fightable{ // 인터페이스 끼리는 다중상속이 가능
	
}
class Attack implements Attackable{
	@Override
	public void move() {
		// TODO Auto-generated method stub
	}

	@Override
	public void fight() {
		// TODO Auto-generated method stub
	}
	
}

interface Aable { // 알맹이는 하나도 없는 완전한 껍데기, 상수, 추상메서드만 포함 가능
	public static final int a = 3; // 상수
	int b = 4; // 부족한 제어자를 컴파일러가 추가해 준다
	public abstract void p();
	void q(); // 부족한 제어자를 컴파일러가 추가해 준다
}




abstract class Man{ //abstract 메서드가 하나라도 있으면, class도 abstract로 선언해줘야 한다
	int a;	// 변수
	static int b;
	abstract void p(); // 추상 메서드 : 선언부만 작성한 메서드, abstract를 선언해줘야 한다
	void q() {	//일반 메서드
		
	}
}

abstract class ManMan extends Man{
//	추상 메서드를 가진 클래스를 상속받으면 해당 클래스도 abstract로 선언해주거나, 추상메서드를 오바라이드 해야 한다
//	@Override
//	void p() {
//		// TODO Auto-generated method stub
//		
//	}
	
}

//	패키지 명 : 첫글자 소문자 
//	클래스 명 : 첫글자 대문자
//	생성자 명 : 첫글자 대문자()
//	메서드 명 : 첫글자 소문자()
//	변수명     : 첫글자 소문자


class P{
	void print() {
		System.out.println("안녕 난 P 야");
	}
}
class C extends P{

	@Override
	void print() { // 접근제어자를 더 큰 범위로는 가능, 더 작은 범위는 불가능
		System.out.println("난 C 야");
	}
	
}
