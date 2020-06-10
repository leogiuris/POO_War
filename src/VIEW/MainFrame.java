package VIEW;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class MainFrame extends JFrame{
	
	private BoardPanel boardPanel = new BoardPanel();
	private CadastroPanel cadastroPanel = new CadastroPanel();
	private Tabuleiro tabuleiro = new Tabuleiro();
	
	public MainFrame() {
		 
		setTitle("War");
		setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(boardPanel);
		boardPanel.add(cadastroPanel);
		//Espera o submitButton do cadastroPanel
		//boardPanel.add(tabuleiro);
		
	}  
	
	// Teste
	public static void main(String[] args) {
		MainFrame f=new MainFrame();
		Insets ins=f.getInsets();
		f.setSize(300+ins.left+ins.right,125+ins.top+ins.bottom);
		
		f.pack();
		f.setVisible(true);
	}
	
}
