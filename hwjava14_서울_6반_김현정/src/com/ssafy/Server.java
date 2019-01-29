package com.ssafy;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

//서버 클래스
public class Server extends Thread{
	public ServerSocket svrSocket = null;
	private Socket socket = null;
	private int port = 8888;
	
	public InputStream is = null;
	private ObjectInputStream ois = null;
	
	public Server() {
		connect();
	}
	
	@Override
	public void run() {
		while(true){
			try {
				ArrayList<VoHuman> phoneBook = (ArrayList<VoHuman>) ois.readObject();
				for (VoHuman voHuman : phoneBook) {
					System.out.println(voHuman.toString());
				}
			} catch (EOFException e) {
				try {
					ois.close();
					is.close();
					socket.close();
					svrSocket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			} 
		}
	}//end of run()
	
	public void connect(){
		try {
			//server 소켓 생성
			svrSocket = new ServerSocket(port);
			System.out.println("waiting client...");
			
			//accept
			socket = svrSocket.accept();
			System.out.println("connect!!");
			
			//io stream 생성
			is = socket.getInputStream();
			ois = new ObjectInputStream(is);
			
			//thread start();
			this.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Server svr = new Server();
	}//end of main
	
	
}//end of class
