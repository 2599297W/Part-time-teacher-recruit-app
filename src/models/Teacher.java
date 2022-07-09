package models;

public class Teacher extends Requirement{
	private String skillLevel;
	//such as tutor, graduate demonstrator, undergraduate demonstrator
	
	//The course this teacher can take
	private String course;
	
	public Teacher(String name, String course, String skillLevel) {
		super(name);
		this.course = course;
		this.skillLevel = skillLevel;
	}

	public String getSkillLevel() {
		return skillLevel;
	}
	public String getCourse() {
		return course;
	}
	@Override
	public String print() {
		return "name:"+getName()+", Course: "+course+", skill level:"+skillLevel;
	}
	
	
}
