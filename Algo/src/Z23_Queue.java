import java.io.PrintStream;


public class Z23_Queue
{
  public Z23_Queue() {}
  
  public static int[] q = new int[5];
  public static int front = -1;
  public static int rear = -1;
  
  public static boolean isFull() {
    return rear == q.length - 1;
  }
  
  public static boolean isEmpty() {
    return front == rear;
  }
  
  public static int deQueue()
  {
    if (isEmpty()) {
      System.out.println("Queue underflow error");
      return -1;
    }
    return q[(++front)];
  }
  
  public static void enQueue(int data)
  {
    if (isFull()) {
      System.out.println("Queue overflow error");
    } else {
      q[(++rear)] = data;
    }
  }
  



  public static void main(String[] args)
  {
    q[(++rear)] = 1;
    q[(++rear)] = 2;
    q[(++rear)] = 3;
    System.out.println(q[(++front)]);
    System.out.println(q[(++front)]);
    System.out.println(q[(++front)]);
    












    enQueue(1);
  }
}
