package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import controllers.RequireController;

//This class represents a panel for entering a new teaching requirement
public class WritePanel extends JPanel{
	public JButton cancelButton, saveButton;
	public JTextField listNameInput, courseNameInput, teacherReqInput;

	public WritePanel(RequireController controllerObject) {
		setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Create a new teaching requirement");

		JPanel centerPanel = new JPanel(new GridLayout(4,2));
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		Font f = new Font("TimesRoman", Font.PLAIN, 24);
		
		JLabel listName = new JLabel("Teaching requirement name:");
		listNameInput = new JTextField("Please input teaching requirement name to end with enter.");
		listNameInput.addActionListener(controllerObject);
		listNameInput.setEditable(true);
		
		JLabel courseName = new JLabel("Course name:");
		courseNameInput = new JTextField("Please input course name to end with enter.");
		courseNameInput.addActionListener(controllerObject);
		courseNameInput.setEditable(true);
		
		JLabel teacherReq = new JLabel("Teacher requirement:");
		teacherReqInput = new JTextField("Please input the skill level of a required PPT teacher.");
		teacherReqInput.addActionListener(controllerObject);
		teacherReqInput.setEditable(true);
		
		JTextArea note = new JTextArea("if need other teachers, re-input the last box after entering");
		note.setEditable(false);
		
		centerPanel.add(listName);
		centerPanel.add(listNameInput);
		centerPanel.add(courseName);
		centerPanel.add(courseNameInput);
		centerPanel.add(teacherReq);
		centerPanel.add(teacherReqInput);
		centerPanel.add(note);
		
		centerPanel.setBorder(blackline);
		centerPanel.setFont(f);
		
		JPanel bottomPanel = new JPanel(new GridLayout(1,2));
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(controllerObject);
		
		saveButton = new JButton("Save this requirement");
		saveButton.addActionListener(controllerObject);
		
		bottomPanel.add(cancelButton);
		bottomPanel.add(saveButton);
		
		
		bottomPanel.setBorder(blackline);
		bottomPanel.setFont(f);
		
		add(title, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
	}
	
	public JButton getCancelButton() {
		return cancelButton;
	}
	public JButton getSaveButton() {
		return saveButton;
	}
	
	public void resetTextFields() {
		listNameInput.setText("");
		courseNameInput.setText("");
		teacherReqInput.setText("");
	}
	
}
