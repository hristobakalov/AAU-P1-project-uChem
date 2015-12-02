package uchem;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class uchemUI {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					uchemUI window = new uchemUI();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public uchemUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// TODO: remove code repetition;
		// TODO: improve code quality;
		// TODO: set variables for dimensions and positions;
		
		//frame settings
		JFrame frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 650, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		//initialization of panels
		StartWindow mainWindow = new StartWindow();
		TopPanel topPanel = new TopPanel();
		//LevelsPanel levelsPanel = new LevelsPanel(mainWindow.getMainPanel());
		JPanel levelsPanel = new JPanel();
		QuestionsLevelFrame questionsPanel = new QuestionsLevelFrame(mainWindow.getMainPanel());
		
		// TODO: make only the bottom border in the topPanel appear;
		
		//these should be false in order the mainWindow to appear only
		//levelsPanel.getLevelsPanel().setVisible(false);
		questionsPanel.isVisible(false);
		
		//add panels to the frame in order to be displayed
		frame.getContentPane().add(topPanel.getTopPanel());
		frame.getContentPane().add(questionsPanel.getQuestionsLevelFrame());
		frame.getContentPane().add(mainWindow.getMainPanel());
		
		//levelsPanel.addListenerToALevelButton(questionsPanel);
		//levelsPanel.addListenerToBLevelButton(questionsPanel);
		//levelsPanel.addListenerToCLevelButton(questionsPanel);
		levelsPanel = levels( mainWindow.getMainPanel(), questionsPanel );
		//initially should be false
		levelsPanel.setVisible(false);
		//frame.getContentPane().add(levelsPanel.getLevelsPanel());
		frame.getContentPane().add(levelsPanel);
		//mainWindow.addListenerToStartButton(levelsPanel.getLevelsPanel());
		mainWindow.addListenerToStartButton(levelsPanel);
		
		//mainWindow(mainWindow, levelsPanel);
		

	}

	public JPanel levels (JPanel mainWindow, QuestionsLevelFrame questionsLevelFrame){
		JPanel levelsPanel = new JPanel();
		levelsPanel.setBounds(0, 100, 650, 450);
		levelsPanel.setBackground(Color.decode("#568ed4"));
		levelsPanel.setLayout(null);
		JButton cLevel = MainMethods.createButton(levelsPanel, "C Level", 114);
		levelsPanel.add(cLevel);
		cLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				levelsPanel.setVisible(false);
				questionsLevelFrame.isVisible(true);
				questionsLevelFrame.setCurrentLevel("cLevel");
			}
		});
		
		JButton bLevel = MainMethods.createButton(levelsPanel, "B Level", 174);
		bLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				levelsPanel.setVisible(false);
				questionsLevelFrame.isVisible(true);
				questionsLevelFrame.setCurrentLevel("bLevel");
			}
		});
		levelsPanel.add(bLevel);
		
		JButton aLevel = MainMethods.createButton(levelsPanel, "A Level", 234);
		aLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				levelsPanel.setVisible(false);
				questionsLevelFrame.isVisible(true);
				questionsLevelFrame.setCurrentLevel("aLevel");
			}
		});
		levelsPanel.add(aLevel);
		
		//error on the 7th question
		JButton combined = MainMethods.createButton(levelsPanel, "ALL ABOVE", 294);
		combined.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				levelsPanel.setVisible(false);
				questionsLevelFrame.isVisible(true);
				questionsLevelFrame.setCurrentLevel("all");
			}
		});
		levelsPanel.add(combined);
		
		int positionY = (levelsPanel.getWidth() - 300)/2;
		JLabel lblNewLabel = new JLabel(" CHOOSE YOUR LEVEL");
		lblNewLabel.setBounds(positionY, 40, 300, 50);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		levelsPanel.add(lblNewLabel);
		
		JButton backButton = MainMethods.createCancelButton(mainWindow, levelsPanel);
		levelsPanel.add(backButton);
		return levelsPanel;
		
	}
}
