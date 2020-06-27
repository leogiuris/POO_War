package VIEW;

import javax.swing.*;

import CONTROL.Partida;
import MODEL.Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class MainFrame extends JFrame{
	
	static BoardPanel boardPanel = new BoardPanel();
	private CadastroPanel cadastroPanel = new CadastroPanel();
	private Tabuleiro tabuleiro = new Tabuleiro();
	
	public MainFrame() {
		 
		setTitle("War");
		setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.add(boardPanel);
		boardPanel.add(cadastroPanel);
		tabuleiro.carregaNodes();
		boardPanel.add(tabuleiro);
		
		//Insets ins=this.getInsets();
		//this.setSize(300+ins.left+ins.right,125+ins.top+ins.bottom);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);

	}  
	
	
	public void cadastro() {
		cadastroPanel.setVisible(true);
	}
	
	
	public void refresh() {
		tabuleiro.updateNodes();
		this.repaint();
	}


	
}
