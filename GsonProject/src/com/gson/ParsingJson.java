package com.gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ParsingJson {

	public static void main(String[] args) throws FileNotFoundException {
		//school.json을 읽어와서 parsing
		//1. school.json 읽어오기(BufferedReader br)
		//2. JsonParser 생성 후 parsing --> JsonObject
		//3. 교육지원청코드, 학구명, 시도교육청명, 교육지원청명
		
		FileReader fr = new FileReader("json/school.json");
		BufferedReader br = new BufferedReader(fr);
	
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(br).getAsJsonObject();
		
		JsonArray arr = obj.getAsJsonArray("records");
		for (int i = 0; i < arr.size(); i++) {
			JsonObject obj2 = arr.get(i).getAsJsonObject();
			String s = obj2.get("교육지원청코드").getAsString();
			String s2 = obj2.get("학구명").getAsString();
			String s3 = obj2.get("시도교육청명").getAsString();
			String s4 = obj2.get("교육지원청명").getAsString();
			System.out.println(s+", "+s2+", "+s3+", "+s4);
		}
	}//main
}//class
