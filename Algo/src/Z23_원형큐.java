import java.io.PrintStream;



public class Z23_원형큐
{
  public Z23_원형큐() {}
  
  public static int[] q = new int[5];
  public static int front = 0;
  public static int rear = 0;
  
  public static boolean isFull() {
    return (rear + 1) % q.length == front;
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
    
    front += 1;
    if (front == q.length) {
      front = 0;
    }
    return q[front];
  }
  
  public static void enQueue(int data)
  {
    if (isFull()) {
      System.out.println("Queue overflow error");
    } else {
      rear += 1;
      if (rear == q.length) {
        rear = 0;
      }
      

      q[rear] = data;
    }
  }
  










  public static void main(String[] args)
  {
    enQueue(1);
    enQueue(2);
    enQueue(3);
    enQueue(4);
    

    System.out.println(deQueue());
    System.out.println(deQueue());
    System.out.println(deQueue());
    System.out.println(deQueue());
  }
}
