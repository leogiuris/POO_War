package GUI_TESTE;

import java.awt.*;
import javax.swing.*;


public class Frame_simples extends JFrame{
	int LARG_DEFAULT=410;
	int ALT_DEFAULT=450;
	CadastroPanel cadastro;
	Tabuleiro tabuleiro;
	
	
	public Frame_simples() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}
	
	public void PopCadastro() {
		cadastro = new CadastroPanel();
		getContentPane().add(cadastro);
		pack();
		setTitle("cadastro");
		setLayout(null);
		setVisible(true);
	}
	
	public void PopTabuleiro() {
		this.getContentPane().removeAll();
		tabuleiro = new Tabuleiro();
		getContentPane().add(tabuleiro);
		//pack();
		setTitle("WAR");
		setLayout(null);
		setVisible(true);
	}
	
	
}
