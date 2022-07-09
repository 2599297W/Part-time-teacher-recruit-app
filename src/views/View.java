package views;


import javax.swing.*;

import controllers.RequireController;
import models.Model;
import java.awt.*;

public class View extends JFrame{
	public CheckPanel checkPanel;
	public WritePanel writePanel;
	
	private RequireController controllerObject;
	private Model modelObject;
	
	public View(RequireController controller, Model model) {
		modelObject = model;
		controllerObject = controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Teaching Requirement Application");
		setSize(800, 800);
		setLayout(new GridLayout(2,1));
		layoutComponents();
	}
	
	private void layoutComponents() {
		checkPanel = new CheckPanel(modelObject.data.read(),"Current teaching requirements:");		
		
		writePanel = new WritePanel(controllerObject);
		
		this.add(checkPanel);
		this.add(writePanel);
	}
	//update the text on the view
	public void updateTextFields() {
		checkPanel.list.setText(modelObject.getText());
		writePanel.resetTextFields();
	}
}
