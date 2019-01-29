package com.ssafy.news;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NewsMain {

	JFrame f;
	JButton b;
	JList li;
	JTextArea ta;
	NewsDAODOMImpl dao; // -> xml문서 읽어와서 parsing -> parsing한 결과를 ArrayList에 저장
					// NewsVo -> parsing 결과 1건 저장 (vo에 담아서 ArrayList에 저장)

	public NewsMain() throws Exception {
		dao = new NewsDAODOMImpl();
		createGUI();
		addEvent();
		showList();
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
		
		li.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				News n = (News) li.getSelectedValue();
				ta.setText(n.getDesc());
			}
		});
	}

	protected void showList() {
		// dao한테서 파싱한 결과가 들어있는 ArrayList 받아오기
		try {
			List<News> datas = dao.getNewsList("http://rss.etnews.com/Section902.xml");
			li.removeAll();
			// 받아온 ArrayList로 화면(JList)에 뿌리기
			li.setListData(datas.toArray());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private void createGUI() {
		f = new JFrame("News List");
		JPanel p = new JPanel();
		b = new JButton("News List 호출");
		li = new JList();
		ta = new JTextArea("");
		ta.setLineWrap(true);
		p.setLayout(new BorderLayout());
		p.add(b, "North");
		p.add(li);
		f.setLayout(new GridLayout(2,1,5,5));
		f.add(p);
		f.add(ta);

		f.setSize(400, 500);
		f.setVisible(true);
	}

	public static void main(String[] args) throws Exception {
		new NewsMain();
	}//end main

}//end class
