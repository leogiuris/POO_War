package VIEW;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.*;
import java.util.*;

public class CadastroPanel extends JPanel {
	
	private List<JTextField> playerNameTextFields = new ArrayList<JTextField>();
	private Image bg;
	
	public CadastroPanel() {
		
		Dimension textDimension = new Dimension(100, 30);
		Dimension panelDimension = new Dimension(275, 600);
		Dimension jogadoresDimension = new Dimension(100,180);
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setBackgroundImage("C:/Users/Antonio/Desktop/POO_War-develop/POO_War-develop/images/CADASTRO/bgconfiguracao.png");
		this.setMaximumSize(panelDimension);
		this.setMinimumSize(panelDimension);
		this.setPreferredSize(panelDimension);
		this.setBounds(375,30, panelDimension.width, panelDimension.height);
		
		Container Jogadores = new Container();
		Jogadores.setLayout(new BoxLayout(Jogadores,BoxLayout.Y_AXIS));
		Jogadores.setMaximumSize(jogadoresDimension);
		Jogadores.setMinimumSize(jogadoresDimension);
		Jogadores.setPreferredSize(jogadoresDimension);
		
		this.add(Box.createRigidArea(new Dimension(0, 200)));
		
		for (int i = 0; i < 6; i++) {
			JTextField playerName = new JTextField(20);
			switch(i) {
			case 0:
				playerName.setMaximumSize(textDimension);
				playerName.setMinimumSize(textDimension);
				playerName.setPreferredSize(textDimension);
				playerName.setHorizontalAlignment(JTextField.LEFT);
				playerName.setAlignmentX(Component.CENTER_ALIGNMENT); 
				playerName.setBackground(Color.WHITE);
				playerName.setFont(new Font("Arial", Font.PLAIN, 12));
				Jogadores.add(playerName);
				playerNameTextFields.add(playerName);
				break;
			case 1:
				playerName.setMaximumSize(textDimension);
				playerName.setMinimumSize(textDimension);
				playerName.setPreferredSize(textDimension);
				playerName.setHorizontalAlignment(JTextField.LEFT);
				playerName.setAlignmentX(Component.CENTER_ALIGNMENT); 
				playerName.setBackground(Color.BLACK);
				playerName.setFont(new Font("Arial", Font.PLAIN, 12));
				Jogadores.add(playerName);
				playerNameTextFields.add(playerName);
				break;
			case 2:
				playerName.setMaximumSize(textDimension);
				playerName.setMinimumSize(textDimension);
				playerName.setPreferredSize(textDimension);
				playerName.setHorizontalAlignment(JTextField.LEFT);
				playerName.setAlignmentX(Component.CENTER_ALIGNMENT); 
				playerName.setBackground(Color.BLUE);
				playerName.setFont(new Font("Arial", Font.PLAIN, 12));
				Jogadores.add(playerName);
				playerNameTextFields.add(playerName);
				break;
			case 3:
				playerName.setMaximumSize(textDimension);
				playerName.setMinimumSize(textDimension);
				playerName.setPreferredSize(textDimension);
				playerName.setHorizontalAlignment(JTextField.LEFT);
				playerName.setAlignmentX(Component.CENTER_ALIGNMENT); 
				playerName.setBackground(Color.GREEN);
				playerName.setFont(new Font("Arial", Font.PLAIN, 12));
				Jogadores.add(playerName);
				playerNameTextFields.add(playerName);
				break;
			case 4:
				playerName.setMaximumSize(textDimension);
				playerName.setMinimumSize(textDimension);
				playerName.setPreferredSize(textDimension);
				playerName.setHorizontalAlignment(JTextField.LEFT);
				playerName.setAlignmentX(Component.CENTER_ALIGNMENT); 
				playerName.setBackground(Color.YELLOW);
				playerName.setFont(new Font("Arial", Font.PLAIN, 12));
				Jogadores.add(playerName);
				playerNameTextFields.add(playerName);
				break;
			case 5:
				playerName.setMaximumSize(textDimension);
				playerName.setMinimumSize(textDimension);
				playerName.setPreferredSize(textDimension);
				playerName.setHorizontalAlignment(JTextField.LEFT);
				playerName.setAlignmentX(Component.CENTER_ALIGNMENT); 
				playerName.setBackground(Color.RED);
				playerName.setFont(new Font("Arial", Font.PLAIN, 12));
				Jogadores.add(playerName);
				playerNameTextFields.add(playerName);
				break;
			}
		}
		
		
		JButton submitButton = new JButton("Submit");
		submitButton.setAlignmentX(Component.CENTER_ALIGNMENT); 
		submitButton.addActionListener(null);
		this.add(Jogadores);
		this.add(Box.createRigidArea(new Dimension(0, 50)));
		this.add(submitButton);
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
