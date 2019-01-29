import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1225_SW문제해결기본7일차_암호생성기_김현정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=1; i<=10; i++) {
			Queue<Integer> q = new LinkedList<>();
			sc.next();// 테스트케이스
			
			for (int j = 0; j < 8; j++) {
				int su = Integer.parseInt(sc.next());
				q.offer(su);
			}
			int cnt = 1;// 감소할 양
			while(true) {
				if(cnt>5) {
					cnt = 1;
				}
				int su2 = q.poll()-cnt;
				
				if(su2<=0) {
					q.offer(0);
					break;
				}
				q.offer(su2);
				cnt++;
			}
			String answer = "";
			while(!q.isEmpty()) {
				answer += " "+q.poll();
			}
			System.out.println("#"+i+answer);
			
		}//end of testCase
		
	}// end of main
}// end of class
