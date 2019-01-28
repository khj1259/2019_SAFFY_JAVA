package com.ssafy;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ProductServer {
	public ServerSocket svrSocket = null;
	public Socket socket = null;
	public InputStream inputStream = null;
	public ObjectInputStream ois = null;
	
	public ProductServer() {
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
			
			ArrayList<Product> Plist = (ArrayList<Product>) ois.readObject();
			for (Product book : Plist) {
				System.out.println(book.toString());
			}
			Plist = (ArrayList<Product>) ois.readObject();
			for (Product book : Plist) {
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
		ProductServer svr = new ProductServer();
	}
}
