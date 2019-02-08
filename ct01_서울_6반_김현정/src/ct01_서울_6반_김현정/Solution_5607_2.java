package ct01_서울_6반_김현정;

import java.util.Scanner;

public class Solution_5607_2 {

    
    public static int p = 1234567891; //소수
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for (int t = 1; t <= tc; t++) {
            int n = sc.nextInt(); // 1 <= n <= 1,000,000
            int r = sc.nextInt();
            
            long[] fact = new long[n+1]; //팩토리얼값을 %p 한 값을 저장할 배열
            fact[0] = 1;
            for (int i = 1; i < fact.length; i++) {
                fact[i] = fact[i-1] * i % p;
            }
            
//            long result = fact[n] * fact[n-r]^p-2 * fact[r]^p-2; // nCr한 결과값 구해서 출력
            long result = fact[n] * power(fact[n-r]*fact[r] %p , p-2) % p; // nCr한 결과값 구해서 출력
        
            System.out.println("#"+tc+" "+result);
        }
    }//end of main
    
    public static long power(long base, long ex) { //재귀함수, base ^ ex 제곱승을 리턴하는 함수
    
        if(ex == 0) { //종료파트
            return 1;
        }else if (ex == 1){
            return base;
        }else if (ex % 2 == 0) { //재귀 파트
            long result = power(base, ex/2);
            return result * result % p;
        } else { //재귀파트, 홍수이면
            long result = power(base, ex/2);
            return result * result % p * base % p;
        }
        
    }
}//end of class