import java.util.Scanner;

public class Solution11 {
	static char[][] map;
	static int total=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] answer = new int[size];
		
		int cnt=0;
		while(cnt<testCase) {
			map = new char[size][size];
			for(int i=0; i<size; i++) {
				Scanner sc2 = new Scanner(System.in);
				String temp = sc2.nextLine();
				for(int j=0; j<size; j++) {
					map[i][j] = temp.charAt(j);
				}
			}
			search();
			answer[cnt] = total;
			total=0;
			cnt++;
		}
		
		for(int i=0; i<answer.length; i++) {
			System.out.println("#"+i+" "+answer[i]);
		}
		
		
	}// end of main

	public static void search() {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j]=='A') {
					right(i,j);
				}else if(map[i][j]=='B') {
					right(i,j);
					left(i,j);
				}else if(map[i][j]=='C') {
					right(i,j);
					left(i,j);
					up(i, j);
					down(i, j);
				}
			}
		}
		
	}//end of search()
	
	public static void right(int x, int y) {
		for(int i=y; i<map.length; i++) {
			if(i==map.length-1 || map[x][i+1]!='S') {
				break;
			}
			if(map[x][i]=='S') {
//				System.out.println("1");
				total++;
			}
		}
	}//end of right()
	
	public static void left(int x, int y) {
		for(int i=y; i>=0; i--) {
			if(i==0 || map[x][i-1]!='S') {
				break;
			}
			if(map[x][i]=='S') {
//				System.out.println("2");
				total++;
			}
		}
	}//end of left()
	
	public static void up(int x, int y) {
		for(int i=x; i>=0; i--) {
			if(i==0 || map[i-1][y]!='S') {
				break;
			}
			if(map[i][y]=='S') {
//				System.out.println("3");
				total++;
			}
		}
	}
	
	public static void down(int x, int y) {
		for(int i=x; i<map.length; i++) {
			if(i==map.length-1 || map[i+1][y]!='S') {
				break;
			}
			if(map[i][y]=='S') {
//				System.out.println("4");
				total++;
			}
		}
	}

}// end of class
