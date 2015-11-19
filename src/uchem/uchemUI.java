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

	private JFrame frame;

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
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		//initialization of panels
		JPanel topPanel = new JPanel();
		JPanel mainWindow = new JPanel();
		//mainWindow.setVisible(false);
		JPanel levelsPanel = new JPanel();
		levelsPanel.setVisible(false);
		JPanel cPanel = new JPanel();
		cPanel.setVisible(false);
		// TODO: make only the bottom border appear;
		QuestionsLevelFrame questionsPanel = new QuestionsLevelFrame(mainWindow, "cLevel");
		questionsPanel.isVisible(false);
		//topPanel settings
		topPanel = topPanel();
		frame.getContentPane().add(topPanel);
		
		//mainPanel settings
		mainWindow.setBounds(0, 100, 600, 400);
		frame.getContentPane().add(mainWindow);
		mainWindow.setBackground(Color.decode("#568ed4"));
		mainWindow.setLayout(null);
		
		frame.getContentPane().add(questionsPanel.getCLevelPanel());
		//questonsLevelFrame is made better than this don't use it
		//CLevelFrame cLevelInitialize = new CLevelFrame(mainWindow, levelsPanel);
		//cPanel = cLevelInitialize.getCLevelPanel();
		//frame.getContentPane().add(cPanel);
		cPanel.setVisible(false);
		
		
		levelsPanel = levels( mainWindow, questionsPanel );
		//initially should be false
		levelsPanel.setVisible(false);
		frame.getContentPane().add(levelsPanel);
		
		
		mainWindow(mainWindow, levelsPanel);
		

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
	
	//make mainWindow a class
	public void mainWindow(JPanel mainWindow, JPanel levelsPanel) {
		JButton start = createButton(mainWindow, "START", 70);
		mainWindow.add(start);
		
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainWindow.setVisible(false);
				levelsPanel.setVisible(true);
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
	
	public JPanel levels (JPanel mainWindow, QuestionsLevelFrame cPanel){
		JPanel levelsPanel = new JPanel();
		levelsPanel.setBounds(0, 100, 600, 400);
		levelsPanel.setBackground(Color.decode("#568ed4"));
		levelsPanel.setLayout(null);
		JButton cLevel = createButton(levelsPanel, "C Level", 114);
		levelsPanel.add(cLevel);
		cLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				levelsPanel.setVisible(false);
				cPanel.isVisible(true);
			}
		});
		
		JButton bLevel = createButton(levelsPanel, "B Level", 174);
		levelsPanel.add(bLevel);
		
		JButton aLevel = createButton(levelsPanel, "A Level", 234);
		levelsPanel.add(aLevel);
		
		JButton combined = createButton(levelsPanel, "Combined", 294);
		levelsPanel.add(combined);
		
		int positionY = (levelsPanel.getWidth() - 300)/2;
		JLabel lblNewLabel = new JLabel(" CHOOSE YOUR LEVEL");
		lblNewLabel.setBounds(positionY, 40, 300, 50);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		levelsPanel.add(lblNewLabel);
		
		JButton backButton = new JButton("Back");
		int buttonWidth = 100;
		int buttonHeight = 30;
		
		backButton.setForeground(Color.WHITE);
		backButton.setFont(new Font("Verdana", Font.PLAIN, 20));
		backButton.setBounds(0, 0, buttonWidth, buttonHeight);
		backButton.setBackground(Color.decode("#1458ae"));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				levelsPanel.setVisible(false);
				mainWindow.setVisible(true);
			}
		});
		levelsPanel.add(backButton);
		return levelsPanel;
		
	}
}
