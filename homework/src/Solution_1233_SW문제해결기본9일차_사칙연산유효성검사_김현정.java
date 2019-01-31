import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1233_SW문제해결기본9일차_사칙연산유효성검사_김현정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int testCase = 1; testCase <= 10; testCase++) {
			int N = Integer.parseInt(br.readLine().trim()); // 정점의 총 수
			String[] arr = new String[N + 1];// 루트노드 1
			String[] cal = {"/", "*", "+", "-"};// 연산자
			int result = 1; // 결과 유효하면1, 아니면0
			for (int i = 1; i <= N; i++) {
				String str = br.readLine().trim(); // 정점 하나의 정보
				String[] node = str.split(" ");
				if(node.length > 2) { //단말 노드가 아님(자식 노드가 있음)
					if(!(Arrays.asList(cal).contains(node[1]))) { // 정점이 연산자가 아님
						result = 0;
//						break;
					}
				}else { //단말노드임
					if(Arrays.asList(cal).contains(node[1])) { // 연산자임
						result = 0;
//						break;
					}
				}
			}
			System.out.println("#"+testCase+" "+result);
		} // end testCase

	}// end main
}// end class
