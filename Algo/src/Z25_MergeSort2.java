import java.util.Arrays;

/**
 * 병합정렬2 - 배열사용
 */
public class Z25_MergeSort2 {
	static int[] temp; // 임시배열을 준비
	private static void mergeSort(int[] arr, int left, int right) {
		if(right - left <= 1) { // 종료파트
			return;
		}else { // 반복파트
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid, right);
			merge(arr, left, mid, right); //mid를 중심으로 영역을 반 나눔
			return;
		}
		
	}
	
	private static void merge(int[] arr, int left, int mid, int right) {
//		int[] temp = new int[right-left]; // 병합하면서 저장할 임시 배열
		int l = left; // 왼쪽 배열의 index
		int r = mid; // 오른쪽 배열의 index
		int index = left; // 병합한 배열의 index
		
		// 양쪽에 모두 원소가 남은 경우
		while(l < mid && r < right) {
			if(arr[l] < arr[r]) {
				temp[index++] = arr[l++];
			}else {
				temp[index++] = arr[r++];
			}
		}
		
		// 왼쪽만 원소가 남은 경우
		System.arraycopy(arr, l, temp, index, mid-l);
		// 오른쪽만 원소가 남은 경우
		System.arraycopy(arr, r, temp, index, right-r);
		//병합된 temp를 원본 arr에 복사하기
		System.arraycopy(temp, left, arr, left, right-left);
	}

	public static void main(String[] args) {
		int[] arr = {69, 10, 30, 2, 16, 8, 31, 22};
		temp = new int[arr.length];
		mergeSort(arr, 0, arr.length); // 원본배열을 직접 변경
		System.out.println(Arrays.toString(arr));
		
	}//end main

}//end class
