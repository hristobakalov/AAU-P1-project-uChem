package uchem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

//maybe abstract? no need of constructor
public class MainMethods {
	
	public static JButton createCancelButton(JPanel mainWindow, JPanel currentPanel){
		JButton cancelButton = new JButton("Cancel");
		int buttonWidth = 120;
		int buttonHeight = 30;
		
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setFont(new Font("Verdana", Font.PLAIN, 20));
		cancelButton.setBounds(0, 0, buttonWidth, buttonHeight);
		cancelButton.setBackground(Color.decode("#1458ae"));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentPanel.setVisible(false);
				currentPanel.removeAll();
				mainWindow.setVisible(true);
			}
		});
		
		return cancelButton;
	}

	public static JButton createButton(JPanel window, String name, int positionY) {
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
}
