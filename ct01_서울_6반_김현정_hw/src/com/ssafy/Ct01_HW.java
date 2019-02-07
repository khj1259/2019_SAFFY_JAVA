package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ct01_HW {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("마방진 행열의 크기 N :");
		int N = Integer.parseInt(br.readLine().trim());
		int[][] matrix = new int[N][N]; // 마방진
		
		System.out.println("마방진 입력받기 : ");
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++){
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean ck = check(matrix);
		if(!ck){
			System.out.println("마방진이 아닙니다");
		}else{
			int row = 0; // 마방진 한 행의 값
			for(int i=0; i<matrix.length; i++){
				row += matrix[0][i];
			}
			System.out.println("마방진의 한 행의 값 : "+row);
			System.out.println("정사각형 마방진의 총 합 : "+ (row*N));
		}
		
	}//end main

	
	//마방진인가 체크하는 메서드
	private static boolean check(int[][] matrix) {
		boolean ck = true;
		int sum = 0;
		for(int i=0; i<matrix.length; i++){
			sum += matrix[0][i];
		}
		
		int d1 = 0;
		int d2 = 0;
		for(int i=0; i<matrix.length; i++){
			int r = 0;
			int c = 0;
			for(int j=0; j<matrix.length; j++){
				r += matrix[i][j]; // 한개 행
				c += matrix[j][i]; // 한개 열
			}
			if((r != sum) || (c != sum)){
				ck = false;
				break;
			}
			d1 += matrix[i][i];
			d2 += matrix[i][matrix.length-1-i];
			
		}
		if((d1 != sum) || (d2 != sum)){
			ck = false;
		}
		
		return ck;
	}
	
	
}//end class
