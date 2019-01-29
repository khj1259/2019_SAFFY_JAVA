import java.util.ArrayList;

public class SubsetSum {
	public static void main(String[] args) {
		//바이너리 카운팅
		int[] arr = {-7, -3, -2, 5, 8};
		for (int i = 0; i < (1 << arr.length); i++) {
			ArrayList<Integer> subset = new ArrayList<>();
			int sum = 0 ;
			for (int j = 0; j < arr.length; j++) {
				if((i & (1 << j)) != 0) { 
					subset.add(arr[j]);
					sum += arr[j];
				}
			}
			if(sum == 0 && !subset.isEmpty()) {
					System.out.println(subset);
			}
		}
		
	}//end of main
}//end of class
