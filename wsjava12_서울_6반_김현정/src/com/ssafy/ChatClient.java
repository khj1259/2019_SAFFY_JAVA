package com.ssafy;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ChatClient implements ActionListener{
	private Frame f;
	private TextArea ta;
	private TextField tf;
	private Button bSend;
	private Button bExit;
	private Panel p;
	
	private Socket socket;
	private OutputStream outputStream;
	private InputStream inputStream;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private String ip = "localhost";
	private int port = 8888;
	private String name;
	private ChatClientThread cth;
	
	public ChatClient() {
		createUserName();
		go(ip, port, name);
	}
	
	//사용자 이름을 입력 받는 창 그리기
	public void createUserName() {
		//사용자 이름 입력하는 화면
		Frame f2 = new Frame("사용자 이름 입력");
		f2.setBounds(600, 100, 300, 400);
		Panel p2 = new Panel(new FlowLayout());
		Label label = new Label("사용자 이름 : ");
		TextField tf2 = new TextField(30);
		Button b = new Button("확인");
		p2.add(label);
		p2.add(tf2);
		p2.add(b);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				name = tf2.getText();
				f2.setVisible(false);
				createGUI();
			}
		});
		tf2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				name = tf2.getText();
				f2.setVisible(false);
				createGUI();
			}
		});
		
		f2.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//입출력 스트림, 소켓  close하기
				f2.dispose();
				cth.stop();
				try {
					oos.close();
					ois.close();
					inputStream.close();
					outputStream.close();
					socket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		f2.add(p2);
		f2.setVisible(true);
	}
	
	//채팅창을 그리는 메서드
	public void createGUI() {
		f = new Frame(name);
		f.setBounds(600, 100, 300, 400);
		f.setLayout(new BorderLayout()); // 원래 Frame의 기본 레이아웃 매니저가 BorderLayout() 임

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { // 창 닫기 버튼 클릭시 실행되는 콜백 메서드
				//입출력 스트림, 소켓  close하기
				System.exit(0);
				cth.stop();
				try {
					oos.close();
					ois.close();
					inputStream.close();
					outputStream.close();
					socket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		ta = new TextArea(); // 여러줄의 글자를 입력, 출력하는 컴포넌트
		ta.setEditable(false);
		ta.setFocusable(false);
		f.add(ta, BorderLayout.CENTER);

		tf = new TextField(); // 한줄에 글자를 입력, 출력하는 컴포넌트
		f.add(tf, BorderLayout.SOUTH);
		tf.addActionListener(this);

		p = new Panel(); // 동쪽 영역에 들어갈 묶음
		p.setLayout(new BorderLayout());

		bSend = new Button("Send");
		bExit = new Button("Exit");
		bSend.addActionListener(this);
		bExit.addActionListener(this);
		p.add(bSend, BorderLayout.NORTH);
		p.add(bExit, BorderLayout.CENTER);

		f.add(p, BorderLayout.EAST);

		f.setVisible(true); // 보통 가장 마지막에 한다

	}
	
	//서버 연결
	public void go(String ip, int port, String name) {
		try {
			//Socket 생성
			socket = new Socket(ip, port);
			
			//io stream 생성
			outputStream = socket.getOutputStream();
			inputStream = socket.getInputStream();
			oos = new ObjectOutputStream(outputStream);
			ois = new ObjectInputStream(inputStream);
			//스레드 생성
			cth = new ChatClientThread(ois);
			cth.start();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//엔터, 버튼에 대한 이벤트 리스너
	@Override
	public void actionPerformed(ActionEvent e) {
		String b = e.getActionCommand();
		String c = e.getSource().getClass().getSimpleName();
		if(b.equals("Send") || c.equals("TextField")) {
			
			String str = name+" : "+tf.getText();
			// 서버 전송
			try {
				oos.writeObject(str);
				ta.append("\n" + str ); // 텍스트 에어리어에 추가
				tf.setText(""); // 글자 지우기
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}else if(b.equals("Exit")){
			System.exit(0);
			cth.stop();
			try {
				oos.close();
				ois.close();
				inputStream.close();
				outputStream.close();
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	//서버로부터 오는 메시지를 기다리는 스레드
	class ChatClientThread extends Thread{
		private ObjectInputStream ois;
		
		public ChatClientThread(ObjectInputStream ois) {
			this.ois = ois;
		}

		@Override
		public void run() {
				try {
					while(true) {
						String msg = ois.readObject().toString();
						ta.append("\n" + msg ); // 텍스트 에어리어에 추가
					}
				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
		}
	}//end of ChatClientThread
	
	public static void main(String[] args) {
		ChatClient c = new ChatClient();
	} // end of main

}// end of class
