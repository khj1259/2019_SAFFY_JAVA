import java.util.ArrayList;
import java.util.Scanner;

/**
 * 최빈수 구하기
 */
public class Solution_1204_SW문제해결기본1일차_최빈수구하기_김현정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수
		
		for(int i=1; i<=T; i++) {
			int num = sc.nextInt();// 테스트케이스 번호
			int[][] data = new int[1000][2];// 입력받은 값, 같은 값이 입력된 횟수
			for(int j = 0; j < 1000; j++) {
				boolean flag = false;	// 같은값이 있을때 true로 바꿀 변수
				int tmp = sc.nextInt(); // 점수 입력 받기
				for(int k = 0; k < 1000; k++) {
					if(tmp == data[k][0]) { // 입력받은 값이 이전에 입력받았었는지 확인
						data[k][1]++;
						flag = true;
					}
				}
				if(flag==false) {
					data[j][0] = tmp;
				}
			}
			
			int maxCnt=0; // 최빈수의 빈도수
			int maxScore=0; // 최빈수
			for(int l=0; l<1000; l++) {
				if(data[l][1] > maxCnt) {
					maxCnt = data[l][1];
					maxScore = data[l][0];
				}else if(data[l][1] == maxCnt) {
					if(maxScore < data[l][1]) {
						maxCnt = data[l][1];
						maxScore = data[l][0];
					}
				}
			}
			System.out.println("#"+i+" "+maxScore);
		}//end of testCase
		
	}// end of main
}// end of class
