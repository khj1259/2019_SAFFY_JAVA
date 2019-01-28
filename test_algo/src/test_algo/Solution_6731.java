package test_algo;

import java.util.Scanner;

public class Solution_6731 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		int T = sc.nextInt();//테스트케이스
		
		for(int i=0; i<T; i++) {
			int N = sc.nextInt();
			String[][] map = new String[N][N];
			//입력
			for(int j=0; j<N; j++) {
				String[] s = sc2.nextLine().split("");
				for(int k=0; k<N; k++) {
					map[j][k] = s[k];
				}
			}
			
			
			
		}//end of testcase
		
	}//end of main
}//end of class
