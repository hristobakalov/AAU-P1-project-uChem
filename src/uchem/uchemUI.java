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
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		//initialization of panels
		StartWindow mainWindow = new StartWindow();
		JPanel topPanel = new JPanel();
		JPanel levelsPanel = new JPanel();
		QuestionsLevelFrame questionsPanel = new QuestionsLevelFrame(mainWindow.getMainPanel());
		
		// TODO: make only the bottom border in the topPanel appear;
		
		//these should be false in order the mainWindow to appear only
		levelsPanel.setVisible(false);
		questionsPanel.isVisible(false);
		
		
		topPanel = topPanel();
		
		frame.getContentPane().add(topPanel);
		frame.getContentPane().add(questionsPanel.getQuestionsLevelFrame());
		frame.getContentPane().add(mainWindow.getMainPanel());
		
		levelsPanel = levels( mainWindow.getMainPanel(), questionsPanel );
		//initially should be false
		levelsPanel.setVisible(false);
		frame.getContentPane().add(levelsPanel);
		
		mainWindow.addListenerToStartButton(levelsPanel);
		
		//mainWindow(mainWindow, levelsPanel);
		

	}

	public JPanel topPanel(){

		JPanel topPanel = new JPanel();
		
		topPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		topPanel.setBounds(0, 0, 600, 100);
		topPanel.setBackground(Color.decode("#126ad9"));
		topPanel.setLayout(null);
		
		JLabel logoLabel = new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource("/logo1.png")).getImage();
		logoLabel.setIcon(new ImageIcon(logo));
		logoLabel.setBounds(0, 11, 65, 80);
		topPanel.add(logoLabel);

		int positionY = (topPanel.getWidth() - 229)/2;
		JLabel uChemLabel = new JLabel("");
		Image uChemLogo = new ImageIcon(this.getClass().getResource("/uChem1.png")).getImage();
		uChemLabel.setIcon(new ImageIcon(uChemLogo));
		uChemLabel.setBounds(positionY, 11, 229, 80);
		topPanel.add(uChemLabel);
		
		return topPanel;
	}
	

	public JButton createButton(JPanel window, String name, int positionY) {
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
	
	public JPanel levels (JPanel mainWindow, QuestionsLevelFrame questionsLevelFrame){
		JPanel levelsPanel = new JPanel();
		levelsPanel.setBounds(0, 100, 600, 400);
		levelsPanel.setBackground(Color.decode("#568ed4"));
		levelsPanel.setLayout(null);
		JButton cLevel = createButton(levelsPanel, "C Level", 114);
		levelsPanel.add(cLevel);
		cLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				levelsPanel.setVisible(false);
				questionsLevelFrame.isVisible(true);
				questionsLevelFrame.setCurrentLevel("cLevel");
			}
		});
		
		JButton bLevel = createButton(levelsPanel, "B Level", 174);
		bLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				levelsPanel.setVisible(false);
				questionsLevelFrame.isVisible(true);
				questionsLevelFrame.setCurrentLevel("bLevel");
			}
		});
		levelsPanel.add(bLevel);
		
		JButton aLevel = createButton(levelsPanel, "A Level", 234);
		aLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				levelsPanel.setVisible(false);
				questionsLevelFrame.isVisible(true);
				questionsLevelFrame.setCurrentLevel("aLevel");
			}
		});
		levelsPanel.add(aLevel);
		
		JButton combined = createButton(levelsPanel, "Combined", 294);
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
