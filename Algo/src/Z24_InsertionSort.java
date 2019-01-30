import java.util.Arrays;
import java.util.Random;

/**
 * 삽입정렬
 */
public class Z24_InsertionSort {
	public static void main(String[] args) {
		long time = System.currentTimeMillis(); // 현재 시스템의 시각 1970.01.01. 0:0:0.0ms long
//		int[] arr = {4, 1, 7, 0, 5, 6, 8, 2, 9, 3};
		int[] arr = new int[60000];
		Random ran = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ran.nextInt(arr.length);
		}
		
		System.out.println(Arrays.toString(arr));
		
		//삽입정렬 구현
		for (int i = 1; i < arr.length; i++) { // 삽입할 대상
			for(int j=i-1; j>=0; j--) { // 이미 정렬된 범위의 뒤에서 앞으로
				if(arr[j+1] < arr[j]) {
					int tmp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = tmp;
				}else {
					break;
				}
			}
		}
//		삽입할 위치를 찾을 때 이진검색트리를 사용한다
//		System.arraycopy(src, srcPos, dest, destPos, length); // 영역을 통째로 복사
		
		System.out.println(Arrays.toString(arr));
		System.out.println(System.currentTimeMillis() - time + "ms");
		
	}//end main
}//end class
