package com.ssafy;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ContactGUI implements ActionListener {
	Frame f;
	Button insertb, deleteb, updateb, searchb, clearb, exitb, uploadb;
	List li;

	TextField nametf, phonetf, addresstf;

	PhoneBookMgrImpl mgr = new PhoneBookMgrImpl();

	public ContactGUI() {
		makeGUI();

	}

	private void makeGUI() {
		f = new Frame("Phone Book");
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				mgr.close();
				System.exit(0);
			}
		});

		Label custl = new Label("Phone Book", Label.CENTER);
		Label namel = new Label("이  름", Label.CENTER);
		Label phonel = new Label("핸드폰", Label.CENTER);
		Label addressl = new Label("주  소", Label.CENTER);
		insertb = new Button("INSERT");
		deleteb = new Button("DELETE");
		updateb = new Button("UPDATE");
		searchb = new Button("SEARCH");
		clearb = new Button("CLEAR");
		exitb = new Button("EXIT");
		uploadb = new Button("UPLOAD");
		// 버튼에 리스너 달기
		insertb.addActionListener(this);
		deleteb.addActionListener(this);
		updateb.addActionListener(this);
		searchb.addActionListener(this);
		clearb.addActionListener(this);
		exitb.addActionListener(this);
		uploadb.addActionListener(this);
		
		li = new List();
		nametf = new TextField();
		phonetf = new TextField();
		addresstf = new TextField();
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p2n = new Panel();
		Panel p2c = new Panel();
		Panel p2s = new Panel();
		ArrayList<VoHuman> all = mgr.search();
		for (VoHuman voHuman : all) {
			li.add(voHuman.toString());
		}

		f.setLayout(new GridLayout(2, 1, 5, 5));
		p1.setLayout(new BorderLayout());
		p2.setLayout(new BorderLayout());

		p1.add(custl, BorderLayout.NORTH);
		p1.add(li);

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
			int result = mgr.insert(h);
			if (result == 0) {
				li.add(name + "이 이미 존재함");
			} else {
				li.clear();
				ArrayList<VoHuman> all = mgr.search();
				for (VoHuman voHuman : all) {
					li.add(voHuman.toString());
				}
			}
			nametf.setText("");
			phonetf.setText("");
			addresstf.setText("");

		} else if (b.equals("DELETE")) {
			String name = nametf.getText();
			int result = mgr.delete(name);
			if (result == 0) {
				li.add(name + "이 존재하지 않음");
			} else {
				li.clear();
				ArrayList<VoHuman> all = mgr.search();
				for (VoHuman voHuman : all) {
					li.add(voHuman.toString());
				}
			}
			nametf.setText("");
			phonetf.setText("");
			addresstf.setText("");

		} else if (b.equals("UPDATE")) {
			String name = nametf.getText();
			String phone = phonetf.getText();
			int result = mgr.update(name, phone);
			if (result == 0) {
				li.add(name + "이 존재하지 않음");
			} else {
				li.clear();
				ArrayList<VoHuman> all = mgr.search();
				for (VoHuman voHuman : all) {
					li.add(voHuman.toString());
				}
			}
			nametf.setText("");
			phonetf.setText("");
			addresstf.setText("");

		} else if (b.equals("SEARCH")) {
			String name = nametf.getText();
			if(name.equals("")){ // 아무것도 입력하지 않고 search 하면 전체 검색
				li.clear();
				ArrayList<VoHuman> all = mgr.search();
				for (VoHuman voHuman : all) {
					li.add(voHuman.toString());
				}
			}else{
				VoHuman result = mgr.searchName(name);
				if (result == null) {
					li.clear();
					li.add(name + "이 존재하지 않음");
				} else {
					li.clear();
					li.add(result.toString());
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

		} else if (b.equals("EXIT")) {
			mgr.close();
			System.exit(0);

		} else if (b.equals("UPLOAD")) {
			mgr.upload(mgr.search());
		}

	}

}
