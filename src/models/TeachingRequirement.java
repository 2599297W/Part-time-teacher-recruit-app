package models;

public class TeachingRequirement extends Requirement{
	//The course of a teaching requirement
	private Course course;
	//The list of teacher requirement of a teaching requiremetn
	private LoR trList;
	
	public TeachingRequirement(String name, Course course, LoR trList) {
		super(name);
		this.course = course;
		this.trList = trList;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public LoR getTrList() {
		return trList;
	}

	public void setTrList(LoR trList) {
		this.trList = trList;
	}
	@Override
	public String print() {
		String text = super.print();
		text += ":\ncourse:"+course+
				"\nTeacher requirement: "+trList.statics()+"\n";
		return text;
	}



}
