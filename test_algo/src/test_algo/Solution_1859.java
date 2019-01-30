package test_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1859 {
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int testCase=1; testCase<=T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			String str = br.readLine(); //한줄을 통째로
			
			StringTokenizer st = new StringTokenizer(str, " ");
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			long sum = 0; // 누적할 값
			int max = 0; // 매매가의 최대값 
			for (int i = N-1; i >= 0; i--) { //뒤에서부터 역순
				if(max < arr[i]) {
					max = arr[i];
				}else { 
					sum += max - arr[i];
				}
			}
			
			System.out.println("#"+testCase+" "+sum);
			
		}//end testCase
		
	}//end main
}//end class
