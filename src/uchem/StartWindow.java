package uchem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StartWindow {
	private JPanel mainWindow = new JPanel();
	private JButton start;
	private JButton dictionary;
	private JButton aboutUs;
	//StartWindow is the main application panel
	public StartWindow(){
		//panel settings
		mainWindow.setBounds(0, 100, 600, 400);
		mainWindow.setBackground(Color.decode("#568ed4"));
		mainWindow.setLayout(null);
		
		//initialization of buttons
		start = MainMethods.createButton(mainWindow, "START", 70);
		mainWindow.add(start);
		
		dictionary = MainMethods.createButton(mainWindow,"DICTIONARY", 130);
		mainWindow.add(dictionary);

		aboutUs = MainMethods.createButton(mainWindow,"ABOUT US", 190);
		mainWindow.add(aboutUs);
		
	}
	//making the mainWindow accessible from outside the class
	public JPanel getMainPanel(){
		return mainWindow;
	}
	//the method attaches an action listener to a specific button
	public void addListenerToStartButton(JPanel panel){
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.setVisible(false);
				panel.setVisible(true);
			}
		});
	}
	//the method attaches an action listener to a specific button
	public void addListenerToDictionaryButton(JPanel panel){
		dictionary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.setVisible(false);
				panel.setVisible(true);
			}
		});
	}
	//the method attaches an action listener to a specific button
	public void addListenerToAboutUsButton(JPanel panel){
		aboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.setVisible(false);
				panel.setVisible(true);
			}
		});
	}
}
