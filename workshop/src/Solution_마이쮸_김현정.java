import java.util.Arrays;
import java.util.Scanner;

public class Solution_마이쮸_김현정 {

	public static void main(String[] args) {
		int[] q = new int[100];// 사람이 들어갈 큐,(사람 번호 저장)
		int[] myZZu = new int[15]; // 1인당 받을 마이쮸 갯수
		int front = -1;
		int rear = -1;
		int myZZuIndex = -1; 

		int totalMyZZu = 20;
		Scanner sc = new Scanner(System.in);
		while (totalMyZZu > 0) {
			//엔터를 칠때마다
			if(sc.nextLine().equals("")) {
				if (front != rear) {
					int tmp = q[(++front)];
					printInfo(rear, front, myZZu[q[(front)]], totalMyZZu);
					myZZu[q[front]] += 1;
					q[(++rear)] = tmp;
					printInfo(rear, front, 0, totalMyZZu);
				}
				
				q[(++rear)] = (++myZZuIndex);
				myZZu[myZZuIndex] += 1;
				
				printInfo(rear, front, 0, totalMyZZu);
				totalMyZZu -= myZZu[q[(front + 1)]];
			}

			if (totalMyZZu <= 0) {
				System.out.println("마지막" + (q[(front + 1)] + 1));
			}
		}
	}//end of main
	
	public static void printInfo(int rear, int front, int su, int totalMyZZu ) {
		System.out.println("큐에 있는 사람 수:"+(rear-front));
		System.out.println("현재 일인당 나눠주는 사탕의 수:"+su);
		System.out.println("현재까지 나눠준 사탕의 수:"+(20-totalMyZZu));
	}
}//end of class
