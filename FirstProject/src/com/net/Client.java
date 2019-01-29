package com.net;
import java.awt.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;

public class Client implements ActionListener{
	OutputStream outputStream = null;
	InputStream inputStream = null;
	DataOutputStream dos = null;
	DataInputStream dis = null;
	Socket socket = null;
	String msg;

	JFrame f;
	JTextArea ta;
	JTextField tf;
	Container c;

	public Client() {
		makeGUI();//화면 만들기
		connect();
	}

	public void makeGUI() {
		f = new JFrame("My chatting");
		c = f.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(new JLabel("전송할 메세지 : ", JLabel.CENTER),"North");

		ta = new JTextArea(5,30);
		ta.setEditable(false);
		JScrollPane pane = new JScrollPane(ta);

		tf = new JTextField(30);
		tf.addActionListener(this);

		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent w){
				try{
					dis.close();
					dos.close();
					socket.close();
				}catch(Exception a){ }
				System.exit(0);				
			}
		});
		c.add(pane,"Center");
		c.add(tf,"South");
		f.pack();
		f.setVisible(true);
		tf.requestFocus();
	}

	public void connect(){
		try {
			//Socket 생성
			socket = new Socket("localhost", 6500);
			
			//io stream 생성
			outputStream = socket.getOutputStream();
			inputStream = socket.getInputStream();
			dos = new DataOutputStream(outputStream);
			dis = new DataInputStream(inputStream);

		}catch(Exception e) {
			System.out.println(e);
		}
	}

	//사건이 일어날 때 자동 실행되는 메서드
	public void actionPerformed(ActionEvent e) {
		try {
			dos.writeUTF(tf.getText()); 
			ta.append(dis.readUTF());   
			tf.setText("");
		} catch(Exception except) {}
	}

	public static void main(String argv[]) {
		Client o = new Client();
	}
}




