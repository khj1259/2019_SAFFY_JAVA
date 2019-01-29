import java.util.Scanner;

/**
 * 중간값 찾기
 */
public class Solution_2063_중간값찾기_김현정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N  = sc.nextInt(); //입력받을 수의 갯수
		int[] data = new int[N]; // 입력받은 수가 저장될 배열

//		1. N은 항상 홀수로 주어진다.
//		2. N은 9이상 199 이하의 정수이다. (9 ≤ N ≤ 199)
		for(int i=0; i<N; i++) {
			data[i] = sc.nextInt();
		}
		
		//정렬
		for(int j=0; j<data.length-1; j++) {
			for(int i=0; i<data.length-1; i++) {
				if(data[i] > data[i+1]) {
					int tmp = data[i];
					data[i] = data[i+1];
					data[i+1] = tmp;
				}
			}
		}
		
		System.out.println(data[(data.length/2)]);
	}
}
