import java.io.IOException;
import java.util.Scanner;

public class Solution_1224_SW문제해결기본6일차_계산기3_김현정 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		for(int i=1; i<=10; i++) {
			char[] stackOp = new char[100]; // 연산자를 저장할 스택
			int top = -1;
			
			sc.nextLine(); // 테스트케이스 길이 받기
			String[] str = sc.nextLine().split("");
			String change = ""; //후위표기식으로 바뀐 문자열
			for(int j=0; j<str.length; j++) {
				char c = str[j].charAt(0); // 문자열의 첫글자를 짤라옴
				switch (c) {
				case '(': // 무조건 스택에 저장해라, 우선순위 3
					stackOp[++top] = c;
					break;
				case '*': // 우선순위 2
					//스택을 확인해서 나보다 우선순위가 낮으면 스택에 넣기, 높거나 같으면 빼기 pop
					while(top >= 0 && (stackOp[top] == '*')) {
						change += stackOp[top--];
					}
					stackOp[++top] = c;// 스택 위에 내 연산자를 쌓기
					break;
				
				case '+': // 우선순위 1
					//스택을 확인해서 나보다 우선순위가 낮으면 스택에 넣기, 높거나 같으면 빼기 pop
					while(top >= 0 && (stackOp[top] == '*' || stackOp[top] == '+')) {
						change += stackOp[top--];
					}
					stackOp[++top] = c;// 스택 위에 내 연산자를 쌓기
					break;
				case ')': // 스택에 넣지는 않음, 스택에서 ( 나올때까지 pop한다
					while(top >= 0 && stackOp[top] != '(') {
						change += stackOp[top--];
					}
					if(top >= 0 && stackOp[top] == '(') { // (는 버리기
						top--;
					}
					break;
				default: // 숫자
					change += c;
					break;
				}
			}
			// 토큰 분석작업이 다 끝난 뒤에 스택에 연산자가 남아있으면, 남은 연산자를 pop 출력
			while(top > -1) {
				change += stackOp[top--];
			}
//			System.out.println(change);
			
			int[] stackNum = new int[100]; // 연산자를 저장할 스택
			int top1 = -1;
			
			String[] str1 = change.split("");
			//후위표기식 계산하기
			for(int j=0; j<str1.length; j++) {
				char c = str1[j].charAt(0); // 문자열의 첫글자를 짤라옴
				int num1, num2;
				switch (c) {
				case '*':
					num2 = stackNum[top1--];
					num1 = stackNum[top1--];
					stackNum[++top1] = num1 * num2;
					break;
				case '+':
					num2 = stackNum[top1--];
					num1 = stackNum[top1--];
					stackNum[++top1] = num1 + num2;
					break;
				default: // 숫자
					stackNum[++top1] = Integer.parseInt(str1[j]);
					break;
				}
			}
			
			System.out.println("#"+i+" "+stackNum[top1--]);
			
		}//end of testCase
		
	}//end of main
}//end of class
