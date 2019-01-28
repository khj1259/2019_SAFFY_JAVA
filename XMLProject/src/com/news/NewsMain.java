package com.news;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class NewsMain {
	JFrame f;
	JButton b;
	JList li;
	NewsDAO dao; // -> xml문서 읽어와서 parsing -> parsing한 결과를 ArrayList에 저장
					// NewsVo -> parsing 결과 1건 저장 (vo에 담아서 ArrayList에 저장)

	public NewsMain() throws Exception {
		dao = new NewsDAO();
		createGUI();
		addEvent();
	}

	private void addEvent() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
	}

	protected void showList() {
		// dao한테서 파싱한 결과가 들어있는 ArrayList 받아오기
		try {
			List<News> data = dao.getNewsData();
			
			// 받아온 ArrayList로 화면(JList)에 뿌리기
			li.setListData(data.toArray());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private void createGUI() {
		f = new JFrame("News Info");
		b = new JButton("call News");

		li = new JList();
		JScrollPane pane = new JScrollPane(li);
		Container c = f.getContentPane();

		c.add(b, "North");
		c.add(pane, "Center");

		f.setSize(1200, 1200);
		f.setVisible(true);
	}

	public static void main(String[] args) throws Exception {
		new NewsMain();
	}

}
