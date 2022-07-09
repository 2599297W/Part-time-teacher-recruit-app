package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

//This class represent a view with a label and a text box of a list
public class CheckPanel extends JPanel{

	public JTextArea list;
	
	public CheckPanel(String currentList,String label) {
		setLayout(new BorderLayout());
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		Font f = new Font("TimesRoman", Font.PLAIN, 20);
		
		JLabel listLabel = new JLabel(label);
		list = new JTextArea(currentList,200,30);
		list.setEditable(false);
		
		add(listLabel,BorderLayout.NORTH);
		add(list,BorderLayout.CENTER);
		setFont(f);
		setBorder(blackline);
	}
}
