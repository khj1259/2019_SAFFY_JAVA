import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1228_SW문제해결기본8일차_암호문1_김현정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int testCase = 1; testCase <= 10; testCase++) {
//		첫 번째 줄 : 원본 암호문의 길이 N ( 10 ≤ N ≤ 20 의 정수)
//		두 번째 줄 : 원본 암호문
//		세 번째 줄 : 명령어의 개수 ( 5 ≤ N ≤ 10 의 정수)
//		네 번째 줄 : 명령어
			int N = Integer.parseInt(br.readLine().trim());// 원본 암호문의 길이
			String origin = br.readLine().trim();// 원본 암호문
			StringTokenizer st = new StringTokenizer(origin, " ");
			ArrayList<String> result = new ArrayList<>(); //수정된 암호문이 저장될 배열
			while (st.hasMoreTokens()) {
				result.add(st.nextToken());
			}
			
			int odCt = Integer.parseInt(br.readLine().trim());//명령어의 개수
			String order = br.readLine().trim(); //명령문
			String[] od = order.split("I "); //하나의 명령어
			for (int i = 1; i < od.length; i++) {
				String[] tmp = od[i].split(" ");
				int idx = Integer.parseInt(tmp[0]);//삽입될 인덱스, 1번째는 삽입될 개수
				for(int j=tmp.length-1; j>=2; j--) {//명령어의 마지막부터 인덱스2까지 거꾸로 result 의 삽입될 위치에 삽입하기
					result.add(idx, tmp[j]);
				}
			}
			
			String str="";
			for (int i = 0; i < 10; i++) {
				str += " "+result.get(i);
			}
			
			System.out.println("#"+testCase+str);
		}//end testCase

	}// end main
}// end class
