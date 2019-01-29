package com.ssafy.news;

import java.util.List;

public interface INewsDAO {
	
	public default List<News> getNewsList(String url) {
		
		return null;
	}
	
	News search(int index);
}
