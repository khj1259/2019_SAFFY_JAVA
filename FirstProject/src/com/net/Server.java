package com.net;
import java.io.*;
import java.net.*;

public class Server{

  public ServerSocket svrSocket = null;
  public Socket socket = null;
  public InputStream inputStream = null;
  public OutputStream outputStream = null;
  public DataInputStream dis = null;
  public DataOutputStream dos = null;
  public String message;

  public Server() {
	  try {
		  // ServerSocket 생성 6500
		  svrSocket = new ServerSocket(6500);
		  System.out.println("waiting client...\n");
		 
		  //accept();
		  socket = svrSocket.accept();

		  //io stream
		  inputStream = socket.getInputStream();
		  dis = new DataInputStream(inputStream);
		  outputStream = socket.getOutputStream();
		  dos = new DataOutputStream(outputStream);

	  }catch( Exception e ) {
		  System.out.println(e); }
  }

  public void readSocket(){
	  try {   
		  message = dis.readUTF();
		  System.out.println(message );		

    }catch( UnknownHostException e) {
		System.out.println(e);

    }catch( IOException e ) {
		System.out.println(e);
		try{
			dis.close();
			dos.close();
			socket.close();
			svrSocket.close(); //*****
		}catch(Exception a){ }
		System.exit(0);// 프로그램 강제 종료
	}
  }

  public void writeSocket(){
    try {
      dos.writeUTF(message + "\n");
    }catch( UnknownHostException e) {
		System.out.println(e);

    }catch( IOException e ) {
		System.out.println(e);		
    }
  }

  public static void main(String args[]) {
    Server svr = new Server();
    for(;;){
      svr.readSocket();
      svr.writeSocket();
	  }
  }
}




