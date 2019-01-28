import java.util.Scanner;

/**
 * 이진검색 - 반복문, 재귀방법
 */
public class Solution_이진검색_김현정 {
	
	public static void main(String[] args) {
		
		int[] a = {0,1,2,3,4,5,6,7,8,9};
		System.out.print("검색할 숫자를 입력하세요>");
		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt(); // 찾고자 하는 값
		
		//반복문
		int l = 0;	//검색범위의 왼쪽 끝 index
		int r = 9;	//검색범위의 오른쪽 끝 index, m.length-1
		while(l <= r) {
			int mid = (l + r) / 2; //중간 index
			if(key == a[mid]) {
				System.out.println("반복 : 찾음");
				break;
			}else if(key < a[mid]) { // 작은쪽 영역으로 재설정
				//l~m
				r = mid -1; 
			}else { // 큰쪽 영역으로 재설정
				//mid+1 ~ r
				l = mid+1;
			}
		}
		if(l > r) {
			System.out.println("반복 : 찾지못함");
		}
		
		//재귀방법
		 binarySearch(a, key, 0, a.length-1);
		 
	}//end of main
	
	public static void binarySearch(int[] a, int key, int l, int r) {
		if(l > r) {	// 종료파트
			System.out.println("재귀 : 못찾음");
		}else {	//재귀파트
			int mid = (l+r)/2; // 중간 index
			if(key == a[mid]) {
				System.out.println("재귀 : 찾음"+mid);
			}else if(key < a[mid]) { // 작은쪽 영역으로 재설정
				binarySearch(a, key, l, mid-1);
			}else {					// 큰쪽 영역으로 재설정
				binarySearch(a, key, mid+1, r);
			}
		}
	}
}//end of class
