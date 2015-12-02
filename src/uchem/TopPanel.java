package uchem;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TopPanel {
	private JPanel topPanel = new JPanel();
	public TopPanel(){
		//panel settings
		topPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		topPanel.setBounds(0, 0, 650, 100);
		topPanel.setBackground(Color.decode("#126ad9"));
		topPanel.setLayout(null);
		
		//this is how pictures are shown
		JLabel logoLabel = new JLabel("");
		Image logo = new ImageIcon(this.getClass().getResource("/logo1.png")).getImage();
		logoLabel.setIcon(new ImageIcon(logo));
		logoLabel.setBounds(0, 11, 65, 80);
		topPanel.add(logoLabel);

		//the position is used to center the picture
		int positionY = (topPanel.getWidth() - 229)/2;
		JLabel uChemLabel = new JLabel("");
		Image uChemLogo = new ImageIcon(this.getClass().getResource("/uChem1.png")).getImage();
		uChemLabel.setIcon(new ImageIcon(uChemLogo));
		uChemLabel.setBounds(positionY, 11, 229, 80);
		topPanel.add(uChemLabel);
	}
	
	public JPanel getTopPanel(){
		return topPanel;
	}
}
