package com.ssafy;

import java.util.ArrayList;

public interface IMovieMgr {
	
	//저장
	void add(Movie m);
	//검색(제목으로 검색, 제목별 소트 검색)
	ArrayList<Movie> searchAll();
	ArrayList<Movie> searchTitle(String title);
	ArrayList<Movie> searchTitleSort();
	//수정(제목을 입력받아서 수정)
	void update(String title, String director, String grade, String genre);
	//삭제
	void delete(String title);
}
