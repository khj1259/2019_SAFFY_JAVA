import java.util.Scanner;
/**
 * 후위표기식 계산하기
 *
 */
public class Z21_Cal3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] stackNum = new int[30]; // 연산자를 저장할 스택
		int top = -1;
		
		String[] str = sc.nextLine().split(" ");
		for(int i=0; i<str.length; i++) {
			char c = str[i].charAt(0); // 문자열의 첫글자를 짤라옴
			int num1, num2;
			switch (c) {
			case '*':
				num2 = stackNum[top--];
				num1 = stackNum[top--];
				stackNum[++top] = num1 * num2;
				break;
			case '/':
				num2 = stackNum[top--];
				num1 = stackNum[top--];
				stackNum[++top] = num1 / num2;
				break;
			case '+':
				num2 = stackNum[top--];
				num1 = stackNum[top--];
				stackNum[++top] = num1 + num2;
				break;
			case '-':
				num2 = stackNum[top--];
				num1 = stackNum[top--];
				stackNum[++top] = num1 - num2;
				break;

			default: // 숫자
				stackNum[++top] = Integer.parseInt(str[i]);
				break;
			}
		}
		
		System.out.println(stackNum[top--]);
	}
}
