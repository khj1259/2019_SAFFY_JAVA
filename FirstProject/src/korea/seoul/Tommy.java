package korea.seoul;

import com.basic.Circle;

public class Tommy {
	public int age = 36;
	
	public void go() {
		System.out.println("gogogo~~~");
	}
	
	public void test() {
		Customer c = new Customer();
//		c.num = 123;
		
		c.setNum(123);
		System.out.println(c.getNum());
		
		c.setName("kelly");
		System.out.println(c.getName());
		
		Circle cc = new Circle(9);
		System.out.println(cc.getArea());
	}
}
