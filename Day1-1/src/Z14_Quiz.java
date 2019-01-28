import java.util.Random;

/**
 * 랜덤, 변수스코프, 기타
 */
public class Z14_Quiz {
	public static void main(String[] args) {
//		자바의 랜덤 2가지
		double d = Math.random();// 무작위 랜덤값 double 리턴 0.0 <= d < 1.0
		System.out.println(d);
//		1~45 사이의 값으로 만들기
//		0.0 <= d * 45 < 45.0
//		1.0 <= d * 45 + 1 < 46.0
//		1   <= (int)(d * 45 + 1) < 46
		
		Random ran = new Random();
		int a = ran.nextInt(45) + 1; // 1 <= a < 46
		
		//////////////////////////////////////////////////////////
		
//		알고리즘 설계기법
//		1. BruteForce (완전탐색)
//		2. Greedy (탐욕기법)
//		3. BackTracking (가지치기)
//		4. Divid & Conquer (분할정복)
//		5. DP (동적계획법)
		
	}// end of main
	
	// 전역변수 : 클래스 안쪽 && 메서드 바깥쪽에 선언
	// 초기값 : 각 타입의 기본값 정수:0, 실수:0.0, 문자:\u0000, 논리형:false, 참조형:null
	int b;	// non-static 변수, 인스턴스변수
			// 사용범위 : 객체생성 시점~참조변수 없어질때까지
			// 삭제 시점 : 참조변수가 없어지면, 가비지 컬렉터에 의해 나중에 알아서 삭제된다
	static int c; // static 변수 - 속도가 빠르다
			// 사용범위 : 클래스정보가 처음 로딩될 때~프로그램 종료시까지
			// 삭제시점 : 프로그램 종료시
	void ppp () { // 메서드
		int a; // 지역변수 : 메서드 안쪽에 선언
				// 초기값 : 없음
				// 사용범위 : 선언문이 실행된 지점~ 블럭}
				// 삭제 시점 : 블럭을 빠져나가면 즉시 삭제
//		System.out.println(a); // 초기화 전에 사용불가
		
	}
}// end of class
