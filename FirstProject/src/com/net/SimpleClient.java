package com.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		/* 1. Socket(ip, port) 생성 --> server로 접속해 들어감
		 * 2. Socket 객체로 I/O 스트림 생성
		 * 3. 스트림으로 통신
		 * 4. close(): 마무리
		*/
		
		Socket s1;
		InputStream s1in;
		DataInputStream dis;
		String sendString = "welcome!\n";
		OutputStream s1out;
		DataOutputStream dos;
		
		s1 = new Socket("localhost", 6666); //"127.0.0.1" -> 내 컴퓨터를 가리키는 ip (loop back address) or "localhost"
		s1in = s1.getInputStream();
		dis = new DataInputStream(s1in);
		
		String message = dis.readUTF();//상대방이 보낼때까지 block이 됨
		System.out.println(message);
		
		s1out = s1.getOutputStream();// 출력용 스트림 얻어냄
		dos = new DataOutputStream(s1out);// filter-사용하지 않아도 됨
		dos.writeUTF(sendString);//한글이 안깨짐
		
		dis.close();
		s1in.close();
		
		dos.close();
		s1out.close();
		
		s1.close();
	}
}
