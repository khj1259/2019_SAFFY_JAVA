/**
 * 자바의 반복문 : for, while, do~while
 */
public class Z04_For {
	public static void main(String[] args) {
//			초기식; 조건식; 증감식
		for(int i=0; i<3; i++) {
			System.out.println(i);
		}
		// 0 1 2 3 4 5
		for(int i=0; i<6 ; i++) {
			System.out.print(i); // 줄바꿈
		}
		System.out.println();
		
		// 2 4 6 8 10
		for(int i=2; i<=10; i+=2) {
			System.out.print(i);
		}
		System.out.println();
		// 5 4 3 2 1
		for(int i=5; i>0; i--) {
			System.out.print(i);
		}
		System.out.println();
		// 1 4 7 10 13
		for(int i=1; i<=13; i+=3) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		// 이중 for
		for (int i=0; i<3; i++) {
			for(int j=14; j<17; j++) {
				System.out.println(i+","+j);
			}
		}
		
//*		
//**	
//***		
//****		
//*****
		for(int i=1; i<6; i++) {
			for(int j=0; j<5; j++) {
			}
		}
		
		
	}// end of main
}// end of class
