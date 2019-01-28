package com.inter;

class Truck{}
interface Boat{}
//IShape 인터페이스를 구현(완성)하는 자식 클래스
//인터페이스를 implements 해도 상속 관계가 성립함
public class ICircle extends Truck implements IShape, Boat{
	int r;
	
	public ICircle(int r) {
		this.r = r;
	}
	
	@Override
	public double getArea() {
		return Math.PI * r * r;
	}

	@Override
	public double getCircum() {
		return 2 * Math.PI * r;
	}

}
