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

public class BookMgrImpl implements IBookMgr{
	private ArrayList<Book> list;
	
	OutputStream outputStream = null;
	ObjectOutputStream oos = null;
	Socket socket = null;
	
	//내부 클래스:server로 Book 정보 전송
	class BookClient extends Thread{
		//thread가 작업할 내용이 있는 메소드->server로 Book 정보 전송
		public void run() {
			try {
				//Socket 생성
				socket = new Socket("localhost", 7777);
				//Stream 생성(filter 포함: oos)
				outputStream = socket.getOutputStream();
				oos = new ObjectOutputStream(outputStream);
				
				oos.writeObject(list);//Book 리스트 전체를 넘김
				
				oos.close();
				outputStream.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}//BookClient class end
	
	public BookMgrImpl() {
		list = new ArrayList<>();
		open();
	}
	
	//도서 최초 입력 기능
	@Override
	public void add(Book b) {
		list.add(b);
	}

	//전체 도서 정보 출력 기능
	@Override
	public ArrayList<Book> search() {
		return list;
	}

	//도서가 판매되어 재고 수량을 빼는 기능
	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		boolean flag = false;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getIsbn().equals(isbn)) {
				int reset = list.get(i).getQuantity() - quantity;
				if(reset >= 0) {
					list.get(i).setQuantity(reset);
				}else { // 예외 발생
					throw new QuantityException();
				}
				flag = true;
			}
		}
		if(!flag) throw new ISBNNotFoundException();
	}

	//도서가 구매되어 재고 수량을 더하는 기능
	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		boolean flag = false;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getIsbn().equals(isbn)) {
				int reset = list.get(i).getQuantity() + quantity;
				list.get(i).setQuantity(reset);
				flag = true;
			}
		}
		if(!flag) throw new ISBNNotFoundException();
	}

	//재고 도서들의 수량*금액을 하여 총 재고 금액을 구하여 리턴
	@Override
	public int getTotalAmount() {
		int total=0;
		for (Book book : list) {
			total += (book.getPrice()) * (book.getQuantity());
		}
		return total;
	}

	//클래스 생성시에 호출디어 지며, 파일("book.dat")에 저장된 파일을 읽어서 ArayList에 저장
	@Override
	public void open() {
		try {
			FileInputStream fis = new FileInputStream("book.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			list =  (ArrayList<Book>) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	// 프로그램 종료시에 호출되어 지며, ArrayList에 있는 도서 정보를 파일로 저장한다.
	@Override
	public void close() {
		try {
			FileOutputStream fos = new FileOutputStream("book.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//서버로 전송
		send();
	}

	//서버로 도서정보 전송
	@Override
	public void send() {
		//Thread인 BookClient를 실행하여 서버로 도서정보를 전송
		BookClient bc = new BookClient();
		bc.start();
	}
	

}
