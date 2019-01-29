package com.movie;

public class Movie {
	String title;
	String director;
	int grade;
	String genre;
	String summary;
	
	
	public Movie() {
		this("쿵푸팬더2", "여인영", 0);
	}

	public Movie(String title, String director, int grade) {
		this(title, director, grade, "모험", "그분들이 돌아오셨다! 그토록 원하던 용의 전사가 되어 "
				+ "무적의 5인방과 함께 평화의 계곡을 지키게 된 포 ");
	}
	

	public Movie(String title, String director, int grade, String genre, String summary) {
		this.title = title;
		this.director = director;
		this.grade = grade;
		this.genre = genre;
		this.summary = summary;
	}

	void movieInfo() {
		System.out.println("* 제목:" + title + "\t감독:" + director 
				+ "\t등급:" + grade + "\t장르:" + genre 
				+ "\n줄거리:" + summary);
	}
}	
