import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_후위순회_김현정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine()); // 정점의 개수
//		13
//		1 2 1 3 2 4 3 5 3 6 4 7 5 8 5 9 6 10 6 11 7 12 11 13
		String str = br.readLine(); // 간선 정보
		StringTokenizer st = new StringTokenizer(str, " ");

		// 이진트리 저장
		int[] arr = new int[32]; // V정점의 개수 , 2의 V승 1>>V (31승까지 할수 있다)
		arr[1] = 1; // 루트번호 지정
		while (st.hasMoreTokens()) {
			int start = Integer.parseInt(st.nextToken()); // 간선의 시작정점
			int end = Integer.parseInt(st.nextToken()); // 간선의 끝 정점

			for (int i = 1; i < arr.length; i++) { // 0번 정점은 안씀, start 정점값이 저장된 배열의 위치 찾기
				if (start == arr[i]) {
					// 간선에서 자식 정점을 저장, 왼쪽 자식이 없으면 왼쪽에 저장, 왼쪽자식이 있으면 오른쪽에 저장
					if (arr[i * 2] == 0) { // 왼쪽 자식이 없음
						arr[i * 2] = end;
					} else { // 왼쪽 자식이 있음
						arr[i * 2 + 1] = end;
					}
					break;
				}
			}
		}
		// 저장된 트리를 출력하기
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 1; i < 5; i++) {
			hs.add(1 << i);
		}
//		System.out.println(hs);

		for (int i = 1; i < arr.length; i++) {
			if (hs.contains(i)) { // 2의 지수승일때
				System.out.println();
			}
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		// 이진트리 순회
		System.out.print("\n후위순회:");
		postOrder(arr, 1); // 후위순회

	}// end main

	// 후위순회
	private static void postOrder(int[] arr, int index) {
		if (index * 2 < arr.length && arr[index * 2] != 0) { // 왼쪽 자식
			postOrder(arr, index * 2);
		}
		if (index * 2 + 1 < arr.length && arr[index * 2 + 1] != 0) { // 오른쪽 자식
			postOrder(arr, index * 2 + 1);
		}
		System.out.print(arr[index] + " "); // 부모(나)
	}

}// end class
