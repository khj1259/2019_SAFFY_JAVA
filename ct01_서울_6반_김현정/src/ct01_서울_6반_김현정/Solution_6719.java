package ct01_서울_6반_김현정;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_6719 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.next()); // testCase
		
		for(int testCase=1; testCase<=T; testCase++) {
			//성수의 실력이 A라고 할 때, 수준이 M인 강좌를 시청하고 나면 성수의 실력은 (A+M)/2가 된다.
			int N = Integer.parseInt(sc.next()); //들을수 있는 강의 개수
			int K = Integer.parseInt(sc.next()); //강의중에서 선택할 개수
			int[] M = new int[N];
			
			for(int j=0; j<N; j++) {
				M[j] = Integer.parseInt(sc.next());
			}
			
			Arrays.sort(M);
			double answer=0;//결과값
			int cnt=0;
			for(int i=N-K; i<M.length; i++) {
					answer = (answer+M[i]) / 2;
			}
			
			
			System.out.println("#"+testCase+" "+answer);
		}//end testCase
	}//end main
}//end class
