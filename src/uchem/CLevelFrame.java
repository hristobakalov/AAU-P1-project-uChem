package uchem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
//NOT USING THIS CLASS - QUESTIONSLEVELFRAME is a better class
public class CLevelFrame {
	private JPanel cLevelPanel = new JPanel();
	
	public CLevelFrame(JPanel mainWindow, JPanel levelsPanel){
		levelsPanel.setVisible(false);
		
		cLevelPanel.setBounds(0, 100, 600, 400);
		cLevelPanel.setBackground(Color.decode("#568ed4"));
		cLevelPanel.setLayout(null);
		
		QuestionsDataAccess questionsClass = new QuestionsDataAccess();
		Question[] allQuestions = questionsClass.getCLevelQuestionsQuestions();
		
		//TODO: make it count on which question is the user and open it
		
		//int positionY = (cLevelPanel.getWidth() - 190)/2;
		int currentQuestion = 1;
		int totalNumberOfQuestions = Question.getQuestionsCount();
		JLabel questionsCounter = new JLabel("Question " + currentQuestion +" / " + totalNumberOfQuestions);
		//#region
		questionsCounter.setBounds(0, 20, cLevelPanel.getWidth(), 50);
		questionsCounter.setHorizontalAlignment(SwingConstants.CENTER);
		questionsCounter.setForeground(Color.WHITE);
		questionsCounter.setFont(new Font("Verdana", Font.PLAIN, 18));
		//#endregion
		cLevelPanel.add(questionsCounter);
		
		JButton backButton = new JButton("Back");
		int buttonWidth = 100;
		int buttonHeight = 30;
		
		backButton.setForeground(Color.WHITE);
		backButton.setFont(new Font("Verdana", Font.PLAIN, 20));
		backButton.setBounds(0, 0, buttonWidth, buttonHeight);
		backButton.setBackground(Color.decode("#1458ae"));
		//TODO: repair back button doesn't work yet
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cLevelPanel.setVisible(false);
				mainWindow.setVisible(true);
			}
		});
		cLevelPanel.add(backButton);
		
		JLabel questionText = new JLabel(allQuestions[0].getQuestion());
		questionText.setBounds(0, 70, cLevelPanel.getWidth(), 50);
		questionText.setHorizontalAlignment(SwingConstants.CENTER);
		questionText.setForeground(Color.WHITE);
		questionText.setFont(new Font("Verdana", Font.PLAIN, 24));
		cLevelPanel.add(questionText);
		
		JButton answer1 = createButton(cLevelPanel, allQuestions[0].getAnswer1(), 130);
		cLevelPanel.add(answer1);
		
		JButton answer2 = createButton(cLevelPanel, allQuestions[0].getAnswer2(), 190);
		cLevelPanel.add(answer2);
		
		JButton answer3 = createButton(cLevelPanel, allQuestions[0].getAnswer3(), 250);
		cLevelPanel.add(answer3);
		
	}
	

	private JButton createButton(JPanel window, String name, int positionY) {
		int buttonWidth = 190;
		int buttonHeight = 40;
		JButton currentButton = new JButton(name);
		currentButton.setForeground(Color.WHITE);
		currentButton.setFont(new Font("Verdana", Font.PLAIN, 20));
		currentButton.setFocusPainted(false);
		int windowWidth = window.getWidth();
		int positionX = (windowWidth - buttonWidth) /2; 
		currentButton.setBounds(positionX, positionY, buttonWidth, buttonHeight);
		currentButton.setBackground(Color.decode("#1458ae"));

		return currentButton;
	}
	
	private void checkAnswer(){
		
	}
	
	public JPanel getCLevelPanel(){
		return cLevelPanel;
	}
}
