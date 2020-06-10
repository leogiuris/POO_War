package VIEW;

import javax.swing.*;

import CONTROL.Partida;
import MODEL.Model;

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
		
		// Create table model
        //Model model = new Model();
        // Create controller
        //Partida controller = new Partida();
		
		this.add(boardPanel);
		//boardPanel.add(cadastroPanel);
		//Espera o submitButton do cadastroPanel
		//America do Sul
		tabuleiro.addNode("Venezuela",201,432);
		tabuleiro.addNode("Peru",239,489);
		tabuleiro.addNode("Argentina",275,552);
		tabuleiro.addNode("Brasil",285,453);
		//America do Norte
		tabuleiro.addNode("Mexico",146,359);
		tabuleiro.addNode("California",122,245);
		tabuleiro.addNode("Texas",167,266);
		tabuleiro.addNode("NovaYork",212,267);	
		tabuleiro.addNode("Vancouver",162,192);
		tabuleiro.addNode("Quebec",285,191);
		tabuleiro.addNode("Alasca",99,138);
		tabuleiro.addNode("Calgary",188,146);
		tabuleiro.addNode("Groenlandia",332,113);
		//Africa
		tabuleiro.addNode("Argelia",458,370);
		tabuleiro.addNode("Egito",567,386);
		tabuleiro.addNode("Angola",555,507);
		tabuleiro.addNode("Nigeria",528,432);
		tabuleiro.addNode("Somalia",620,486);
		tabuleiro.addNode("Africa do Sul",576,560);
		//Europa
		tabuleiro.addNode("Romenia",581,257);
		tabuleiro.addNode("Reino Unido",465,180);
		tabuleiro.addNode("Suecia",534,149);
		tabuleiro.addNode("Franca",488,246);
		tabuleiro.addNode("Espanha",452,282);
		tabuleiro.addNode("Italia",542,228);
		tabuleiro.addNode("Ucrania",600,231);
		tabuleiro.addNode("Polonia",576,203);
		//Asia
		tabuleiro.addNode("Estonia",677,141);
		tabuleiro.addNode("Russia",785,161);
		tabuleiro.addNode("Siberia",891,147);
		tabuleiro.addNode("Letonia",653,188);
		tabuleiro.addNode("Cazaquistao",836,222);
		tabuleiro.addNode("Turquia",719,245);
		tabuleiro.addNode("Mongolia",857,257);
		tabuleiro.addNode("Japao",950,273);
		tabuleiro.addNode("China",800,294);
		tabuleiro.addNode("Correia Do Norte",867,305);
		tabuleiro.addNode("Correia Do Sul",864,325);
		tabuleiro.addNode("Tailandia",885,413);
		tabuleiro.addNode("Bangladesh",852,369);
		tabuleiro.addNode("India",801,378);
		tabuleiro.addNode("Paquistao",750,318);
		tabuleiro.addNode("Ira",716,339);
		tabuleiro.addNode("Iraque",675,335);
		tabuleiro.addNode("Arabia Saudita",672,411);
		tabuleiro.addNode("Jordania",623,350);
		tabuleiro.addNode("Siria",678,285);
		//Oceania
		tabuleiro.addNode("Indonesia",896,495);
		tabuleiro.addNode("Nova Zelandia",936,633);
		tabuleiro.addNode("Perth",813,590);
		tabuleiro.addNode("Australia",870,609);
		
		boardPanel.add(tabuleiro);
	
		
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
