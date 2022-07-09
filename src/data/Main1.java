package data;

//Test code and write object in the database

import models.Course;
import models.LoR;
import models.TeacherRequirement;
import models.TeachingRequirement;

public class Main1 {
	public static void main(String[] args) {
		TeacherRequirement t = new TeacherRequirement("tutor");
		TeacherRequirement a = new TeacherRequirement("tutor");
		TeacherRequirement b = new TeacherRequirement("graduate demonstrator");
		TeacherRequirement s = new TeacherRequirement("undergraduate demonstrator");
		LoR tlist = new LoR();
		tlist.add(t);
		tlist.add(a);
		tlist.add(b);
		//tlist.add(s);
		Course c = new Course("Chinese");
		Course c2 = new Course("japanese");
		Course c3 = new Course("IT");
		TeachingRequirement tr = new TeachingRequirement("The teaching requirement of Chinese",c,tlist);
		
		LoR rlist = new LoR();
		rlist.add(tr);
		
		LoR list2 = new LoR();
		list2.add(t);
		list2.add(t);
		
		TeachingRequirement tr2 = new TeachingRequirement("The teaching requirement of Japanese",c2,list2);
		rlist.add(tr2);
		
		LoR list3 = new LoR();
		list3.add(s);		
		TeachingRequirement tr3 = new TeachingRequirement("The teaching requirement of IT",c3,list3);
		rlist.add(tr2);
		LoR rr = new LoR();
		rr.add(tr);
		rr.add(tr3);
		rr.add(tr2);
		Data m3 = new Data("src\\data.txt", rr);
	    m3.write();
//	    Teacher t1 = new Teacher("Tom","Math","undergraduate demonstrator");
//	    Teacher t2 = new Teacher("Jerry","Chinese","tutor");
//	    Teacher t3 = new Teacher("Doge","japanese","tutor");
//	    Teacher t4 = new Teacher("James","IT","tutor");
//	    Teacher t5 = new Teacher("Durant","Chinese","graduate demonstrator");
//	    Teacher t6 = new Teacher("Harden","japanese","tutor");
//	    Teacher t7 = new Teacher("ZeYu","IT","undergraduate demonstrator");
//	    LoR array = new LoR();
//		Data m2 = new Data("src\\teacher.txt", array);
//	    array.add(t1);
//	    array.add(t2);
//	    array.add(t3);
//	    array.add(t4);
//	    array.add(t5);
//	    array.add(t6);
//	    array.add(t7);
	    
	  
		    //m2.write();
		    //System.out.println(m2.read());
	    }
//	    System.out.println(m2.read());
	    
	   

}
