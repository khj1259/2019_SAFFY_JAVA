package test_algo;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //testCase
		
		for(int test_case = 1; test_case <= T; test_case++){
			//(1 ≤ N ≤ 20, 1 ≤ L ≤ 104)
			int N = sc.nextInt();// 재료의 수
			int L = sc.nextInt(); // 제한 칼로리
			int[][] food = new int[N][2];
			
			int score = 0; // 햄버거 점수
			int best = 0; // 가장 높은 햄버거 점수
			int K = 0; // 햄버커 칼로리
			
			for(int i=0; i<N; i++) {
				food[i][0] = sc.nextInt(); // 재료의 점수
				food[i][1] = sc.nextInt(); // 재료의 칼로리 
			}
			
			
			for(int i=0; i<N; i++) {
				if(K+food[i][1] <= L) {
					score += food[i][0];
					K += food[i][1];
				}else {
					if(best < score) {
						best = score;
					}
					break;
				}
			}
			System.out.println("#"+test_case+" "+best);
			
		}//end of testCase
		
	}//end of main
}//end of class
