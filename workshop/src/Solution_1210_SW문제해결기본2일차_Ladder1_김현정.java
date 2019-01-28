import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1210_SW문제해결기본2일차_Ladder1_김현정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//testCase = 10
            
		for(int i=0; i<10; i++) {
			br.readLine();     
            
            int[][] Ladder = new int[100][100];
            int desX = 0;//도착지점의 열

            //입력받기
            for (int j = 0; j < 100; j++) {
                String s = br.readLine(); 
                for (int k = 0; k < 100; k++) {
                	Ladder[j][k]=s.charAt(k*2)-'0';
                	if(Ladder[j][k]==2) {
                		desX = k;
                	}
                }
            }
			
			//출발지점 찾기(2에서부터 거슬러 올라감)
			int r = Ladder.length-1; //현재 행
			int c = desX;			//현재 열
			while(r!=0) {
				if(c != 99 && Ladder[r][c+1]==1) {//우
					Ladder[r][c] = 0;
					c++;
				}else if(c != 0 && Ladder[r][c-1]==1) {//좌
					Ladder[r][c] = 0;
					c--;
				}else if(Ladder[r-1][c]==1){//상
					r--;
				}
			}
			System.out.println("#"+(i+1)+" "+c);
			
		}//end of testCase
		
	}//end of main
}//end of class
