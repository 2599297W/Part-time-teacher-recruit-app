package models;

import data.Data;

public class SearchModel {
	//database
	public Data requireData;
	public Data teacherData;

	//The template text
	private String text;
	//The required skill level
	public String requiredSkillLevel;
	//The required course
	public String requiredCourse;
	
	public SearchModel(Data[] data) {
		this.requireData = data[0];
		this.teacherData = data[1];
	}
	//search if there are some teachers meet the conditions
	public void search() {
		LoR teacherList = new LoR();
		for(int i = 0; i< teacherData.list.getI();i++) {
			//iterate teachers in list of teacherData
			Teacher t = (Teacher)teacherData.list.next();
			//System.out.println(t.print());
			if(t.getCourse().equals(requiredCourse) && t.getSkillLevel().equals(requiredSkillLevel)) {
				//if course and skill level are same
				//store it in teacherList
				teacherList.add(t);
			}
		}
		//reset the it of the list
		teacherData.list.reset();
		if(teacherList.getI() != 0){
			//if there are some teachers meet the condition
			//store the message of the list in text
			text = teacherList.print();
		}
	}
	//get the text
	public String getText() {
		return  text;
	}
}
