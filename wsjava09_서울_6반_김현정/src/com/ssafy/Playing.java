package com.ssafy;
//상영정보(스케줄)
public class Playing extends Movie{
	String day;
	String time;
	
	public Playing() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Playing(String title, String director, int grade, String genre, String day, String time) {
		super(title, director, grade, genre);
		this.day = day;
		this.time = time;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Playing [day=" + day + ", time=" + time + ", getTitle()=" + getTitle() + ", getDirector()="
				+ getDirector() + ", getGrade()=" + getGrade() + ", getGenre()=" + getGenre() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
}
