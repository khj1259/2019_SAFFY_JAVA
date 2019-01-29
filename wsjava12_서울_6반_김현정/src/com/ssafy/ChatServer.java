package com.ssafy;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class ChatServer {
	public ServerSocket svrSocket = null;
	private Socket socket = null;
	private ArrayList<User> users = new ArrayList<>();
	private int port = 8888;
	
	public InputStream inputStream = null;
	public OutputStream outputStream = null;
	private ObjectOutputStream oos = null;
	private ObjectInputStream ois = null;

	public ChatServer() {
		go();
	}
	
	//클라이언트와 연결
	public void go() {
			try {
				// ServerSocket 생성 
				svrSocket = new ServerSocket(port);
				System.out.println("waiting client...\n");
				
				while(true) {
					// accept();
					socket = svrSocket.accept();
					System.out.println("접속자 들어옴");
					// io stream
					inputStream = socket.getInputStream();
					ois = new ObjectInputStream(inputStream);
					outputStream = socket.getOutputStream();
					oos = new ObjectOutputStream(outputStream);
					//접속자를 저장
					users.add(new User(socket, ois, oos));
					// thread 생성
					ChatServerThread sth = new ChatServerThread(ois);
					sth.start();
				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
	}//end go()

	//받은 메시지를 클라이언트 전체에 뿌려줌
	public void broadcast(String msg, ObjectInputStream ois) {
		for (User user : users) {
			if(user.getOis().equals(ois)) {
				continue;
			}
			try {
				user.getOos().writeObject(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}//end broadcast

	// 접속자가 나갔을 때, users 배열에서 삭제
	private void removeClient(ObjectInputStream ois2) {
		for (User user : users) {
			if(user.getOis().equals(ois2)) {
				users.remove(user);
				break;
			}
		}
		System.out.println("남아있는 접속자 수 : "+users.size());

	}

	//클라이언트의 메시지를 기다려서 읽어들이는 스레드
	class ChatServerThread extends Thread {
		private ObjectInputStream ois;
		
		public ChatServerThread(ObjectInputStream ois) {
			this.ois = ois;
		}
		
		@Override
		public void run() {
				try {
					while(true) {
						
						String msg = ois.readObject().toString();
						broadcast(msg, ois);
					}
				} catch (SocketException e) {
					System.out.println("접속자 나감 삭제");
					removeClient(this.ois);
				} catch (EOFException e) {
					System.out.println("접속자 나감 삭제");
					removeClient(this.ois);
				}catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
		}
	}//end of ChatServerThread
	
	
	public static void main(String[] args) {
		ChatServer svr = new ChatServer();
	}// end of main
	
	
}// end of class
