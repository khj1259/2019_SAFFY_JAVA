import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 병합정렬1(Merge Sort) - 리스트 사용
 */
public class Z25_MergeSort {
	
	private static List<Integer> merge(List<Integer> left, List<Integer> right) {
		List<Integer> result = new ArrayList<Integer>(left.size() + right.size()); // 내부 배열의 크기를 처음에 지정하기
		int l = 0; // left 리스트의 인덱스
		int r = 0;
		
		//양쪽 리스트의 원소가 모두 있는 경우
		while(l < left.size() && r < right.size()) {
			if(left.get(l) < right.get(r)) { // index 번째의 원소끼리 비교
				result.add(left.get(l++));
			}else {
				result.add(right.get(r++));
			}
		}
		//왼쪽 리스트만 원소가 있는 경우
		while(l < left.size()) {
			result.add(left.get(l++));
		}
		
		//오른쪽 리스트만 원소가 있는 경우
		while(r < right.size()) {
			result.add(right.get(r++));
		}
		return result;
	}
	
	private static List<Integer> mergeSort(List<Integer> ll) { // 리스트를 쪼개기
		if(ll.size() <= 1) {
			return ll;
		} else { // 재귀파트
			int m = ll.size() / 2;
			List<Integer> left = mergeSort(ll.subList(0, m));
			List<Integer> right = mergeSort(ll.subList(m, ll.size()));
			return merge(left, right);
		}
		
	}
	
	public static void main(String[] args) {
		Integer[] arr = {69, 10, 30, 2, 16, 8, 31, 22};
		ArrayList<Integer> ll = new ArrayList<>(Arrays.asList(arr)); // 배열의 원소를 추가하기
		System.out.println(mergeSort(ll));
		
	}//end main

	
}//end class
