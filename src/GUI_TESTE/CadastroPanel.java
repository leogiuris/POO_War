package GUI_TESTE;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

import CONTROL.Partida;

public class CadastroPanel extends JPanel implements ActionListener {
	
	private List<JTextField> playerNameTextFields = new ArrayList<JTextField>();
	private Image bg;
	Dimension textDimension = new Dimension(100, 30);
	Dimension panelDimension = new Dimension(275, 600);
	Dimension jogadoresDimension = new Dimension(100,180);
	
	
	
	public CadastroPanel() {
		Toolkit tk=Toolkit.getDefaultToolkit();
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.bg = tk.getImage("./images/CADASTRO/bgconfiguracao.png");
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
				CadastroJogador(Jogadores, playerName, Color.WHITE);
				break;
			case 1:
				CadastroJogador(Jogadores, playerName, Color.BLACK);
				break;
			case 2:
				CadastroJogador(Jogadores, playerName, Color.BLUE);
				break;
			case 3:
				CadastroJogador(Jogadores, playerName, Color.GREEN);
				break;
			case 4:
				CadastroJogador(Jogadores, playerName, Color.YELLOW);
				break;
			case 5:
				CadastroJogador(Jogadores, playerName, Color.RED);
				break;
			}
		}
		
		
		JButton submitButton = new JButton("Submit");
		submitButton.setAlignmentX(Component.CENTER_ALIGNMENT); 
		submitButton.addActionListener(this);
		this.add(Jogadores);
		this.add(Box.createRigidArea(new Dimension(0, 50)));
		this.add(submitButton);
	}
	
	
	private void CadastroJogador(Container cont, JTextField pNome, Color c) {
		pNome.setMaximumSize(textDimension);
		pNome.setMinimumSize(textDimension);
		pNome.setPreferredSize(textDimension);
		pNome.setHorizontalAlignment(JTextField.LEFT);
		pNome.setAlignmentX(Component.CENTER_ALIGNMENT); 
		pNome.setBackground(c);
		
		if(c == Color.BLACK)
			pNome.setCaretColor(Color.WHITE);
		
		pNome.setFont(new Font("Arial", Font.PLAIN, 12));
		cont.add(pNome);
		playerNameTextFields.add(pNome);
	}
	
	public Color adapataCor(String c) {
		if(c.compareTo("preto") == 0)
			return Color.BLACK;
		if(c.compareTo("branco") == 0)
			return Color.WHITE;
		if(c.compareTo("azul") == 0)
			return Color.BLUE;
		if(c.compareTo("verde") == 0)
			return Color.GREEN;
		if(c.compareTo("amarelo") == 0)
			return Color.YELLOW;
		if(c.compareTo("vermelho") == 0)
			return Color.RED;
		
		return null;
	}
	
	private String adaptaCor(Color c) {
		if(c == Color.BLACK)
			return "preto";
		if(c == Color.WHITE)
			return "branco";
		if(c == Color.BLUE)
			return "azul";
		if(c == Color.GREEN)
			return "verde";
		if(c == Color.YELLOW)
			return "amarelo";
		if(c == Color.RED)
			return "vermelho";
		
		return null;
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
	
	public void actionPerformed(ActionEvent e) { 
	    for(JTextField i: playerNameTextFields) {
	    	System.out.println(i.getText());
	    	Partida.getInstance().entraJogador(
	    			i.getText(), adaptaCor(i.getBackground()) );
	    }
	    Partida.getInstance().encerraCadastro();
	}
	
}
