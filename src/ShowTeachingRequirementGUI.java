import java.util.Scanner;

import controllers.*;
import data.Data;
import models.*;

public class ShowTeachingRequirementGUI {

	public static void main(String[] args) {
		//the database of the teaching requirements
		Data requireData = new Data("src\\data.txt", new LoR());
		//the database of the ppt teachers
		Data teacherData = new Data("src\\teacher.txt", new LoR());
		Data[] data = new Data[6];
		data[0] = requireData;
		data[1] = teacherData;
		Model m = new Model(requireData);
		
		Scanner s = new Scanner(System.in);
		System.out.println("If you are a class director, please input 1");
		System.out.println("If you are a administer, please input 2");
		int str = s.nextInt();
		if(str == 1) {
			//show the teaching requirement app
			RequireController c = new RequireController(m);
		}else if(str == 2) {
			//show the teacher searching app
			SearchModel sm = new SearchModel(data);
			SearchController sc = new SearchController(sm);
		}else {
			System.out.println("Invalid input.");
		}
	}

}
