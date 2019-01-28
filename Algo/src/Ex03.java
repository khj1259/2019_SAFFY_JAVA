import java.util.Arrays;

public class Ex03 {
	public static void main(String[] args) {
		int[][] m = {{9,20,2,18,11},
					{19,1,25,3,21},
					{8,24,10,17,7},
					{15,4,16,5,6},
					{12,13,22,23,14}};
		
		int[] arr = new int[m.length * m[0].length];
		for (int i = 0, k = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++, k++) {
				arr[k] = m[i][j];
			}
		}
		Arrays.sort(arr); // 오름차순 정렬
		System.out.println(Arrays.toString(arr));
		
		int[][] w = new int[m.length][m.length];
		int r =  0; // 행
		int c = -1; // 열
		int size = m.length; //5, 연속으로 이동할 크기
		int index = 0;
		
		while (size > 0) {
			for (int i = 0; i < size; i++) { // 우
				c++; // 이동
				w[r][c] = arr[index++];
			}
			size--;
			for (int i = 0; i < size; i++) { // 하
				r++; // 이동
				w[r][c] = arr[index++];
			}
			for (int i = 0; i < size; i++) { // 좌
				c--; // 이동
				w[r][c] = arr[index++];
			}
			size--;
			for (int i = 0; i < size; i++) { // 좌
				r--; // 이동
				w[r][c] = arr[index++];
			} 
		}
		
		//화면에 w 배열 출력
		for (int i = 0; i < w.length; i++) {
			for (int j = 0; j < w[i].length; j++) {
				System.out.printf("%2d ", w[i][j]);
			}
			System.out.println();
		}
		System.out.println("r:"+r+", c:"+c);
		
	}//end of main
}//end of class
