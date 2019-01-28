import java.io.IOException;
import java.util.Scanner;
/**
 * 중위표기식 -> 후위표기식으로 변경하여 출력하기
 * 6 + 5 * ( 2 - 8 ) / 2
 */
//	2 + 3 * 4 / 5
//	234*5/+
//	6 + 5 * ( 2 - 8 ) / 2
//	6528-*2/+
public class Z20_Cal2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		char[] stackOp = new char[30]; // 연산자를 저장할 스택
		int top = -1;
		
		String[] str = sc.nextLine().split(" ");
		for(int i=0; i<str.length; i++) {
			char c = str[i].charAt(0); // 문자열의 첫글자를 짤라옴
			switch (c) {
			case '(': // 무조건 스택에 저장해라, 우선순위 3
				stackOp[++top] = c;
				break;
			case '*': // 우선순위 2
			case '/': // 우선순위 2
				//스택을 확인해서 나보다 우선순위가 낮으면 스택에 넣기, 높거나 같으면 빼기 pop
				while(top >= 0 && (stackOp[top] == '*' || stackOp[top] == '/')) {
					System.out.print(stackOp[top]+" ");
					top--;
				}
				stackOp[++top] = c;// 스택 위에 내 연산자를 쌓기
				break;
			
			case '+': // 우선순위 1
			case '-': // 우선순위 1
				//스택을 확인해서 나보다 우선순위가 낮으면 스택에 넣기, 높거나 같으면 빼기 pop
				while(top >= 0 && (stackOp[top] == '*' || stackOp[top] == '/' 
					|| stackOp[top] == '+' || stackOp[top] == '-')) {
					System.out.print(stackOp[top]+" ");
					top--;
				}
				stackOp[++top] = c;// 스택 위에 내 연산자를 쌓기
				break;
			
			case ')': // 스택에 넣지는 않음, 스택에서 ( 나올때까지 pop한다
				while(top >= 0 && stackOp[top] != '(') {
					System.out.print(stackOp[top]+" ");
					top--;
				}
				if(top >= 0 && stackOp[top] == '(') { // (는 버리기
					top--;
				}
				break;
			default: // 숫자
				System.out.print(str[i]+" ");
				break;
			}
		}
		// 토큰 분석작업이 다 끝난 뒤에 스택에 연산자가 남아있으면, 남은 연산자를 pop 출력
		while(top > -1) {
			System.out.print(stackOp[top]);
			top--;
		}
		System.out.println();
		sc.close();
	}//end of main
}//end of class
