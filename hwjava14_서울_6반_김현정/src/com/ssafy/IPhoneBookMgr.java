package com.ssafy;

import java.util.ArrayList;

public interface IPhoneBookMgr {
	
	//저장
	void insert (VoHuman h) throws ExisedException;
	//전체 검색
	ArrayList<VoHuman> search();
	//이름 검색
	VoHuman searchName(String name) throws NotFoundException; 
	//수정
	void update(String name, String phone) throws NotFoundException;
	//삭제
	void delete(String name) throws NotFoundException;
	//업로드
	void upload(ArrayList<VoHuman> phoneBook);
	//종료시에 데이터를 파일에 저장
	void close();
	//시작시에 파일로부터 데이터를 읽어옴
	void open();
	
}
