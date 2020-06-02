package VIEW;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;
import java.util.*;

public class CadastroPanel extends JPanel {
	
	private List<JTextField> playerNameTextFields = new ArrayList<JTextField>();
	private Image bg;
	
	public CadastroPanel() {
		this.setBackgroundImage("C:\\Users\\leogi\\Documents\\PUC\\POO\\WP\\WAR\\images\\CADASTRO");
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		for (int i = 0; i < 6; i++) {
			JTextField playerName = new JTextField();
			playerName.setMaximumSize(new Dimension(400, 100));
			playerName.setBackground(Color.BLACK);
			playerName.setFont(new Font("Arial", Font.PLAIN, 34));
			playerNameTextFields.add(playerName);
			JButton submitButton = new JButton("Submit");
		}
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	}
	
	public void setBackgroundImage(String path) {
		try {
			this.bg = new ImageIcon(path).getImage();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}

	
}
