package wsjava14_서울_6반_김현정;

import java.util.List;

public class FoodMain {
	
	public static void main(String[] args) throws Exception {
		FoodDAOImpl dao = new FoodDAOImpl();
		
		System.out.println("식품명 검색 : 육개장큰사발면");
		FoodVo re1 = dao.searchName("육개장큰사발면");
		System.out.println(re1.toString());
		System.out.println("=======================================================");
		
		System.out.println("제조사 검색 : 농심");
		List<FoodVo> re2 = dao.searchMaker("농심");
		for (FoodVo foodVo : re2) {
			System.out.println(foodVo.toString());
		}
		System.out.println("=======================================================");
		
		System.out.println("원재료 검색 : 감자전분");
		List<FoodVo> re3 = dao.searchMaterial("감자전분");
		for (FoodVo foodVo : re3) {
			System.out.println(foodVo.toString());
		}
		System.out.println("=======================================================");
		
		System.out.println("식품명 정렬");
		List<FoodVo> re4 = dao.sortName();
		for (FoodVo foodVo : re4) {
			System.out.println(foodVo.toString());
		}
		System.out.println("=======================================================");
		
		System.out.println("제조사 정렬");
		List<FoodVo> re5 = dao.sortMaker();
		for (FoodVo foodVo : re5) {
			System.out.println(foodVo.toString());
		}
		
	}//end main
}//end class
