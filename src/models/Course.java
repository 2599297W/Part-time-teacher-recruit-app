package models;
import java.io.*;

public class Course implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	
	public Course() {}

	public Course(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void print(PrintStream ps) {
		ps.print(name);
	}
	public String toString() {
		return name;
	}

}
