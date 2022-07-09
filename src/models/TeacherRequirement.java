package models;

public class TeacherRequirement extends Requirement{

	public TeacherRequirement(String skillLevel) {
		super(skillLevel);
	}
	@Override
	public String print() {
		return this.getName();
	}

}
