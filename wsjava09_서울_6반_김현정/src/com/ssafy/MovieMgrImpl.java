package com.ssafy;

import java.util.ArrayList;
import java.util.Comparator;

public class MovieMgrImpl implements IMovieMgr, Comparator<Movie>{
	ArrayList<Movie> list;
	
	public MovieMgrImpl() {
		list = new ArrayList<>();
	}
	
	// 영화 정보 저장
	@Override
	public void add(Movie m) {
		list.add(m);
	}
	
	//전체 영화 검색
	@Override
	public ArrayList<Movie> searchAll() {
		return list;
	}
	
	// 영화명으로 검색
	@Override
	public ArrayList<Movie> searchTitle(String title) {
		ArrayList<Movie> tmp = new ArrayList<>();
		for (Movie movie : list) {
			if(movie.getTitle().contains(title)) {
				tmp.add(movie);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Movie> searchTitleSort() {
		ArrayList<Movie> tmp = new ArrayList<>();
		
		return null;
	}

	@Override
	public void update(String title, String director, String grade, String genre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compare(Movie o1, Movie o2) {
		String fir = o1.getTitle();
		String sec = o2.getTitle();
		
		if(fir > sec) {
			
		}
		return 0;
	}

	

}
