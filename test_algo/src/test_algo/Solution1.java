package test_algo;

import java.util.Scanner;

public class Solution1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //testCase
		int testCase = 0;
		
		while(testCase < T) {
			String bit = sc.next();
			String[] bitArr = bit.split("");
			String[] origin = new String[bit.length()];
			for(int i=0; i<origin.length; i++) {
				origin[i] = "0";
			}
			
			int answer=0;
			for(int i=0; i<origin.length; i++) {
				if(origin[i].equals(bitArr[i])) {
					continue;
				}else {
					if(bitArr[i].equals("1")) {
						answer++;
						for(int j=i; j<origin.length; j++) {
							origin[j] = "1";
						}
					}else if(bitArr[i].equals("0")){
						answer++;
						for(int j=i; j<origin.length; j++) {
							origin[j] = "0";
						}
					}
					if(bitArr.toString().equals(origin.toString())) {
						break;
					}
				}
			}
			testCase++;
			System.out.println("#"+testCase+" "+answer);
		}//end of testCase
		
	}//end of main
}//end of class
