
public class Z12_String {
	public static void main(String[] args) {
		String s = "abc"; // char 배열로 3칸짜리 생성
		System.out.println(s + "xyz");
		
		StringBuilder sb = new StringBuilder("abc"); // 단일쓰레드
		StringBuffer sb2; // 멀티쓰레드 synchronized
	}
}
