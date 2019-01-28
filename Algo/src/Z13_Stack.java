import java.util.Stack;

/**
 * Stack
 */
public class Z13_Stack {
	static int[] stack = new int[5];
	static int top = -1; //꼭대기 데이터의 위치를 가리킬 index
	
	public static void main(String[] args) {
		push(1); // 스택에 값을 넣기
		push(2); // 스택에 값을 넣기
		push(3); // 스택에 값을 넣기
		push(4); // 스택에 값을 넣기
		push(5); // 스택에 값을 넣기
		push(6); // 스택에 값을 넣기
		
		System.out.println(pop()); // 꼭대기 데이터를 삭제 후 리턴받음
		System.out.println(pop()); // 꼭대기 데이터를 삭제 후 리턴받음
		System.out.println(pop()); // 꼭대기 데이터를 삭제 후 리턴받음
		System.out.println(pop()); // 꼭대기 데이터를 삭제 후 리턴받음
		System.out.println(pop()); // 꼭대기 데이터를 삭제 후 리턴받음
		System.out.println(stack[top--]); // 꼭대기 데이터를 삭제 후 리턴받음
		
		Stack<Integer> s = new Stack<Integer>();
		s.push(3);
//		s.push(3.14);
//		s.push(true);
//		s.push("김현정");
		System.out.println(s.pop());
		s.isEmpty();
		
		
		
	}//end of main
	
	/** 스택의 데이터 삭제 후 리턴 , 데이터가 남아있는지 확인*/
	public static int pop() {
		if(isEmpth()) { // 데이터가 남아있지 않은지?
			System.out.println("underflow Error");
			return -1;
		}
		int data = stack[top];
		top--;
		return data;
	}
	
	/** 스택이 비어있는지 확인*/
	public static boolean isEmpth() {
		return top == -1;
	}

	/** 스택 에 데이터 넣기, 공간이 남았는지 확인 */
	public static void push(int data) {
		if(isFull()) { // 남은 공간이 없음
			System.out.println("overflow Error");
			return;
		}
		top++;
		stack[top] = data;
	}
	
	/** 스택이 꽉 찼는지 확인 */
	public static boolean isFull() {
		return top == stack.length-1;
	}
	
	
	
}//end of class
