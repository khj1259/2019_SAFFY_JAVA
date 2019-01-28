import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Z11_Source {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
//		sc.nextLine();	// 한줄을 통째로 받아옴
//		sc.next();		
//		sc.nextInt();	
		
		//입력받을 때 시간 절약
//		Scanner -> BufferedReader
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br.readLine();	// 한줄을 통째로 받아옴
		
		//출력할 때 시간 절약
//		System.out.println(); ->
//		String ss = "";
//		ss +="asdfg\n";
//		ss +="qweqwdqw\n";
//		System.out.println(ss);
		
		//문자열 쪼개기
		String str = "사자 호랑이 귤 사과 바나나 수박";
		String[] srr = str.split(" "); // 구분자로 쪼갬
		System.out.println(Arrays.toString(srr));
		
		//더 빠른 방법
		StringTokenizer st = new StringTokenizer(str, " ");
		while(st.hasMoreTokens()) {
			System.out.print(st.nextToken()+" ");
		}
		
		
		
	}//end of main
}//end of class
