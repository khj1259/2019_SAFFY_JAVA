package com.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//1.클래스 선언시에 listener implements 표시
//ActionListener : 버튼 클릭 감시
public class SwingTest2 extends MouseAdapter implements ActionListener {
	
	//JTextArea, JList, JTable 는 JScrollPane 위에 올려야 됨
	//field
	JFrame f; // 창
	JButton ok, cancel; // 버튼
	JLabel la; // 글자
	JTextArea ta; // 여러줄 입력칸
	JTextField tf; // 한줄 입력칸
	JList list; // 리스트
	
	public SwingTest2() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		//화면 만들기 작업
		f = new JFrame("swing test");
		f.setLayout(new BorderLayout());//layout manager 지정
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창 닫기 버튼 클릭시 프로그램 종료
		ok = new JButton("ok");
		cancel = new JButton("cancel");
		
		//2.사건 발생 대상에 리스너 등록
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
		la = new JLabel("Swing Test", JLabel.CENTER);//화면에서의 글자
		Font font = new Font("맑은고딕", Font.BOLD, 50);
		la.setFont(font);
		la.setForeground(Color.PINK);
		
		ta = new JTextArea(5, 30);
		//JScrollPane : 스크롤바가 있는 pane
		JScrollPane pane = new JScrollPane(ta);//JScrollPane 위에 ta를 올림
		
		tf = new JTextField(30);
		String[] season = {"spring", "summer", "fall", "winter"};
		list = new JList<>(season);
		list.setVisibleRowCount(3);
		JScrollPane pane2 = new JScrollPane(list);
		list.addMouseListener(this);
		
		JPanel panel = new JPanel(new FlowLayout());//JFrame 보다 작은 컨테이너(내부에 다른 화면 구성요소를 담을 수 있음)
		panel.add(ok);
		panel.add(cancel);
		
		Container c = f.getContentPane();
		c.add(la, "North");
		c.add(panel, "South");
//		c.add(cancel);
		c.add(pane2, "Center");
//		c.add(tf);
//		c.add(pane2);
		
		f.setSize(500, 500);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingTest2();
	}

	//ActionListener가 가지고 있는 추상 메서드
	//3.사건이 발생했을 때 처리해야 할 작업 내용을 가지고 있는 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource(); // Source : 사건이 발생한 대상
		if(o == ok) {
			System.out.println("press me!");
		}else {
			System.out.println("dont't press me!");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		String s = (String) list.getSelectedValue();
//		System.out.println(s);
		System.out.println(list.getSelectedValue());
	}


}
