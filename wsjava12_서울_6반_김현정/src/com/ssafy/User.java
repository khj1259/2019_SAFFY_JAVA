package com.ssafy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class User {
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	

	public User(Socket socket, ObjectInputStream ois, ObjectOutputStream oos) {
		this.socket = socket;
		this.ois = ois;
		this.oos = oos;
	}


	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public ObjectInputStream getOis() {
		return ois;
	}

	public void setOis(ObjectInputStream ois) {
		this.ois = ois;
	}

	public ObjectOutputStream getOos() {
		return oos;
	}

	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}

	
}
