package com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class CharacterStreamTest {
	
	public static void main(String[] args) throws Exception{
		//character stream : 한 글자의 정보를 2byte에 담아서 전송
		
		//임시파일 생성
		File f = File.createTempFile("sample", ".txt");
//		System.out.println(f);
		
		//19~28: 파일에 쓰기(내용 저장)
		FileWriter fw = new FileWriter(f); // fw : node stream(목적지에 직접 연결되어 쓰기 작업 수행)
		BufferedWriter bw = new BufferedWriter(fw);// filter stream. buffer 기능이 있는 가공 stream
		
		bw.write("안녕하세요");
		bw.newLine();//줄바꿈
		bw.write("빨리 집에 가고 싶다");
		bw.newLine();
		
		bw.close();
		fw.close();
		
		//31~close: 파일에서 읽어오기
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		//InputStreamReader : InputStream 타입의 스트림을 Reader 타입의 스트림으로 변환시켜줌(byte stream -> char stream)
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		
		for(String str; (str = br.readLine()) != null;) {
			System.out.println(str);
		}
		br.close();
		fr.close();
	}
}
