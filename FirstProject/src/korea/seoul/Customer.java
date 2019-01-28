package korea.seoul;

public class Customer {
	//field
	int num;
	String name;
	String address;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		if(num>0) {
			this.num = num;
		}else {
			System.out.println("wrong number...");
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
