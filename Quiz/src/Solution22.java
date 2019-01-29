import java.util.Scanner;
/**
 * 소금쟁이 합계
 */
public class Solution22 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // testCase
		
		
		int testCase=0;
		while(testCase<T) {
			
			int N = sc.nextInt(); // 연못 크기
			int num = sc.nextInt(); // 소금쟁이 수
			int[][] map = new int[N][N];
			int x=0, y=0, z=0; // 소금쟁이의 행,열, 방향
			
			for(int i=0; i<num; i++) { 
					x=sc.nextInt();
					y=sc.nextInt();
					z=sc.nextInt();
					
					if(z==1) { // 상
						if(x-6>=0 && map[x-6][y] != 1) {
							map[x-6][y] = 1;
						}
					}else if(z==2) { // 하
						if(x+6<N && map[x+6][y] != 1) {
							map[x+6][y] = 1;
						}
					}else if(z==3) { // 좌
						if(y-6>=0 && map[x][y-6] != 1) {
							map[x][y-6] = 1;
						}
					}else { //우
						if(y+6<N && map[x][y+6] != 1) {
							map[x][y+6] = 1;
						}
					}
			}
			int cnt=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]==1) {
						cnt++;
					}
				}
			}
			testCase++;
			System.out.println("#"+testCase+" "+cnt);
		}// end of testCase
		
	}//end of main
	
	
	
}//end of class
