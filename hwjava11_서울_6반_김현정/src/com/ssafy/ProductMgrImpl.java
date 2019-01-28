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

public class ProductMgrImpl implements IProductMgr{
	ArrayList<Product> list;
	
	OutputStream outputStream = null;
	ObjectOutputStream oos = null;
	Socket socket = null;
	//내부 클래스:server로 Book 정보 전송
	class ProductClient extends Thread{
		//thread가 작업할 내용이 있는 메소드->server로 Book 정보 전송
		public void run() {
			try {
				//product.dat 파일에 저장
				FileOutputStream fos = new FileOutputStream("product.dat");
				ObjectOutputStream oos1 = new ObjectOutputStream(fos);
				oos1.writeObject(list);
				
				//Socket 생성
				socket = new Socket("localhost", 7777);
				//Stream 생성(filter 포함: oos)
				outputStream = socket.getOutputStream();
				oos = new ObjectOutputStream(outputStream);
				
				ArrayList<Tv> tvlist = searchTV();
				ArrayList<Refrigerator> reflist  = searchRef();
				oos.writeObject(tvlist);//tv 리스트 전체를 넘김
				oos.writeObject(reflist);//냉장고 리스트 전체를 넘김
				
				oos1.close();
				fos.close();
				oos.close();
				outputStream.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}//BookClient class end
	
	public ProductMgrImpl() {
		list = new ArrayList<>();
		open();
	}
	
	//최초 상품 추가
	@Override
	public void add(Product p) throws DuplicateException {
		for (Product product : list) {
			if(product.getNum().equals(p.getNum())){
				throw new DuplicateException();
			}
		}
		
		list.add(p);
	}

	//전체 검색
	@Override
	public ArrayList<Product> search() {
		return list;
	}

	//상품 번호로 검색
	@Override
	public Product searchNum(String num) throws CodeNotFoundException {
		Product tmp = null;
		boolean flag = false;
		for(Product p : list) {
			if(p.getNum().equals(num)) {
				tmp = p;
				flag = true;
			}
		}
		if(!flag) throw new CodeNotFoundException();
		return tmp;
	}

	@Override
	public ArrayList<Product> searchName(String name) {
		ArrayList<Product> tmp = new ArrayList<>();
		
		for(Product p : list) {
			if(p.getName().equals(name)) {
				tmp.add(p);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Tv> searchTV() {
		ArrayList<Tv> tmp = new ArrayList<>();
		
		for(Product p : list) {
			if(p instanceof Tv) {
				tmp.add((Tv) p);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Refrigerator> searchRef() {
		ArrayList<Refrigerator> tmp = new ArrayList<>();
		
		for(Product p : list) {
			if(p instanceof Refrigerator) {
				tmp.add((Refrigerator) p);
			}
		}
		return tmp;
	}

	@Override
	public ArrayList<Refrigerator> Ref400() throws ProductNotFoundException {
		ArrayList<Refrigerator> tmp = new ArrayList<>();
		boolean flag = false;
		for(Refrigerator b : searchRef()) {
			if( b.getLiter() >= 400) {
				tmp.add(b);
				flag = true;
			}
		}
		if(!flag) throw new ProductNotFoundException();
		return tmp;
	}

	@Override
	public ArrayList<Tv> Tv50() throws ProductNotFoundException {
		ArrayList<Tv> tmp = new ArrayList<>();
		boolean flag = false;
		for(Tv b : searchTV()) {
			if( b.getInch() >= 50) {
				tmp.add(b);
				flag = true;
			}
		}
		if(!flag) throw new ProductNotFoundException();
		return tmp;
	}

	@Override
	public void update(String num, int price) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getNum().equals(num)) {
				list.get(i).setPrice(price);
			}
		}
	}

	@Override
	public void delete(String num) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getNum().equals(num)) {
				list.remove(i);
			}
		}
	}

	@Override
	public int totalPrice() {
		int total=0;
		for(Product p : list) {
			total += p.getPrice();
		}
		return total;
	}

	//파일 (product.dat) 로부터 상품 정보를 읽어오는 기능
	@Override
	public void open() {
		try {
			FileInputStream fis = new FileInputStream("product.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			list =  (ArrayList<Product>) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	//파일(product.dat)에 상품 정보를 저장하는 기능
	@Override
	public void close() {
		send();
	}

	//서버로 정보 전송
	@Override
	public void send() {
		//Thread인 ProductClient를 실행하여 서버로 도서정보를 전송
		ProductClient pc = new ProductClient();
		pc.start();
	}

}
