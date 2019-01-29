package wsjava14_서울_6반_김현정;

import java.util.List;

public interface FoodDAO {

	//검색 - 식품명
	FoodVo searchName(String name);
	//검색 - 제조사
	List<FoodVo> searchMaker(String maker);
	//검색 - 원재료
	List<FoodVo> searchMaterial(String material);
	//정렬 - 식품명
	List<FoodVo> sortName();
	//정렬 - 제조사
	List<FoodVo> sortMaker();
}
