package uchem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LevelsPanel {
	private JPanel levelsPanel = new JPanel();
	private JButton cLevel;
	private JButton bLevel;
	private JButton aLevel;
	public LevelsPanel(JPanel mainWindow){
		
		//panel settings
		levelsPanel.setBounds(0, 100, 600, 400);
		levelsPanel.setBackground(Color.decode("#568ed4"));
		levelsPanel.setLayout(null);
		
		//label settings
		int positionY = (levelsPanel.getWidth() - 300)/2;
		JLabel chooseLevelLbl = new JLabel(" CHOOSE YOUR LEVEL");
		chooseLevelLbl.setBounds(positionY, 40, 300, 50);
		chooseLevelLbl.setForeground(Color.WHITE);
		chooseLevelLbl.setFont(new Font("Verdana", Font.PLAIN, 24));
		levelsPanel.add(chooseLevelLbl);
		
		//create buttons for the different levels
		cLevel = MainMethods.createButton(levelsPanel, "C Level", 114);
		levelsPanel.add(cLevel);
		
		bLevel = MainMethods.createButton(levelsPanel, "B Level", 175);
		levelsPanel.add(bLevel);
		
		aLevel = MainMethods.createButton(levelsPanel, "A Level", 235);
		levelsPanel.add(aLevel);
		
		//TODO: make this work
		JButton combined = MainMethods.createButton(levelsPanel, "Combined", 295);
		levelsPanel.add(combined);
		
		JButton backButton = MainMethods.createCancelButton(mainWindow, levelsPanel);
		levelsPanel.add(backButton);
		
	}
	
	public JPanel getLevelsPanel(){
		return levelsPanel;
	}
	
	//attaching listener on the buttons
	public void addListenerToCLevelButton(QuestionsLevelFrame currentPanel){
		aLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				levelsPanel.setVisible(false);
				currentPanel.isVisible(true);
				currentPanel.setCurrentLevel("cLevel");
			}
		});
	}
	
	public void addListenerToBLevelButton(QuestionsLevelFrame currentPanel){
		aLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				levelsPanel.setVisible(false);
				currentPanel.isVisible(true);
				currentPanel.setCurrentLevel("bLevel");
			}
		});
	}
	
	public void addListenerToALevelButton(QuestionsLevelFrame currentPanel){
		aLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				levelsPanel.setVisible(false);
				currentPanel.isVisible(true);
				currentPanel.setCurrentLevel("aLevel");
			}
		});
	}
}
