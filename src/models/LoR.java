package models;

import java.io.Serializable;

//This class represents a list of class Requirement
public class LoR implements Serializable{
	private static final long serialVersionUID = 4040112464776475983L;
	// The array of class requirement
	private Requirement[] sList;
	//The size, index and length
	private int i, max, it;
	
	public LoR() {
		max = 100;
		sList = new Requirement[max];
		i = 0;
	}
	//Getters and setters
	public int getI() {
		return i;
	}
	
	public Requirement[] getsList() {
		return sList;
	}
	
	//add a item in the list
	public void add(Requirement r) {
		sList[i++] = r;
	}
	//remove a item in the list
	public void remove(Requirement r) {
		int j;
		for(j = 0; j < i; j++) {
			if(sList[j] == r) {
				break;
			}
		}
		i--;
		for(; j<i;j++) {
			sList[j] = sList[j+1];
		}
	}
	//find a item by its name
	public Requirement find(String RequirmentName) {
		for(int j = 0; j < i; j++) {
			if(sList[j].getName().equals(RequirmentName)) {
				return sList[j];
			}
		}
		return null;
	}
	//Count the number of different existing objects by their name
	public String statics() {
		String name = sList[0].getName();
		String text = this.count(name)+" "+sList[0].print();
		for(int j = 1; j < i; j++) {
			if(name.equals(sList[j].getName())) {
				//if its name already exists, don't count
				continue;
			}else {
				name=sList[j].getName();
				text += ", "+this.count(name)+" "+sList[j].print();
			}
		}
		return text;
	}
	//Print all items
	public String print(){
		String text = "";
		for(int j = 0; j < i; j++) {
			text += sList[j].print()+"\n";
		}
		return text;
	}
	//reset the index
	public void reset() {
		it = 0;
	}
	//return the items pointed by the index
	public Requirement next() {
		return (it == i)?null:sList[it++];
	}
	
	//count the number of the requirement by its name
	public int count(String name){
		int num = 0;
		for(int j = 0; j < i; j++) {
			if(sList[j].getName().equals(name)) {
				num++;
			}
		}
		return num;
	}
	
	//check if the list is empty
	public boolean isEmpty() {
		for(int j = 0; j < i; j++) {
			if(sList[j]!= null) {
				return false;
			}
		}
		return true;
	}
	//clear the list
	public void clear() {
		for(int j = 0; j < i; j++) {
			sList[j] = null;
		}
		i = 0;
	}
	

}
