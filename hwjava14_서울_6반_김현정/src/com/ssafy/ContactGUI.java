package com.ssafy;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContactGUI implements ActionListener {
	JFrame f;
	JButton insertb, deleteb, updateb, searchb, clearb, exitb, uploadb;
	JList li;
	JLabel status;
	JTextField nametf, phonetf, addresstf;

	PhoneBookMgrImpl mgr = new PhoneBookMgrImpl();

	public ContactGUI() {
		makeGUI();

	}

	private void makeGUI() {
		f = new JFrame("Phone Book");
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				mgr.close();
				System.exit(0);
			}
		});

		JLabel custl = new JLabel("Phone Book", JLabel.CENTER);
		status = new JLabel("상태메시지 표시줄",JLabel.CENTER);
		JLabel namel = new JLabel("이  름", JLabel.CENTER);
		JLabel phonel = new JLabel("핸드폰", JLabel.CENTER);
		JLabel addressl = new JLabel("주  소", JLabel.CENTER);
		insertb = new JButton("INSERT");
		deleteb = new JButton("DELETE");
		updateb = new JButton("UPDATE");
		searchb = new JButton("SEARCH");
		clearb = new JButton("CLEAR");
		exitb = new JButton("EXIT");
		uploadb = new JButton("UPLOAD");
		// 버튼에 리스너 달기
		insertb.addActionListener(this);
		deleteb.addActionListener(this);
		updateb.addActionListener(this);
		searchb.addActionListener(this);
		clearb.addActionListener(this);
		exitb.addActionListener(this);
		uploadb.addActionListener(this);

		li = new JList();
		nametf = new JTextField();
		phonetf = new JTextField();
		addresstf = new JTextField();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p2n = new JPanel();
		JPanel p2c = new JPanel();
		JPanel p2s = new JPanel();
		ArrayList<VoHuman> all = mgr.search();
		li.setListData(all.toArray());

		f.setLayout(new GridLayout(2, 1, 5, 5));
		p1.setLayout(new BorderLayout());
		p2.setLayout(new BorderLayout());

		p1.add(custl, BorderLayout.NORTH);
		p1.add(li);
		p1.add(status, BorderLayout.SOUTH);

		p2n.add(insertb);
		p2n.add(deleteb);
		p2n.add(updateb);
		p2n.add(searchb);

		p2c.setLayout(new GridLayout(3, 2, 5, 7));
		p2c.add(namel);
		p2c.add(nametf);
		p2c.add(phonel);
		p2c.add(phonetf);
		p2c.add(addressl);
		p2c.add(addresstf);

		p2s.add(uploadb);
		p2s.add(clearb);
		p2s.add(exitb);

		p2.add(p2n, "North");
		p2.add(p2c);
		p2.add(p2s, "South");

		f.add(p1);
		f.add(p2);

		f.setSize(350, 350);
		f.setVisible(true);

	}

	// 각 버튼에 대한 액션리스너
	@Override
	public void actionPerformed(ActionEvent e) {
		String b = e.getActionCommand();

		if (b.equals("INSERT")) {
			String name = nametf.getText();
			String phone = phonetf.getText();
			String address = addresstf.getText();
			VoHuman h = new VoHuman(name, phone, address);
			int result;
			try {
				mgr.insert(h);
				li.removeAll();
				ArrayList<VoHuman> all = mgr.search();
				li.setListData(all.toArray());
				status.setText("저장이 완료되었습니다");
			} catch (ExisedException e1) {
				status.setText("이미 존재하는 이름입니다");
			}
			
			nametf.setText("");
			phonetf.setText("");
			addresstf.setText("");

		} else if (b.equals("DELETE")) {
			String name = nametf.getText();
			try {
				mgr.delete(name);
				li.removeAll();
				ArrayList<VoHuman> all = mgr.search();
				li.setListData(all.toArray());
				status.setText("삭제가 완료되었습니다");
			} catch (NotFoundException e1) {
				status.setText("일치하는 이름이 없습니다");
			}
			nametf.setText("");
			phonetf.setText("");
			addresstf.setText("");

		} else if (b.equals("UPDATE")) {
			String name = nametf.getText();
			String phone = phonetf.getText();
			try {
				mgr.update(name, phone);
				li.removeAll();
				ArrayList<VoHuman> all = mgr.search();
				li.setListData(all.toArray());
				status.setText("수정이 완료되었습니다");
			} catch (NotFoundException e1) {
				status.setText("일치하는 이름이 없습니다");
			}
			nametf.setText("");
			phonetf.setText("");
			addresstf.setText("");

		} else if (b.equals("SEARCH")) {
			String name = nametf.getText();
			if (name.equals("")) { // 아무것도 입력하지 않고 search 하면 전체 검색
				li.removeAll();
				ArrayList<VoHuman> all = mgr.search();
				li.setListData(all.toArray());
				status.setText("전체 검색이 완료되었습니다");
			} else {
				VoHuman result;
				try {
					result = mgr.searchName(name);
					li.removeAll();
					DefaultListModel model = new DefaultListModel<>();
					model.addElement(result.toString());
					li.setModel(model);
					status.setText("검색이 완료되었습니다");
				} catch (NotFoundException e1) {
					status.setText("일치하는 이름이 없습니다");
				}
			}
			nametf.setText("");
			phonetf.setText("");
			addresstf.setText("");

		} else if (b.equals("CLEAR")) {
			nametf.setText(" ");
			nametf.setText("");
			phonetf.setText(" ");
			phonetf.setText("");
			addresstf.setText(" ");
			addresstf.setText("");
			status.setText("");

		} else if (b.equals("EXIT")) {
			mgr.close();
			System.exit(0);

		} else if (b.equals("UPLOAD")) {
			mgr.upload(mgr.search());
			status.setText("서버로 업로드");
		}

	}

}
