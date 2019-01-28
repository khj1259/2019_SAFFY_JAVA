package com.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {
	public static void main(String[] args) {
		//byte stream : 한글자의 정보를 1byte에 담아서 전송
		FileInputStream fis;
		FileOutputStream fos;
		
		//args[0]:원본파일
		//args[1]:복사본파일
		
		try {
			fis = new FileInputStream(args[0]);
			fos = new FileOutputStream(args[1]);
			
			for (int i; (i = fis.read()) != -1; ) {
				System.out.println(i);
				fos.write(i);//i에 해당하는 글자로 바꿔서 출력하는 메소드
			}
			
			//stream close;
			fis.close();
			fos.close();
			
			System.out.println("file copied..");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
