package com.news;
//parsing한 결과를 저장할 vo
public class News {
	private String title;
	private String pubDate;
	
	public News() {
		// TODO Auto-generated constructor stub
	}

	public News(String title, String pubDate) {
		this.title = title;
		this.pubDate = pubDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	@Override
	public String toString() {
		return title + " - " + pubDate;
	}
	
	
}
