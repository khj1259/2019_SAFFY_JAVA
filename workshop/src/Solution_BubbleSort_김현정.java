/**
 * 버블 정렬
 */
public class Solution_BubbleSort_김현정 {
	public static void main(String[] args) {
		int[] data = {9,67,34,2,5,1,10,48,73,30};
		
		for(int j=0; j<data.length-1; j++) {
			for(int i=0; i<data.length-1; i++) {
				if(data[i] > data[i+1]) {
					int tmp = data[i];
					data[i] = data[i+1];
					data[i+1] = tmp;
				}
			}
		}
		
		//정렬 결과를 확인하기 위한 코드
		for(int i : data) {
			System.out.print(i+" ");
		}
		
	}//end of main
}//end of class
