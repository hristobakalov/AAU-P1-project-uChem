package uchem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class QuestionsLevelFrame {
	private JPanel questionsLevelFrame = new JPanel();
	private int currentQuestion = 1;
	private String currentLevel = "";
	private Question[] allQuestions;
	private JPanel mainWindow;
	private QuestionsDataAccess questionsClass = new QuestionsDataAccess();
	private boolean[][] answerClicked;
	private boolean[][] correctAnswersArr;
	private JButton answer1 = new JButton();
	private JButton answer2 = new JButton();
	private JButton answer3 = new JButton();
	private boolean areButtonsClickable = true;
	public QuestionsLevelFrame(JPanel mainWindow) {
		// levelsPanel.setVisible(false);
		// frame settings
		questionsLevelFrame.setBounds(0, 100, 650, 450);
		questionsLevelFrame.setBackground(Color.decode("#568ed4"));
		questionsLevelFrame.setLayout(null);
		
		this.mainWindow = mainWindow;
		
		
		// put the back button in a method and maybe interface
		// back button settings
		

		//generateQuestions( allQuestions );
		//generateQuestions(mainWindow, allQuestions );

	}
	public void isVisible(boolean visibility){
		questionsLevelFrame.setVisible(visibility);
	}
	
	public void generateQuestions(Question[] allQuestions) {
		questionsLevelFrame.removeAll();
		questionsLevelFrame.repaint();
		if (currentQuestion > allQuestions.length) {
			currentQuestion--;
			//return;
		}
		
		if (answerClicked == null) {
			answerClicked = new boolean[allQuestions.length][3];
		}
		if (correctAnswersArr == null) {
			correctAnswersArr = new boolean[allQuestions.length][3];
		}
		
		JButton cancelButton = MainMethods.createCancelButton(this.mainWindow, this.questionsLevelFrame);
		questionsLevelFrame.add(cancelButton);
		
		JLabel questionsCounter = new JLabel("Question " + currentQuestion + " / " + allQuestions.length);
		questionsCounter.setBounds(0, 20, questionsLevelFrame.getWidth(), 20);
		questionsCounter.setHorizontalAlignment(SwingConstants.CENTER);
		questionsCounter.setForeground(Color.WHITE);
		questionsCounter.setFont(new Font("Verdana", Font.PLAIN, 18));

		questionsLevelFrame.add(questionsCounter);
		//used html in order to make the text wrap when it is longer than the width of the windows
		JLabel questionText = new JLabel(String.format("<html><div style =\"text-align: center \" WIDTH=%d>%s</div><html>", questionsLevelFrame.getWidth(), allQuestions[currentQuestion - 1].getQuestion()));
		questionText.setBounds(0, 60, questionsLevelFrame.getWidth(), 80);
		questionText.setHorizontalAlignment(SwingConstants.CENTER);
		questionText.setForeground(Color.WHITE);
		questionText.setFont(new Font("Verdana", Font.PLAIN, 18));
		//questionText = String.format("<html><div WIDTH=%d>%s</div><html>", questionsLevelFrame.getWidth(), allQuestions[currentQuestion - 1].getQuestion());

		questionsLevelFrame.add(questionText);

		answer1 = createButton( allQuestions,questionsLevelFrame, allQuestions[currentQuestion - 1].getAnswer1(), 150, 0);
		questionsLevelFrame.add(answer1);
		
		answer2 = createButton( allQuestions,questionsLevelFrame, allQuestions[currentQuestion - 1].getAnswer2(), 220, 1);
		questionsLevelFrame.add(answer2);

		answer3 = createButton( allQuestions, questionsLevelFrame, allQuestions[currentQuestion - 1].getAnswer3(), 290, 2);
		questionsLevelFrame.add(answer3);
		
		JButton backButton = createBackButton();
		questionsLevelFrame.add(backButton);
		
		if (currentQuestion == allQuestions.length) {
			JButton submitButton = submitButton();
			questionsLevelFrame.add(submitButton);
		}
		else{
			JButton nextButton = createNextButton();
			questionsLevelFrame.add(nextButton);
		}
	}
	private JButton createBackButton(){
		//no back button if you are on question 1
		JButton backButton = new JButton("Back");
		int buttonWidth = 100;
		int buttonHeight = 40;
		int positionY = 370;
		int positionX = 145;
		backButton.setForeground(Color.WHITE);
		backButton.setFont(new Font("Verdana", Font.PLAIN, 20));
		backButton.setFocusPainted(false);
		
		backButton.setBounds(positionX, positionY, buttonWidth, buttonHeight);
		backButton.setBackground(Color.decode("#1458ae"));
		
		if(currentQuestion-1 == 0){
			backButton.setEnabled(false);
		}
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (currentQuestion-1 > 0) {
					backButton.setEnabled(true);
					currentQuestion--;
					generateQuestions(allQuestions);
				}
				
			}
		});
		
		return backButton;
	}
	
	private JButton createNextButton(){
		//when you are on the last question it should say 'submit' instead of next and show you the results
		JButton nextButton = new JButton("Next");
		int buttonWidth = 100;
		int buttonHeight = 40;
		int positionY = 370;
		int positionX = 405;
		nextButton.setForeground(Color.WHITE);
		nextButton.setFont(new Font("Verdana", Font.PLAIN, 20));
		nextButton.setFocusPainted(false);
		
		nextButton.setBounds(positionX, positionY, buttonWidth, buttonHeight);
		nextButton.setBackground(Color.decode("#1458ae"));
		
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (currentQuestion <= allQuestions.length - 1) {
					currentQuestion++;
					generateQuestions(allQuestions);
				}
				
				
			}
		});
		return nextButton;
	}
	
	private JButton submitButton(){
		JButton submitButton = new JButton("Submit");
		int buttonWidth = 120;
		int buttonHeight = 40;
		int positionY = 370;
		int positionX = 370;
		submitButton.setForeground(Color.WHITE);
		submitButton.setFont(new Font("Verdana", Font.PLAIN, 20));
		submitButton.setFocusPainted(false);
		
		submitButton.setBounds(positionX, positionY, buttonWidth, buttonHeight);
		submitButton.setBackground(Color.decode("#1458ae"));
		
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questionsLevelFrame.removeAll();
				questionsLevelFrame.repaint();
				resultsPage();
				
			}
		});
		return submitButton;
	}
	
	private void resultsPage(){
		int correctAnswers = checkAnswers();
		JLabel results = new JLabel("You answered " + correctAnswers + " / " + allQuestions.length + " questions correct,");
		results.setBounds(0, 20, questionsLevelFrame.getWidth(), 50);
		results.setHorizontalAlignment(SwingConstants.CENTER);
		results.setForeground(Color.WHITE);
		results.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		JLabel resultsText2 = new JLabel("which gives you the grade:");
		resultsText2.setBounds(0, 50, questionsLevelFrame.getWidth(), 50);
		resultsText2.setHorizontalAlignment(SwingConstants.CENTER);
		resultsText2.setForeground(Color.WHITE);
		resultsText2.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		String grade = getGrade(correctAnswers);
		
		JLabel gradeLbl = new JLabel(grade);
		gradeLbl.setBounds(0, 90, questionsLevelFrame.getWidth(), 50);
		gradeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		gradeLbl.setForeground(Color.RED);
		gradeLbl.setFont(new Font("Verdana", Font.BOLD, 27));
		
		questionsLevelFrame.add(results);
		questionsLevelFrame.add(resultsText2);
		questionsLevelFrame.add(gradeLbl);
		
		JButton checkAnswersButton = new JButton("Check your answers");
		int buttonWidth = 280;
		int buttonHeight = 60;
		int positionY = 210;
		checkAnswersButton.setForeground(Color.WHITE);
		checkAnswersButton.setFont(new Font("Verdana", Font.PLAIN, 20));
		checkAnswersButton.setFocusPainted(false);
		int positionX = (questionsLevelFrame.getWidth() - buttonWidth)/2;
		checkAnswersButton.setBounds(positionX, positionY, buttonWidth, buttonHeight);
		checkAnswersButton.setBackground(Color.decode("#1458ae"));
		
		checkAnswersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				areButtonsClickable = false;
				generateQuestions(allQuestions);
			}
		});
		JButton cancelButton = MainMethods.createCancelButton(mainWindow, questionsLevelFrame);
		questionsLevelFrame.add(cancelButton);
		questionsLevelFrame.add(checkAnswersButton);
	}
	
	private String getGrade(int correctAnswers){
		String grade = "";
		double percentage = Math.floor(((double)correctAnswers / allQuestions.length) * 100);
		if (percentage >= 90) {
			grade = "12";
		}
		else if (percentage >= 80) {
			grade = "10";
		}
		else if (percentage >= 70) {
			grade = "7";
		}
		else if (percentage >= 60) {
			grade = "4";
		}
		else if (percentage >= 50) {
			grade = "02";
		}
		else if (percentage >= 30) {
			grade = "00";
		}
		else{
			grade = "-3";
		}
		return grade;
	}
	
	private int checkAnswers(){
		//TODO: implement here the possibility to go through the questions after finishing the quiz
		int correctAnswers = 0;
		for (int i = 0; i < answerClicked.length; i++) {
			for (int j = 0; j < answerClicked[i].length; j++) {
				if (allQuestions[i].getCorrectAnswer() == j) {
					//fill the array in order to be able to show to the user after that which is the correct answer
					correctAnswersArr[i][j] = true;
					if (answerClicked[i][j]) {
						correctAnswers++;
					}
				}
			}
		}
		System.out.println(correctAnswers);
		return correctAnswers;
	}
	
	
	
	private JButton createButton( Question[] questions, JPanel window, String name, int positionY, int index) {
		int buttonWidth = 360;
		int buttonHeight = 60;
		JButton currentButton = new JButton(name);
		
		currentButton.setForeground(Color.WHITE);
		currentButton.setFont(new Font("Verdana", Font.PLAIN, 16));
		currentButton.setFocusPainted(false);
		int windowWidth = window.getWidth();
		int positionX = (windowWidth - buttonWidth) / 2;
		currentButton.setBounds(positionX, positionY, buttonWidth, buttonHeight);
		//if the button has been clicked, change color
		if (answerClicked[currentQuestion - 1][index] && areButtonsClickable) {
			currentButton.setBackground(Color.decode("#9d9d9d"));//#9d9d9d //#4b8a56
		}
		else if(answerClicked[currentQuestion - 1][index] && correctAnswersArr[currentQuestion - 1][index] && !areButtonsClickable){
			currentButton.setBackground(Color.decode("#37a147"));
		}
		else if(answerClicked[currentQuestion - 1][index] && !correctAnswersArr[currentQuestion - 1][index] && !areButtonsClickable){
			currentButton.setBackground(Color.decode("#f30b0b"));
		}
		else{
			currentButton.setBackground(Color.decode("#1458ae"));
		}
		
		if (!answerClicked[currentQuestion - 1][index] && correctAnswersArr[currentQuestion - 1][index] && !areButtonsClickable) {
			currentButton.setBackground(Color.decode("#37a147"));
		}
		
		if (areButtonsClickable) {
			currentButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					answerClicked[currentQuestion - 1] = new boolean[3];
					System.out.println(answerClicked[currentQuestion - 1][0] +" "+ answerClicked[currentQuestion - 1][1] +" "+ answerClicked[currentQuestion - 1][2]);
					resetButtonColors();
					answerClicked[currentQuestion - 1][index] = true;
					currentButton.setBackground(Color.decode("#9d9d9d"));
					System.out.println((currentQuestion -1) + " "+ index + " clicked");
					System.out.println(answerClicked[currentQuestion - 1][0] +" "+ answerClicked[currentQuestion - 1][1] +" "+ answerClicked[currentQuestion - 1][2]);
				}
			});
		}
		
		return currentButton;
	}
	
	private void resetButtonColors(){
		answer1.setBackground(Color.decode("#1458ae"));
		answer2.setBackground(Color.decode("#1458ae"));
		answer3.setBackground(Color.decode("#1458ae"));
	}
	
	public void setCurrentLevel(String level){
		//TODO: exception throwing
		//TODO: maybe use ENUMERATION
		//TODO: maybe rename method or change something here
		this.currentLevel = level;
		answerClicked = null;
		areButtonsClickable = true;
		correctAnswersArr = null;
		currentQuestion = 1;
		switch (currentLevel) {
		case "cLevel":
			allQuestions = questionsClass.getCLevelQuestionsQuestions();
			break;
		case "bLevel":
			allQuestions = questionsClass.getBLevelQuestionsQuestions();
			break;
		case "aLevel":
			allQuestions = questionsClass.getALevelQuestionsQuestions();
			break;
		case "all":
			allQuestions = questionsClass.getAllQuestions();
			for (int i = 0; i < allQuestions.length; i++) {
				System.out.println(allQuestions[i].toString());
			}
		}
		generateQuestions( allQuestions );
	}
	
	//private void initialization(){}
	
	public JPanel getQuestionsLevelFrame() {
		return questionsLevelFrame;
	}
}
