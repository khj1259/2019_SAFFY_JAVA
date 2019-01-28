/**
 * 3+4
 * Operator 연산자 : 특정한 약속된 기능을 수행하는 기호 or 단어, + 
 * 피연산자 : 연산자에 의해서 연산 당하는 것, 3 4
 */
public class Z02_Operator {
	public static void main(String[] args) {
//		연산자 : 단항연산자, 이항연산자, 삼항연산자, 대입연산자
		// 단항연산자 : 부호연산자, 증감연산자, 캐스팅, 논리부정
		int num = 3;
		System.out.println(-num); // 부호연산자
		
		num = 3;
		num++; // num값을 1증가
		System.out.println(num);

		num = 3;
		++num; // num값을 1증가
		System.out.println(num);
		
		System.out.println("전치증감연산자");
		num = 3;
		System.out.println(++num);	// 4, 증감 후 참조
		System.out.println(num);	// 4

		System.out.println("후치증감연산자");
		num = 3;
		System.out.println(num++);	// 3, 참조 후 증감
		System.out.println(num);	// 4
		
		num = ++num + ++num + num++ + num++;
		
		num = 123;
		System.out.println((double)num); // 캐스팅 연산자
		
		boolean x = true;
		System.out.println(!x); // 논리 부정 연산자
		
		byte b = 0b01101100;
//		~b		 0b10010011;
		System.out.println(~b); // 비트 부정 연산자 : 각 비트값을 반대로 바꿈
		
		// 이항 연산자 : 산술, 비교, 비트, 논리, 쉬프트
//		이항연산자의 규칙:
//		1. 두 피연산자가 타입이 같아야 한다. 다르면 컴파일러가 데이터의 손실이 없는 방향으로 자동형변환 해준다.
//		byte, short, char => int => long => float => double
//		2. 연산 결과도 같은 타입으로 리턴된다.
//		3. int형 이하의 타입은 이항연산시 int형으로 자동형변환 된다.
//			byte, short, char, int
		
		System.out.println("산술연산자");
		System.out.println(7 + 3); // 10
		System.out.println(7 - 3); // 4
		System.out.println(7 * 3); // 21
		System.out.println(7 / 3); // 2
		System.out.println(7 % 3); // 1 나머지 연산자
		System.out.println(7 / 3f); // 2.333 (float), 7.0 3.0
		
		System.out.println("비교연산자"); // true/false 로 리턴됨
		System.out.println(3 < 7);
		System.out.println(3 <= 7);
		System.out.println(3 > 7);
		System.out.println(3 >= 7);
		System.out.println(3 == 7); //같다
		System.out.println(3 != 7); //다르다
		
		System.out.println("쉬프트 연산자");
		int a = 1;
		System.out.println(a << 0);
		System.out.println(a << 1); // * 2의1승
		System.out.println(a << 2); // * 2의2승
		System.out.println(a << 3); // * 2의3승
		System.out.println(a << 4); // * 2의4승
		
		a = -16;
//		>> 부호비트는 보존, 나머지비트만 쉬프트
		System.out.println(a >> 0); 
		System.out.println(a >> 1); // / 2의1승
		System.out.println(a >> 2); // / 2의2승
		System.out.println(a >> 3); // / 2의3승
		System.out.println(a >> 4); // / 2의4승

		a = -16;
//		>>> 부호비트도 쉬프트
		System.out.println(a >>> 0); 
		System.out.println(a >>> 1); // / 2의1승
		System.out.println(a >>> 2); // / 2의2승
		System.out.println(a >>> 3); // / 2의3승
		System.out.println(a >>> 4); // / 2의4승
		
		// 비트 | & ^
		System.out.println("비트연산자"); // 2진수의 각 비트끼리 연산
		System.out.println(6 | 3); // 7
		System.out.println(6 & 3); // 2
		System.out.println(6 ^ 3); // 5
		
		// 논리 || &&		논리값들만 연산 가능
		System.out.println(true || true);	// true
		System.out.println(true || false);	// true
		System.out.println(false || true);	// true
		System.out.println(false || false); // false

		System.out.println(true && true);	// true
		System.out.println(true && false);	// false
		System.out.println(false && true);	// false
		System.out.println(false && false); // false
		
		// 삼항연산자
//		조건식 ? 참일 경우 수행할 문장 : 거짓일 경우 수행할 문장
		int c = 3+1 < 2*2 ? 100 : 0;
		System.out.println(c);
		
		// 대입연산자 : 이항연산자와 등호의 조합
		int t = 3;
		t += 1; //t = t + 1;
		t -= 1; //t = t - 1;
		t *= 1; //t = t * 1;
		t /= 1; //t = t / 1;
		t %= 1; //t = t % 1;
		t |= 1; //t = t | 1;
		t &= 1; //t = t & 1;
		t ^= 1; //t = t ^ 1;
		
	}// end of main
}// end of class
