package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import models.LoR;

public class Data {
	//The list of cached data
	public LoR list;
	//The path of data file
	private String path;
	
	public Data(String path,LoR list) {
		this.path = path;
		this.list = list;
	}
	
	//read from the data file
	public String read(){
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(path));
			list = (LoR)ois.readObject();
		}catch(ClassNotFoundException e ) {
			e.printStackTrace();
		}catch(IOException e ) {
			e.printStackTrace();
		}finally {
			try {
				if(ois != null) {
					ois.close();
				}
			}catch(IOException e ) {
				e.printStackTrace();
			}
		}
		//System.out.println(list.print());
		return list.print();
	}
	//write in data file
	public void write() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(path));
			oos.writeObject(list);
			oos.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(oos!= null) {
				try {
					oos.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
