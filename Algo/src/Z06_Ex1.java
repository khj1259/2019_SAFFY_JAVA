import java.util.Random;

/**
 * 연습문제 1
 */
public class Z06_Ex1 {
	public static void main(String[] args) {
//		double d = Math.random(); // java.lang 임포트 없이 사용할 수 있다
		Random ran = new  Random();
//		int num = ran.nextInt(10); // 0 <= num < 10
		int[][] m = new int[7][7]; // 윗쪽 한줄 안씀, 아래쪽 한줄, 왼쪽한줄, 오른쪽 한줄
		for (int i = 1; i < m.length-1; i++) {
			for (int j = 1; j < m[i].length-1; j++) {
				m[i][j] = ran.nextInt(10) + 1; // 1~10
			}
		}
		for (int i = 1; i < m.length-1; i++) { // 절대값이 생기지 않도록 값을 복사해 줌
			m[i][0] = m[i][1];
			m[i][m.length-1] = m[i][m.length-2];
			m[0][i] = m[1][i];
			m[m.length-1][i] = m[m.length-2][i];
		}
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.printf("%2d ",m[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		//인접칸과의 절대값 구하기
		int[] di = {-1, 1, 0, 0}; // 행의 차이값. 상 하 좌 우
		int[] dj = {0, 0, -1, 1}; // 열의 차이값
		
		int total = 0;
		for (int i = 1; i < m.length-1; i++) {
			for (int j = 1; j < m.length-1; j++) {
				int sum = 0; // i,j 칸에서 인접칸과의 절대값의 합
				for (int k = 0; k < dj.length; k++) {
					int num = m[i][j] - m[i+di[k]][j+dj[k]]; // 상
					if(num < 0) {
						num = -num;
					}
					sum += num;
				}
				total += sum;
				System.out.printf("%2d ", sum);
			}
			System.out.println();
		}
		System.out.println(total);
		
	} // end of main
}// end of class
