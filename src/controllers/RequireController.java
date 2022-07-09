package controllers;

import models.*;
import views.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class RequireController implements ActionListener{
	
	private View viewObject;
	private Model modelObject;
	
	public RequireController(Model model) {
		this.modelObject = model;
		this.viewObject = new View(this, model);
		viewObject.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewObject.writePanel.listNameInput) {
			modelObject.teachRequirName = viewObject.writePanel.listNameInput.getText();
			System.out.println(modelObject.teachRequirName);
		}else if(e.getSource() == viewObject.writePanel.courseNameInput) {
			modelObject.courseName = viewObject.writePanel.courseNameInput.getText();
			System.out.println(modelObject.courseName);
		}else if(e.getSource() == viewObject.writePanel.teacherReqInput) {
			modelObject.skillLevels.add(viewObject.writePanel.teacherReqInput.getText());
			System.out.println(modelObject.skillLevels);	
		}else if(e.getSource() == viewObject.writePanel.saveButton) {
			if(!modelObject.isValid()) {
				//if entered message is not valid
				//remind users
				JOptionPane.showMessageDialog(viewObject, "Please enter a valid massage","Warning",JOptionPane.ERROR_MESSAGE);
			}else {
				//check if the requirement exist by its name
				Requirement r = modelObject.isExist();
				if(r !=null) {
					//if it exist
					//remind users
					JOptionPane.showMessageDialog(viewObject, "The requirement exists!","Warning",JOptionPane.ERROR_MESSAGE);
					//ask if change the existing requirement
					int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Do you want to modify the existing requirement?", "Reminder", JOptionPane.YES_NO_OPTION);
					//if user want to change
					modelObject.input(showConfirmDialog, r);
				}
				//updata the view
				viewObject.updateTextFields();
			}
		}else if(e.getSource() == viewObject.writePanel.cancelButton) {
			viewObject.writePanel.resetTextFields();
			System.exit(0);
		}
	}
	
	
	

}
