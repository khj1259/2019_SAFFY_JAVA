import java.util.Scanner;
import java.util.Stack;

public class Z13_Stack_Ex02 {
	
	public static void main(String[] args) {
		Stack st = new Stack();
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int result = 0; // 예외처리 체크를 위한 변수
		for(int i = 0; i<s.length(); i++) {
			if(s.charAt(0)==')') {
				result = -1;
				break;
			}else if(s.charAt(i)=='(') {
				st.push(s.charAt(i));
			}else {
				if(st.size()==0) {
					result = -1;
					break;
				}else {
					st.pop();
				}
			}
		}
		
		if(!st.isEmpty() || result == -1) {
			System.out.println("괄호의 짝이 맞지 않음");
		}else {
			System.out.println("괄호의 짝이 맞음");
		}
	}
	
}
