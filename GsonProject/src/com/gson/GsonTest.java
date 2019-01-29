package com.gson;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GsonTest {

	// 1. java object --> Json string
	public static void toJson() {
		Person p = new Person(123, "kim", "tokyo");
		
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create(); // builder를 사용해서 Gson 객체를 얻어냄 (설정작업을 할때 사용)
		
//		Gson gson = new Gson(); // Gson객체 직접 만들기
		String str = gson.toJson(p);
		System.out.println(str);
	}
	
	// 2. json string --> java object
	public static void fromJson() {
		String json = "{'num':'500', 'name':'harry', 'address':'london'}";
		Gson gson = new Gson();
		Person p = gson.fromJson(json, Person.class);
		System.out.println(p);
	}

	// 3. JsonObject --> json string
	public static void makeJson() {
		Gson gson = new Gson();
		JsonObject obj = new JsonObject();
		obj.addProperty("num", 900);
		obj.addProperty("nanme", "june");
		obj.addProperty("address", "Paris");
		
		String json = gson.toJson(obj);
		System.out.println(json);
	}
	
	// 4. json parsing
	public static void parseJson() {
		String json = "{'num':123, 'name':'jully', 'address':'seattle'}"; //parsing 할 데이터
		JsonParser parser = new JsonParser();	//파서 생성
		JsonObject obj = parser.parse(json).getAsJsonObject();	//파싱 후 JsonObject타입으로 결과 받음
		
		int num = obj.get("num").getAsInt();
		String name = obj.get("name").getAsString();
		String address = obj.get("address").getAsString();
		System.out.println(num+":"+name+":"+address);
	}
	
	public static void parseJsonArray() {
		String str1 = "{'client':'localhost', 'servers':['10.0.0.11','127.0.0.100','34.56.78.90','256.67.881.78']}";
		String str2 = "{'winners':['queen','king','prince','eugine','princess']}";
		String str3 = "['red','blue','yellow','green']";
		
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(str1).getAsJsonObject();
		JsonArray arr = obj.getAsJsonArray("servers");
		Gson gson = new Gson();
		ArrayList list = gson.fromJson(arr, ArrayList.class);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
		////////////////////////////////////////////////////////////
		JsonObject obj2 = parser.parse(str2).getAsJsonObject();
		JsonArray arr2 = obj2.getAsJsonArray("winners");
		ArrayList list2 = gson.fromJson(arr2, ArrayList.class);
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}
		System.out.println();
		////////////////////////////////////////////////////////////////
		JsonArray arr3 = parser.parse(str3).getAsJsonArray();
		ArrayList list3 = gson.fromJson(arr3, ArrayList.class);
		for (int i = 0; i < list3.size(); i++) {
			System.out.println(list3.get(i));
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		toJson();
		fromJson();
		makeJson();
		parseJson();
		parseJsonArray();
	}// main
}// class
