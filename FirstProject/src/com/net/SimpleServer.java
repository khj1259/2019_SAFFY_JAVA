package com.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.basic.Car;

public class SimpleServer {
	
	public static void main(String[] args) throws IOException {
		/* 1. ServerSocket(port) 생성
		 * 2. Server.accept() : 클라이언트가 접속해 오기를 기다렸다가 받는 메소드
		 * 3. Socket 객체로 I/O 스트림 생성
		 * 4. 스트림으로 통신
		 * 5. close(): 마무리
		*/
		
		ServerSocket server = null;
		Socket s1 = null;
		String sendString = "hello world!\n";
		OutputStream s1out = null;
		DataOutputStream dos = null;
		InputStream s1in = null;
		DataInputStream dis = null;
		
		try {
			server = new ServerSocket(6666);// 1.
			System.out.println("클라이언트를 기다리는 중...");
			
			s1 = server.accept();// 클라이언트 기다림. block이 되는 특징(접속될때까지 멈춤)
			System.out.println("클라이언트 접속!");
			
			s1out = s1.getOutputStream();// 출력용 스트림 얻어냄
//			ObjectOutputStream oos = new ObjectOutputStream(s1out);//객체 전송 스트림
//			oos.writeObject();
			
			dos = new DataOutputStream(s1out);// filter-사용하지 않아도 됨
			dos.writeUTF(sendString);//한글이 안깨짐, write는 일단 보내고 나면 밑의 코드 실행
			
			s1in = s1.getInputStream();
			dis = new DataInputStream(s1in);
			String message = dis.readUTF();//상대방이 보낼때까지 block이 됨
			System.out.println(message);
			
			
			dis.close();
			dos.close();
			s1in.close();
			s1out.close();
			
			s1.close();
			server.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
	}
}
