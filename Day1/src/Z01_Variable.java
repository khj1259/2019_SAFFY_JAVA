import javax.swing.plaf.synth.SynthSeparatorUI;

/** 
 * 변수: 데이터를 저장하는 기억공간
 */
public class Z01_Variable {
	public static void main(String[] args) {
//		 변수: 기본형(크기가 약속된 8가지), 참조형(기본형이 아닌 나머지)
//		 정수형: byte(1), short(2), "int(4)", long(8)
//		 실수형: float(4), "double(8)"
//		 문자형: char(2)
//		 논리형: boolean(1)			1바이트=8비트
		
		int a; // 변수의 선언 a-식별자
		a=3; //값을 할당  assignment, 초기화
		a=5; //마지막에 저장한 데이터 하나만 기억된다.
		int b=3; // 변수의 선언과 초기화를 한번에
		
		byte c=4;
		short d=5;
		int e= 6;
		long f= 2100000000L;//리터럴 접미사 L or l  (대소문자 L)
		
		float g= 3.14f; //리터럴 접미사 F or f (대소문자 f)
		double h= 3.14; //리터럴 접미사 D or d or 생략가능 (컴파일러 기본값)
		// 실수 표현 : 부동소수점 연산, 오차 발생할 수 있다
		h = 1.; // 1.0
		h = .3; // 0.3
		
		char i = 'a';  //글자 하나를 저장
		i = '\u0061'; // 유니코드값으로 표현
		i = 97; // 10진수로 표현
		System.out.println(i);
		
		boolean j = true; // 논리형  true/false
		
		// 변수 명명 규칙(반드시 지키기)
//		1. 대소문자가 구분된다. 길이의 제한이 없다
//		2. 숫자로 시작하면 안된다.
//		3. 특수문자 _ $ 두가지만 가능
//		4. 키워드(언어를 위한 예약어)를 사용하면 안된다
		
		// 네이밍 룰 (권장사항)
//		변수의 첫 글자 소문자
//		메서드의 첫 글자 소문자
//		클래스의 첫 글자 대문자
//		새로운 단어의 첫 글자를 대문자로 int numberOfApples;
		
		int x = 3;
		int y = 4;
		
		//x의 값과  y의 값을 교환
		int temp = x;
		x = y;
		y = temp;
		
		System.out.println(x); // 4
		System.out.println(y); // 3
		
		// 문자열
		String s = "hello"; // 쌍따옴표로 묶는다
		s = "hi" + "안녕"; // 문자열을 이어붙여줌
		s = "hi" + 3; //문자열 + 비문자열 => 비문자열을 문자열로 변환해서 덧셈연산
//			"hi" + "3"
		s = 3 + 4 +"hi" + 3 + 4; // 7hi34
		System.out.println(s);
		
		// 상수 : 값을 변경할 수 없는 메모리, 프로그램 종료시까지 값을 변경 불가
		// 상수명은 대문자로 쓰자 NUMBER_OF_APPLES
		final double PI = 3.14;
		
		// 형변환 Casting
		double d1 = 3.14;
		int i1 = (int)d1; // 에러, 데이터의 손실이 있을 경우, 직접 명시적 형변환을 해야 한다.
		int i2 = 4;
		double d2 = i2; // ok, 데이터의 손실이 없을 경우, 컴파일러가 자동형변환을 해준다. (묵시적 형변환)
//		byte, short, char -> int -> long(8) -> float(4) -> double(8) (자동형변환)
		
		double dd= 3.14;
		
		System.out.println((int)dd);
		char cc = 'a'; // 97
		System.out.println((int)cc);
		int xx = 98;
		System.out.println((char)xx);
		
		//진법
		System.out.println(11); // 10진수
		System.out.println(0b11); // 0b or 0B 2진수 0~1
		System.out.println(011); // 0 8진수 0~7
		System.out.println(0x11); // 0x or 0X 16진수 0~9, a~f or A~F
		
		
	}// end of main
}// end of class