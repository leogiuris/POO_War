package VIEW;

import java.awt.Color;
import javax.swing.*;


public class Frame extends JFrame{
	
	JPanel	p;
	
	public 	Frame(String s,ListaImagens l) {
		super(s);
		p =	new Tabuleiro (l);
		p.setBackground(Color.WHITE);
		getContentPane().add(p);
		setSize(1600,1000);
	}
	
}
