package models;

import java.io.Serializable;

//This class represents a item , such as a teaching requirement
public class Requirement implements Serializable{
	private static final long serialVersionUID = -910940644528750398L;
	private String name;
	
	public Requirement(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public String print() {
		return name;
	}
}
