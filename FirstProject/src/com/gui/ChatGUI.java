package com.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 채팅화면 만들기
 */
public class ChatGUI {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setBounds(600, 100, 300, 400);
		f.setLayout(new BorderLayout()); // 원래 Frame의 기본 레이아웃 매니저가 BorderLayout() 임
		
		TextArea ta = new TextArea(); // 여러줄의 글자를 입력, 출력하는 컴포넌트
		ta.setEditable(false);
		ta.setFocusable(false);
		f.add(ta, BorderLayout.CENTER);
		
		TextField tf = new TextField(); // 한줄에 글자를 입력, 출력하는 컴포넌트
		f.add(tf, BorderLayout.SOUTH);
		
		Panel p = new Panel(); // 동쪽 영역에 들어갈 묶음
		p.setLayout(new BorderLayout());
		
		Button bSend = new Button("Send");
		Button bExit = new Button("Exit");
		p.add(bSend, BorderLayout.NORTH);
		p.add(bExit, BorderLayout.CENTER);
		
		f.add(p, BorderLayout.EAST);
		
		
		f.setVisible(true); // 보통 가장 마지막에 한다
		
		//////////////////////////////////////////////////
//		Frame의 닫기 버튼 클릭 : 창을 닫기
//		Exit 버튼 클릭 : 창을 닫기
//		Send 버튼 클릭 : TextField에 있는 값을 읽어서, 서버에 전송(TextArea에 값을 작성), TextField의 값을 삭제
//		TextField 엔터키 입력 : TextField에 있는 값을 읽어서, 서버에 전송(TextArea에 값을 작성), TextField의 값을 삭제
		
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {// 텍스트 필드에서 엔터키 입력시 호출되는 콜백 메서드
				String str = tf.getText(); // 문자열 읽어옴
				//서버 전송
				ta.append("\n"+"홍길동 : "+str); // 텍스트 에어리어에 추가
				tf.setText(""); // 글자 지우기
			}
		});
		
		bSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = tf.getText(); // 문자열 읽어옴
				//서버 전송
				ta.append("\n"+"홍길동 : "+str); // 텍스트 에어리어에 추가
				tf.setText(""); // 글자 지우기
			}
		});
		
		bExit.addActionListener(new ActionListener() {
			//버튼이 클릭시 호출되는 콜백 메서드
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { // 창 닫기 버튼 클릭시 실행되는 콜백 메서드
				f.dispose();
			}
		});
		
	} // end of main
} // end of class
