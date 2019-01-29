import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Solution_5432_쇠막대기자르기_김현정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine()); // 테스트 케이스
		
		for(int i = 0; i < T; i++) {
			String s = sc.nextLine(); // 괄호 입력 받기
			Stack<Integer> st = new Stack<>(); 
			ArrayList<Integer> point = new ArrayList<>(); //레이저 포인트를 저장할 배열
			int count = 0; // 막대기 갯수
			
			for(int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == '(') {
					st.push(j); // 스택에 인덱스를 저장
				}else if(s.charAt(j)==')') {
					if(s.charAt(j-1)=='(') { //레이저 점
						st.pop();
						point.add(j);
					}else {					//막대기 끝
						int start = st.pop();
						int a = Collections.binarySearch(point, start);
						int b = Collections.binarySearch(point, j);
						count += a-b+1;
					}
				}
			}
			System.out.println("#"+(i+1)+" "+count);
		}// end of testCase
		
	}// end of main
}// end of class
