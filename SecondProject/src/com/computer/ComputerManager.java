package com.computer;

//Parts를 상속 받은 자식 클래스 (Monitor, Mouse, MainFrame, KeyBoard)를 관리하는 클래스
public class ComputerManager {
	
	//부품 저장할 배열 선언
	Parts[] p;
	int position;
	final int size;
	
	public ComputerManager(int size) {
		p = new Parts[size];
		this.size = size;
	}
	
	//배열안에 부품 저장
	public void add(Parts part) {
		//배열에 저장 : size check
		if(position < size) {
			p[position++] = part;
			System.out.println("부품추가"+part.getNum());
		}else {
			System.err.println("더이상 저장할 수 없습니다.");
		}
	}
	
	//배열안에 있는 모든 부품 리턴
	public Parts[] allParts() {
		return p;
	}
	
	//부품 검색
	public Parts findPart(int num) {
		Parts pp = null;
		for(Parts part : p) {
			if(part !=null && part.getNum() == num) {
				pp = part;
				break;
			}
		}
		return pp;
	}
	
	//부품 삭제
	public void deletePart(int num) {
		for(int i=0; i<p.length; i++) {
			if(p[i] !=null && p[i].getNum() == num) {
				p[i] = null;
				break;
			}
		}
	}
	
}
