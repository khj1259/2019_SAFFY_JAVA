package com.ssafy;

public class MovieMgr {
	private Movie[] movies = new Movie[100];
	private int index;
	
	public void add(Movie m) {
		movies[index] = m;
		index++;
	}
	
	public Movie[] search() {
		return movies;
	}
	
	public Movie[] search(String title) {
		Movie[] arr = new Movie[100];
		int idx = 0;
		for(int i=0; i<movies.length; i++) {
			if(movies[i] != null && movies[i].getTitle().contains(title)) {
				arr[idx] = movies[i];
				idx++;
			}
		}
		return arr;
	}
	
	public Movie[] searchDirector(String name) {
		Movie[] arr = new Movie[100];
		int idx = 0;
		for(int i=0; i<movies.length; i++) {
			if(movies[i] != null && movies[i].getDirector().equals(name)) {
				arr[idx] = movies[i];
				idx++;
			}
		}
		return arr;
	}
	
	public Movie[] searchGenre(String genre) {
		Movie[] arr = new Movie[100];
		int idx = 0;
		for(int i=0; i<movies.length; i++) {
			if(movies[i] != null && movies[i].getGenre().equals(genre)) {
				arr[idx] = movies[i];
				idx++;
			}
		}
		return arr;
	}
	
	public void delete(String title) {
		for(int i=0; i<movies.length; i++) {
			if(movies[i] != null && movies[i].getTitle().equals(title)) {
				movies[i] = null;
				System.out.println("삭제되었습니다");
			}
		}
		
		for(int i=0; i<movies.length-1; i++) {
			if(movies[i] == null && movies[i+1] != null) {
				movies[i] = movies[i+1];
				movies[i+1] = null;
			}
		}
	}
	
	public int getSize() {
		int size = 0;
		for(int i=0; i<movies.length; i++) {
			if(movies[i] != null) {
				size++;
			}
		}
		return size;
	}
	
}
