import java.util.Scanner;

/**
 *  점프사방
 */
public class Solution32 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // testCase
		int cnt=0;
		while(cnt<T) {
			int x = sc.nextInt();// 배열의 크기x
			int y = sc.nextInt();// 배열의 크기y
			int N = sc.nextInt();// 참가자 수
			
			int[][] map = new int[x][y]; // 숫자판
			int money = -1000*N;
			
			for(int i=0; i<x; i++) {
				for(int j=0; j<y; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int[][] par = new int[N][3]; //각 참가자의 시작 행,열,횟수  입력받기
			for(int i=0; i<N; i++) {
				par[i][0] = sc.nextInt()-1;
				par[i][1] = sc.nextInt()-1;
				par[i][2] = sc.nextInt();
			}
			
			int ham = sc.nextInt(); // 함정 수
			//함정 입력받기
			for(int i=0; i<ham; i++) {
				int h_x = sc.nextInt()-1;
				int h_y = sc.nextInt()-1;
				map[h_x][h_y] = 0; // 함정은 0으로 
			}
			
			for(int i=0; i<N; i++) {
				int moveX = par[i][0];
				int moveY = par[i][1];
				int su = map[moveX][moveY];// 해당 좌표의 숫자
				
				for(int j=0; j<par[i][2]; j++) { // 각 참가자  이동 횟수만큼 반복
					
					if(su==0) {	//함정일 때
						break;
					}else {		//함정이 아닐 때
						int fir = su/10;// 숫자의 첫째자리
						int sec = su%10;// 숫자의 둘째자리
						if(fir == 1) {		// 동
							if((moveY+sec) >= map[0].length ) {
								su=0;
								break;
							}
							su = map[moveX][moveY+sec];
							moveY += sec;
						}else if(fir == 3) {// 서
							if((moveY-sec) < 0) {
								su=0;
								break;
							}
							su = map[moveX][moveY-sec];
							moveY -= sec;
						}else if(fir == 2) {// 남
							if((moveX+sec) >= map.length) {
								su=0;
								break;
							}
							su = map[moveX+sec][moveY];
							moveX += sec;
						}else {				// 북
							if((moveX-sec) < 0) {
								su=0;
								break;
							}
							su = map[moveX-sec][moveY];
							moveX -= sec;
						}
					}
				}
				money += (su * 100);
				
			}
			cnt++;
			System.out.println("#"+cnt+" "+money);
		}//end of testCase
		
	}//end of main
	
}//end of class
