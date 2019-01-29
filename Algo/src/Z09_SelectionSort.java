import java.util.Arrays;

/**
 * 선택정렬
 */
public class Z09_SelectionSort {
	public static void main(String[] args) {
		int[] m = {4,7,1,8,5,9,6,3,2};
		System.out.println("최초");
		
		for (int i = 0; i < m.length; i++) {	// 정렬할 영역의 범위의 시작 index
			//최소값의 index를 찾기
			int minIndex = i; // 정렬할 영역 범위의 시작 index
			for (int j = i; j < m.length; j++) {
				if(m[minIndex] > m[j]) {
					minIndex = j;
				}
			}
			// i <-> minIndex
			int temp = m[i];
			m[i] = m[minIndex];
			m[minIndex] = temp;
			System.out.println(Arrays.toString(m));
		}
		System.out.println(Arrays.toString(m)+" 완료");
		
	}//end of main
}//end of class
