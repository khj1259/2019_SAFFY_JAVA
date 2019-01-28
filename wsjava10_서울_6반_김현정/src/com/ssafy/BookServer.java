package com.ssafy;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class BookServer {
	public ServerSocket svrSocket = null;
	public Socket socket = null;
	public InputStream inputStream = null;
	public ObjectInputStream ois = null;
	
	public BookServer() {
		try {
			// ServerSocket 생성 7777
			svrSocket = new ServerSocket(7777);
			System.out.println("waiting client...\n");
			
			//accept();
			socket = svrSocket.accept();
			System.out.println("클라이언트 접속!");
			
			//io stream
			inputStream = socket.getInputStream();
			ois = new ObjectInputStream(inputStream);
			
			ArrayList<Book> blist = (ArrayList<Book>) ois.readObject();
			for (Book book : blist) {
				System.out.println(book.toString());
			}
			
			ois.close();
			inputStream.close();
			socket.close();
			svrSocket.close();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		BookServer svr = new BookServer();
	}
}
