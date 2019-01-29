import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

/**
 * 자바정리 - Collection Framework
 */
public class Z17_자바정리3 {
	public static void main(String[] args) {
//		List 순서유지, 데이터 중복 가능
//			ArrayList, LinkedList
//		Set  순서없음, 데이터 중복 불가
//			HashSet, TreeSet
//		Map  키:값 의 구조로 되어있음
//			HashMap, TreeMap
		
//		Hash 기법을 사용하려면 HashCode(), equals()를 Overriding 해야한다
//		BinarySearchTree 기법을 사용하려면  compareTo(), compare()를 구현해야 한다
		
		HashSet<Girl> hs = new HashSet<Girl>();
		hs.add(new Girl(26,"서민규"));
		hs.add(new Girl(26,"서민규")); // 같은 객체는 저장을 안해줌
		hs.add(new Girl(22,"수지"));
		System.out.println(hs);
		
		HashMap<Girl, Integer> hm = new HashMap<>(); // 키=값
		hm.put(new Girl(22, "류현진"), 100);
		hm.put(new Girl(21, "수지"), 100);
		hm.put(new Girl(26, "서민규"), 80);
		hm.put(new Girl(26, "서민규"), 200); // 같은 키 객체가 추가되면, 값을 업데이트
		System.out.println(hm);
		
//		Map 에서 키 셋 이용해서 순회
		System.out.println("Map 에서 키 셋 이용해서 순회============");
		Set<Girl> ks = hm.keySet();
		for (Girl girl : ks) {		// for each로 순회
			System.out.println(girl);
		}
		Iterator<Girl> iter = ks.iterator();
		while(iter.hasNext()) {		// iterator로 순회
			System.out.println(iter.next()+",");
		}
		System.out.println();
		
		System.out.println("Map 에서 엔트리 셋 이용해서 순회============");
		Set<Entry<Girl, Integer>> es = hm.entrySet();
		for (Entry<Girl, Integer> entry : es) {
			System.out.println(entry.getKey()+" ~ "+entry.getValue()+", ");
		}
		System.out.println();
		Iterator<Entry<Girl, Integer>> ex = es.iterator();
		while(ex.hasNext()) {
			Entry<Girl, Integer> en = ex.next();
			System.out.println(en.getKey()+":"+en.getValue());
		}
		
		System.out.println("======================================");
		//외부의 비교기준이 우선순위가 더 높다
		TreeSet<Cup> ts = new TreeSet<Cup>(new Comparator<Cup>() { // 클래스 외부의 비교기준을 작성
			@Override
			public int compare(Cup o1, Cup o2) {
				return o2.size - o1.size;
			}
		});
		ts.add(new Cup(100, "서민규"));
		ts.add(new Cup(100, "서민규"));
		ts.add(new Cup(70, "수지"));
		System.out.println(ts);
		
		
	}// end of main
}//end of class

class Cup implements Comparable<Cup>{ // 클래스 내부의 비교기준을 작성
	int size;
	String name = "";
	
	public Cup() {
		// TODO Auto-generated constructor stub
	}
	
	public Cup(int size, String name) {
		this.size = size;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return String.format("[%d,%s]", size, name);
	}

	@Override
	public int compareTo(Cup o) {
		// TODO Auto-generated method stub
		return 0;
	} 
	
	
}

class Girl {
	int age; 
	String name = "";
	
	public Girl() {
		// TODO Auto-generated constructor stub
	}

	public Girl(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) { //다형성 polymorphism : 부모의 참조변수에 자식의 객체를 담을수 있는 성질
		if (obj instanceof Girl) {
			Girl g = (Girl) obj;
			return this.age == g.age && this.name.equals(g.name);
		}
		return false;
	}
	
	
	public int hashCode() { // 각 키에 대한 유니크한 hash 값을 리턴하는 함수
		return (age+name).hashCode();
	}
	
	@Override
	public String toString() {
		return String.format("[%d,%s]", age, name);
	}
	
	
}
