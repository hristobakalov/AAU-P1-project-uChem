package uchem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StartWindow {
	private JPanel mainWindow;
	
	public StartWindow(){
		mainWindow.setBounds(0, 100, 600, 400);
		mainWindow.setBackground(Color.decode("#568ed4"));
		mainWindow.setLayout(null);
		
		JButton start = createButton(mainWindow, "START", 70);
		mainWindow.add(start);
		//start.getLabel()
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.setVisible(false);
				//levelsPanel.setVisible(true);
			}
		});

		JButton dictionary = createButton(mainWindow,"DICTIONARY", 130);
		mainWindow.add(dictionary);

		dictionary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//mainWindow.setVisible(false);
			}
		});

		JButton aboutUs = createButton(mainWindow,"ABOUT US", 190);
		mainWindow.add(aboutUs);
		
		aboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//mainWindow.setVisible(false);
			}
		});
	}
	
	private JButton createButton(JPanel window, String name, int positionY) {
		int buttonWidth = 190;
		int buttonHeight = 50;
		
		JButton currentButton = new JButton(name);
		
		currentButton.setForeground(Color.WHITE);
		currentButton.setFont(new Font("Verdana", Font.PLAIN, 24));
		currentButton.setFocusPainted(false);
		
		int windowWidth = window.getWidth();
		
		int positionX = (windowWidth - buttonWidth) /2; 
		currentButton.setBounds(positionX, positionY, buttonWidth, buttonHeight);
		currentButton.setBackground(Color.decode("#1458ae"));

		return currentButton;
	}
	
	public void addListenerToButton(){
		
	}
}
