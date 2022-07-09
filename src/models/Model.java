package models;

import java.util.ArrayList;

import data.Data;

public class Model {
	//The database
	public Data data;
	
	//The name of the teaching requirement
	public String teachRequirName;
	//The name of the course
	public String courseName;
	//The list of informations of teacher's requirements
	public ArrayList<String> skillLevels = new ArrayList<String>();
	//A template text
	private String text;
	
	public Model(Data data) {
		this.data = data;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	//According to showConfirmDialog, check if change the existing requirement
	public void input(int showConfirmDialog,Requirement r) {
		if(showConfirmDialog == 0) {
			//if showConfirmDialog equals to 0, change r
			//remove r
			data.list.remove(r);
			//store a new one
			update();
		}
	}
	//update the database
	private void update() {
		LoR slist = new LoR();
		for(String s : skillLevels) {
			//According to skill levels entered, create corresponding teacher requirements
			//store them in a list
			slist.add(new TeacherRequirement(s));
		}
		//store the new teaching requirements in cached list
		data.list.add(new TeachingRequirement(teachRequirName, new Course(courseName), slist));
		//call write method of data
		data.write();
		//store the updated in temp text
		text = data.read();
		//clear skill levels for next teaching requirement
		skillLevels.clear();
	}
	//Check if the enter message is valid 
	public boolean isValid() {
		if(teachRequirName.equals("")||courseName.equals("")||skillLevels.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	//Check if the requirement exist by its name
	public Requirement isExist() {
		Requirement r = data.list.find(teachRequirName);
		if(r != null) {
			return r;
		}else {
			update();
			return null;
		}
	}
}
