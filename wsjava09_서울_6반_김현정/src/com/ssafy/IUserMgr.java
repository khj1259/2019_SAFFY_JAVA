package com.ssafy;

public interface IUserMgr {
	
		//저장
		void add(User u);
		//검색
		User[] searchAll();
		User searchId(String id);
		//수정(id를 입력받아서 수정)
		void update(String id, String name, int age, String pw);
		//삭제
		void delete(String id);
}
