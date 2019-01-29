import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * +, * 계산기
 * 12 + 5 * 2 + 3 + 4 * 2
 */
public class Z19_Cal {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] stack = new int[30];
		int top = -1;
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		stack[++top] = Integer.parseInt(st.nextToken()); // 첫번째 피연산자를 숫자로 변환해서 스택에 저장
		while(st.hasMoreTokens()) {
			char op = st.nextToken().charAt(0); // 연산자
			int num = Integer.parseInt(st.nextToken()); // 피연산자
			if(op == '+') {
				stack[++top] = num;
			}else { // '*'
				int pre = stack[top];
				stack[top] = pre * num; //덮어쓰기
			}
		}
		System.out.println(Arrays.toString(stack));
		
		int sum = 0;
		for(int i=0; i <= top; i++) {
			sum += stack[i];
		}
		System.out.println(sum);
		
	}// end of main
}// end of class
