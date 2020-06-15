package VIEW;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import CONTROL.Partida;
import java.util.*;

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
		pNome.setFont(new Font("Arial", Font.PLAIN, 12));
		cont.add(pNome);
		playerNameTextFields.add(pNome);
	}
	
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	}
	

	
	public void actionPerformed(ActionEvent e) { 
		
	    for(JTextField i: playerNameTextFields) {
	    	System.out.println(i.getText());
	    	Partida.getInstance().entraJogador(
	    			i.getText(), utils.adaptaCor(i.getBackground()) );
	    }
	    
	    /*
	    JComponent comp = (JComponent) e.getSource();
	    Window win = SwingUtilities.getWindowAncestor(comp);
	    win.dispose();
	    */
	    this.setVisible(false);
	    Partida.getInstance().encerraCadastro();
	}
	
}