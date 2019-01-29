/**
 * 재귀함수
 */
public class Z14_Recursive {
	
	public static int fact(int n) {
		if(n <= 1) { // 종료 파트
			return 1;
		}else { // 재귀 파트
			return n * fact(n-1);
		}
	}
	/** 피보나치  수열 함수 */
	public static int f(int n) {
		if(n >= 2 && memo[n] == 0) {// 계산을 안한 값이라면
			memo[n] =  f(n-1) + f(n-2);
		}
		return memo[n];
	}
	
	public static int[] memo = new int[9]; // 0
	
	public static void main(String[] args) {
//		System.out.println(fact(4));
		memo[0] = 0;
		memo[1] = 1;
		System.out.println(f(8)); // 피보나치 수열
		
//		DP 동적계획법 : f(8) 7 6 5 4 3 2 1 0 어차피 필요한 부품들이니까 작은해부터 구해서 올라오자
		int[] dp = new int[9];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2; i<dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[8]);
		
	}//end of main
}//end of class
