package com.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GUITest {
	public static void main(String[] args) {
		Frame f = new Frame("창 이름");	// 윈도우 창 생성 - 독립적인 (컴포넌트)컨테이너 : 레이아웃매니저
		f.setBounds(700, 300, 300, 400);
//		f.setSize(300, 200);		// 창의 크기 지정
//		f.setLocation(500, 600);	// 창의 위치 지정
		
		f.setLayout(new BorderLayout());  // 레이아웃 매니저
//		new FlowLayout();	//위쪽줄부터 좌->우로 배치후 우측끝에 자리가 부족하면 아래줄로
//		new BorderLayout();	//동서남북 센터 로 배치
//		new CardLayout();	//0,0위치를 기준으로 한자리에 덮어씀
		
		Button b = new Button("한글");
//		b.setSize(100, 200); // 레이아웃 매니저를 사용하면, 의미없음
//		b.setLocation(50, 50);
		
		f.add(b, BorderLayout.CENTER);
//		f.add(new Button("버튼1"), BorderLayout.NORTH);
//		f.add(new Button("버튼2"), BorderLayout.SOUTH);
//		f.add(new Button("버튼3"), BorderLayout.WEST);
//		f.add(new Button("버튼4"), BorderLayout.EAST);
//		f.add(new Button("버튼5"));
//		f.add(new Button("버튼6"));
		
		Panel p = new Panel(); //여러개의 레이아웃 매니저로 혼합해서 사용할 때 필요
		p.setLayout(new BorderLayout());
		p.add(new Button("Send"), BorderLayout.NORTH);
		p.add(new Button("Exit"), BorderLayout.CENTER);
		
		f.add(p, BorderLayout.EAST);
		
		f.setVisible(true);		// 화면에 보이기
		
		// 이벤트 처리
		// 소스, 어떤 동작에 대한, 처리할내용
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// 버튼을 클릭 했을 때 호출되는 콜백 메서드
				String str = b.getLabel();
				System.out.println(str);
				b.setLabel("한글");
			}
		});
		
		f.addWindowListener(new WindowAdapter() { // 필요한 메서드만 오버라이딩 할 수 있도록 Adapter를 사용할 수 있다
			public void windowClosing(WindowEvent e) {
				f.setVisible(false);// 화면에서만 안보이게 함
			} // 닫기 버튼을 눌렀을때
		});
//		f.addWindowListener(new WindowListener() {
//			public void windowOpened(WindowEvent e) {} // 창이 열렸을 때 호출되는 콜백 메서드
//			
//			public void windowIconified(WindowEvent e) {} // 최소화 되었을 때
//			
//			public void windowDeiconified(WindowEvent e) {} // 최소화 되었던 것이 원래창으로 뜰때
//			
//			public void windowDeactivated(WindowEvent e) {} // 비활성화 되었을때
//			
//			public void windowClosing(WindowEvent e) {
//				f.setVisible(false);// 화면에서만 안보이게 함
//				f.dispose(); // 창의 객체를 메모리에서 제거
//				System.exit(0); // 프로그램을 종료
//			} // 닫기 버튼을 눌렀을때
//			
//			public void windowClosed(WindowEvent e) {} // 닫은 뒤에
//			
//			public void windowActivated(WindowEvent e) {} // 활성화 되었을 때
//		});
	}//end of main
}//end of class
