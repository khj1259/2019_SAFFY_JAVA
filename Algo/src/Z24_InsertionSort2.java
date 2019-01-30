import java.util.ArrayList;
import java.util.Random;

/**
 * 삽입정렬 - list 사용
 */
public class Z24_InsertionSort2 {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
//		int[] arr = {4, 1, 7, 0, 5, 6, 8, 2, 9, 3};
		int[] arr = new int[60000];
		Random ran = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ran.nextInt(arr.length);
		}
		
//		LinkedList<Integer> ll = new LinkedList<Integer>(); //2190ms - 3000개
		ArrayList<Integer> ll = new ArrayList<Integer>();	//16ms - 3000개, 2170ms - 60000개
		for (int i = 0; i < arr.length; i++) { // 삽입할 대상
			int index;
			for (index = 0; index < i; index++) {
				if(arr[i] < ll.get(index)) {
					break;
				}
			}
			ll.add(index, arr[i]); // 찾은 위치에 삽입할 원소를 넣기
		}
		
		System.out.println(ll);
		System.out.println(System.currentTimeMillis() - time + "ms");
	}//end main
}//end class
