package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.*;
import views.SearchView;

public class SearchController implements ActionListener{
	
	private SearchModel modelObject;
	private SearchView viewObject;
	
	public SearchController(SearchModel model) {
		this.modelObject = model;
		this.viewObject = new SearchView(this, model);
		viewObject.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewObject.teacherInput) {
			modelObject.requiredSkillLevel = viewObject.teacherInput.getText();
			System.out.println(modelObject.requiredSkillLevel);
		}else if(e.getSource() == viewObject.courseInput) {
			modelObject.requiredCourse = viewObject.courseInput.getText();
			System.out.println(modelObject.requiredCourse);		
		}else if(e.getSource() == viewObject.searchButton) {
			//check if there are teachers meet the conditions
			modelObject.search();
			//store the message of teachers meet the conditions
			String text = modelObject.getText();
			if(text != null) {
				//if there are teachers meet the conditions
				//update the view
				viewObject.updateTextFields();
			}else {
				//remind there is no suitable teacher
				JOptionPane.showMessageDialog(viewObject, "Can't find a suitable PPT teacher","Reminder",JOptionPane.INFORMATION_MESSAGE);

			}
		}else if(e.getSource() == viewObject.cancelButton) {
			System.exit(0);
		}
	}
}
