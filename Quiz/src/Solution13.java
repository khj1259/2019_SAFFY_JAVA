import java.util.Scanner;

/**
 *  문제 13 빌딩
 */
public class Solution13 {
	public static void main(String[] args) {
		int[][] diff = {{-1,-1}, {-1, 0}, {-1, 1},
						{ 0,-1}, 		  { 0, 1},
						{ 1,-1}, { 1, 0}, { 1, 1}
		}; // 행, 열
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();// testCase
		for(int testCase=1; testCase <= T; testCase++) {
			int N = sc.nextInt(); // 부지의 크기
			int[][] map = new int[N+2][N+2]; // 상하좌우 빈칸을 둔다
			// 배열에 경계를 벗어나는 문제를 해결하기 위해서
			for(int i=1; i<=N; i++) {	//1~N
				for(int j=1; j<=N; j++) {
					map[i][j] = sc.next().charAt(0); // 하나의 문자를 저장
				}
			}
			int max = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(map[i][j] == 'G') { // 빌딩을 세울수 없다
						continue; // 다음칸으로 넘어가라
					}
					// i,j 위치의 인접한 곳에 G 가 있는지 확인
					boolean isG = false;
					
					
					for(int k=0; k < diff.length; k++) {
						if(map[i+diff[k][0]][j+diff[k][1]] == 'G') {
							isG = true;
							break;
						}
					}
					int h = 0;
					if(isG) { // 인접한 곳에 G가 있음
						//높이 2층
						h = 2;
					}else { // 인접한 곳에 G가 없음
						// i행, j열의 B개수 만큼 빌딩을 올릴 수 있다
						for(int k = 1; k <= N; k++) {
							if(map[i][k] == 'B') {
								h++;
							}
							if(map[k][j] == 'B') {
								h++;
							}
						}
						h--; // i,j 자리를 2번 세었으므로 1번 빼기
					}
					// 현재 i,j 자리 빌딩 높이 h가 최대값이면 갱신
					if(max < h) {
						max = h;
					}
				}
			}
			System.out.println("#"+testCase+" "+max);
		}
		
	}//end of main
}//end of class
