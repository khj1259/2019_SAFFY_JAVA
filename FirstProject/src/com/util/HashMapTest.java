package com.util;

import java.util.HashMap;
import java.util.Set;

// Map : (key, value)의 쌍으로 저자되는 구조
// key는 중복 되면 안됨 (덮어씀)
public class HashMapTest {
	
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("num", "123");
		map.put("name", "jane");
		map.put("address", "seoul");
		map.put("name", "bill");
		
		String name = map.get("name");
		String address = map.get("address");
		System.out.println(name +":"+address);
		System.out.println(map);
		
		Set<String> keys = map.keySet(); // map안에 들어있는 key만 추출함
		for(String key : keys) {
			String value = map.get(key); // key를 기준으로 value를 알아냄
			System.out.println(key +":"+ value);
		}
	}
	
}
