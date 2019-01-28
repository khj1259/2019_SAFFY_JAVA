/**
 * 제곱 재귀함수
 */
public class Z22_Power {
    public static int power(int base, int ex) {
        if(ex == 0) { //종료 파트
            return 1;
        } else if ( ex == 1) {
            return base;
        } else if (ex % 2 == 0) {
            int n = power(base, ex/2);
            return n * n;
        } else {
            int n = power(base, (ex-1)/2);
            return n * n * base;
        }
    }
    
    public static void main(String[] args) {
//        2^10을 출력
        int n = power(2,10);
        System.out.println(n);
	}//end of main
    
}//end of class
