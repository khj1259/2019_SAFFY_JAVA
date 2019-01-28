/**
 * 자바의 흐름 제어 : 삼항연산자,  if~else, switch~case
 */
public class Z03_IfElse {
	public static void main(String[] args) {
//		if(조건식) { // boolean 타입의 결과가 나오는 조건식 이어야 함
//			
//		} else { // 조건식이 거짓일 경우 실행됨
		
//		} // 블럭의 실행문이 1줄만 있다면 {} 를 생략 가능
		
		int num = 3;
		if (num == 3) {
			System.out.println("참");
		}
		if (num >= 0) {
			System.out.println("양수");
		} else {
			System.out.println("음수");
		}
		
		// 양수/0/음수
		if(num > 0) {
			System.out.println("양수");
		} else {
		
		}
		
//		if (조건1) {
//			조건1이 참일 경우
//		}else if (조건2) {
//			조건2가 참일 경우
//		}else if (조건3) {
//			조건3가 참일 경우
//		}else if (조건4) {
//			조건4가 참일 경우
//		}else {
//	    	모든 조건이 거짓일 경우
//		}
		
	}// end of main
}// end of calss
