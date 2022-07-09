package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import controllers.SearchController;
import models.SearchModel;
import data.Data;

public class SearchView extends JFrame{
	private CheckPanel checkTeacherPanel;
	private CheckPanel checkRequirePanel;
	public CheckPanel suitableTeacherPanel;
	
	private SearchController controllerObject;
	private SearchModel modelObject;
	
	public JButton cancelButton, searchButton;
	public JTextField teacherInput, courseInput;

	public SearchView(SearchController controller, SearchModel model) {
		this.controllerObject = controller;
		this.modelObject = model;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Search suitable PPT teacher");
		setSize(800, 800);
		layoutComponents();
	}
	
	private void layoutComponents() {
		setLayout(new BorderLayout());
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		Font f = new Font("TimesRoman", Font.PLAIN, 20);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3,1));
		centerPanel.setBorder(blackline);
		centerPanel.setFont(f);
		
		checkTeacherPanel = new CheckPanel(modelObject.teacherData.read(),"Existing PPT teachers:");
		
		checkRequirePanel = new CheckPanel(modelObject.requireData.read(),"Existing teaching requirements:");
		
		suitableTeacherPanel = new CheckPanel("","Suitable teacher");
		
		centerPanel.add(checkTeacherPanel);
		centerPanel.add(checkRequirePanel);
		centerPanel.add(suitableTeacherPanel);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(2,2));
		inputPanel.setBorder(blackline);
		inputPanel.setFont(f);
		
		JLabel tlabel = new JLabel("Required skill level:");
		teacherInput = new JTextField("Please input ...");
		teacherInput.addActionListener(controllerObject);
		teacherInput.setEditable(true);

		JLabel clabel = new JLabel("Required course:");
		courseInput = new JTextField("Please input ...");
		courseInput.addActionListener(controllerObject);
		courseInput.setEditable(true);
		
		inputPanel.add(tlabel);
		inputPanel.add(teacherInput);
		inputPanel.add(clabel);
		inputPanel.add(courseInput);
		
		JPanel bottomPanel = new JPanel(new GridLayout(1,2));
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(controllerObject);
		
		searchButton = new JButton("Search");
		searchButton.addActionListener(controllerObject);
		
		bottomPanel.add(cancelButton);
		bottomPanel.add(searchButton);
		
		bottomPanel.setBorder(blackline);
		bottomPanel.setFont(f);
		
		add(centerPanel,BorderLayout.CENTER);
		add(inputPanel,BorderLayout.NORTH);
		add(bottomPanel,BorderLayout.SOUTH);
		
	}
	//update text on the view
	public void updateTextFields() {
		suitableTeacherPanel.list.setText(modelObject.getText());
	}
}
