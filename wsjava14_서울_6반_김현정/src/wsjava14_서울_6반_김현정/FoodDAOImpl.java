package wsjava14_서울_6반_김현정;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FoodDAOImpl implements FoodDAO {
	List<FoodVo> list;// 파싱된 결과가 저장되어 있는 리스트
	Document doc;

	public FoodDAOImpl() throws Exception {
		parseXML();
	}// constructor

	// xml문서 파싱
	public void parseXML() throws Exception {
		list = new ArrayList<>();
		// 준비작업
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		doc = parser.parse("xml/foodInfo.xml");

		// xml의 food 데이터 들을 vo객체화 시켜서 리스트에 저장
		NodeList items = doc.getElementsByTagName("food");

		for (int i = 0; i < items.getLength(); i++) {
			FoodVo f = new FoodVo();
			Node item = items.item(i);// food tag 한개

			NodeList childs = item.getChildNodes();// item tag 의 자식들

			for (int j = 0; j < childs.getLength(); j++) {
				Node child = childs.item(j);// 자식 노드중 한개.
				String nodeName = child.getNodeName();// 자식 노드 이름

				if (nodeName.equals("name")) {
					f.setName(child.getLastChild().getNodeValue());
				} else if (nodeName.equals("maker")) {
					f.setMaker(child.getLastChild().getNodeValue());
				} else if (nodeName.equals("material")) {
					f.setMaterial(child.getLastChild().getNodeValue());
				}
			}
			list.add(f);
		}
	}// end parseXML()

	// 검색 - 식품명
	@Override
	public FoodVo searchName(String name) {
		for (FoodVo foodVo : list) {
			if (foodVo.getName().equals(name)) {
				return foodVo;
			}
		}
		return null;
	}// end searchName()

	// 검색 - 제조사
	@Override
	public List<FoodVo> searchMaker(String maker) {
		List<FoodVo> result = new ArrayList<>();
		for (FoodVo foodVo : list) {
			if (foodVo.getMaker().equals(maker)) {
				result.add(foodVo);
			}
		}
		return result;
	}// end searchMaker()

	// 검색 - 원재료
	@Override
	public List<FoodVo> searchMaterial(String material) {
		List<FoodVo> result = new ArrayList<>();
		for (FoodVo foodVo : list) {
			if (foodVo.getMaterial().contains(material)) {
				result.add(foodVo);
			}
		}
		return result;
	}// end searchMaterial()

	// 정렬 - 식품명
	@Override
	public List<FoodVo> sortName() {
		List<FoodVo> result = list;
		Collections.sort(result, new NameCompare());
		return result;
	}

	// 정렬 - 제조사
	@Override
	public List<FoodVo> sortMaker() {
		List<FoodVo> result = list;
		Collections.sort(result, new MakerCompare());
		return result;
	}

/////////////////이름 정렬 기능//////////////////////////
	class NameCompare implements Comparator<FoodVo> {

		public int compare(FoodVo o1, FoodVo o2) {
			return o1.getName().compareTo(o2.getName());
		}

	}
/////////////////제조사 정렬 기능//////////////////////////
	class MakerCompare implements Comparator<FoodVo> {
		
		public int compare(FoodVo o1, FoodVo o2) {
			return o1.getMaker().compareTo(o2.getMaker());
		}
		
	}
}
