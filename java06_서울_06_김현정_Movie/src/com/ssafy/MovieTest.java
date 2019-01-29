package com.ssafy;

import java.util.Scanner;

public class MovieTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		MovieMgr mgr = new MovieMgr();
		
		while(true) {
			System.out.println("<<< 영화 관리 프로그램 >>>");
			System.out.println("1. 영화 정보 입력");
			System.out.println("2. 영화 정보 전체 검색");
			System.out.println("3. 영화명 검색");
			System.out.println("4. 영화 장르별 검색");
			System.out.println("5. 영화 정보 삭제");
			System.out.println("0. 종료");
			System.out.println("원하는 번호를 선택하세요.");
			
			int menu = sc.nextInt();
			Movie[] arr = null;
			switch (menu) {
			case 1:
				System.out.print("제목 : ");
				String title = sc2.nextLine();
				System.out.print("감독 : ");
				String director = sc2.nextLine();
				System.out.print("등급 : ");
				int grade = sc.nextInt();
				System.out.print("장르 : ");
				String genre = sc2.nextLine();
				System.out.print("줄거리 : ");
				String summary = sc2.nextLine();
				Movie m = new Movie(title, director, grade, genre, summary);
				mgr.add(m);
				break;
			case 2:
				arr = mgr.search();
				System.out.println("제목\t감독\t등급\t장르\t줄거리");
				for(int i=0; i<arr.length; i++) {
					if(arr[i] != null) {
						System.out.println(arr[i].getTitle()+"\t"+arr[i].getDirector()
								+"\t"+arr[i].getGrade()+"\t"+arr[i].getGenre()+"\t"+arr[i].getSummary());
					}
				}
				break;
			case 3:
				System.out.print("검색할 영화 명 : ");
				arr = mgr.search(sc2.nextLine());
				System.out.println("제목\t감독\t등급\t장르\t줄거리");
				for(int i=0; i<arr.length; i++) {
					if(arr[i] != null) {
						System.out.println(arr[i].getTitle()+"\t"+arr[i].getDirector()
								+"\t"+arr[i].getGrade()+"\t"+arr[i].getGenre()+"\t"+arr[i].getSummary());
					}
				}
				break;
			case 4:
				System.out.print("검색할 장르 : ");
				arr = mgr.searchGenre(sc2.nextLine());
				System.out.println("제목\t감독\t등급\t장르\t줄거리");
				for(int i=0; i<arr.length; i++) {
					if(arr[i] != null) {
						System.out.println(arr[i].getTitle()+"\t"+arr[i].getDirector()
								+"\t"+arr[i].getGrade()+"\t"+arr[i].getGenre()+"\t"+arr[i].getSummary());
					}
				}
				break;
			case 5:
				System.out.print("삭제할 영화의 제목을 입력하세요 : ");
				mgr.delete(sc2.nextLine());
				break;
			case 0:
				
				break;
			default:
				System.out.println("잘못 입력 하셨습니다");
				break;
			}
			if(menu == 0) break;
		}
		
	}//end of main
}//end of class
