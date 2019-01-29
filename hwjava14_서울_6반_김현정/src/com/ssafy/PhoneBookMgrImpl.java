package com.ssafy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class PhoneBookMgrImpl implements IPhoneBookMgr{
	private ArrayList<VoHuman> list;
	Socket socket;
	private String ip = "localhost";
	private int port = 8888;
	private OutputStream os;
	private ObjectOutputStream oos;
	
	public PhoneBookMgrImpl() {
		try {
			//소켓 생성
			socket = new Socket(ip, port);
			
			//io stream 생성
			os = socket.getOutputStream();
			oos = new ObjectOutputStream(os);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		list = new ArrayList<VoHuman>();
		open();
	}
	
	//전체 검색
	@Override
	public ArrayList<VoHuman> search() {
		return list;
	}
	
	//저장
	@Override
	public void insert(VoHuman h) throws ExisedException {
		for (VoHuman voHuman : list) {
			if(voHuman.getName().equals(h.getName())){
				throw new ExisedException(); 
			}
		}
		list.add(h);
	}

	//검색
	@Override
	public VoHuman searchName(String name) throws NotFoundException {
		boolean flag = false;
		for (VoHuman voHuman : list) {
			if(voHuman.getName().equals(name)){
				flag = true;
				return voHuman;
			}
		}
		if(!flag) {throw new NotFoundException ();}
		return null;
	}

	//수정
	@Override
	public void update(String name, String phone) throws NotFoundException {
		boolean flag = false;
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getName().equals(name)){
				list.get(i).setPhone(phone);
				flag = true;
			}
		}
		if(!flag) throw new NotFoundException ();
	}

	//삭제
	@Override
	public void delete(String name) throws NotFoundException {
		boolean flag = false;
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getName().equals(name)){
				list.remove(i);
				flag = true;
			}
		}
		if(!flag) throw new NotFoundException ();
	}

	//업로드 - 서버로 전송
	@Override
	public void upload(ArrayList<VoHuman> phoneBook) {
		try {
			oos.writeObject(list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//종료시 파일에 저장
	@Override
	public void close() {
		try {
			FileOutputStream fos = new FileOutputStream("PhoneBook.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
			fos.close();
			os.close();
			socket.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//시작시 파일로부터 읽어옴
	@Override
	public void open() {
		try {
			FileInputStream fis = new FileInputStream("PhoneBook.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			list =  (ArrayList<VoHuman>) ois.readObject();

			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}



}
