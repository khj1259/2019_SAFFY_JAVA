import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution_1218_SW문제해결기본4일차_괄호짝짓기_김현정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int testCase=1; testCase<=10; testCase++) {
			int size = Integer.parseInt(sc.nextLine());
			String s = sc.nextLine();
			Stack st = new Stack<>();
			boolean flag = false;
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{' || s.charAt(i)=='<') {
					st.push(s.charAt(i));
				}else {
					if(s.charAt(i)==')' && st.peek().equals('(')) {
						st.pop();
					}else if(s.charAt(i)==']' && st.peek().equals('[')) {
						st.pop();
					}else if(s.charAt(i)=='}' && st.peek().equals('{')) {
						st.pop();
					}else if(s.charAt(i)=='>' && st.peek().equals('<')) {
						st.pop();
					}else {
						flag = true;
					}
				}
				
			}
			if(st.empty()) {
				if(flag) {
					System.out.println("#"+testCase+" "+0);
					
				}else {
					System.out.println("#"+testCase+" "+1);
				}
			}else {
				System.out.println("#"+testCase+" "+0);
			}
		}//end of testCase
		
	}//end of main
}//end of class
