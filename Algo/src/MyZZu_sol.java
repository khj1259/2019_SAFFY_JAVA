public class MyZZu_sol {
	public MyZZu_sol() {
	}

	public static void main(String[] args) {
		int[] q = new int[100];
		int[] myZZu = new int[15];
		int front = -1;
		int rear = -1;
		int myZZuIndex = -1;

		int totalMyZZu = 20;

		while (totalMyZZu > 0) {
			if (front != rear) {
				int tmp = q[(++front)];
				myZZu[q[front]] += 1;
				q[(++rear)] = tmp;
			}

			q[(++rear)] = (++myZZuIndex);
			myZZu[myZZuIndex] += 1;

			totalMyZZu -= myZZu[q[(front + 1)]];

			if (totalMyZZu <= 0) {
				System.out.println("마지막" + (q[(front + 1)] + 1));
			}
		}
		System.out.println(java.util.Arrays.toString(myZZu));
	}
}
