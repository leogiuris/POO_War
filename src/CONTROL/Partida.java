package CONTROL;

import java.util.Scanner;

import MODEL.Model;
import VIEW.*;

public class Partida {
	
	private static Partida instance;
	private MainFrame mainFrame;
	
	public static Partida getInstance() {
		if(Partida.instance == null)
			Partida.instance = new Partida();
		return Partida.instance;
	}
	
	
	private void RotinaInit() {	
		//mainFrame = new MainFrame();
		MainFrame.Exemplo();
		//Facade.BART_SorteiaCartas();
	}	
	
	private Partida() {
		RotinaInit();
	}
	
	static void entraJogadores() {
		 Scanner ent = new Scanner(System.in);
		 int n = 0;
		 System.out.println("('0' para terminar de lançar jogadores)\n");
		//cria novos jogadores ate q entrarem c o nome 0
		while(true && n < 6) {
			System.out.println("digite seu nome");
			String nome = ent.nextLine();
			if(nome.compareTo("0") == 0) {
				break;
			}
			System.out.println("digite a cor das suas peças (branco/verde/azul/preto/vermelho/amarelo");
			String cor = ent.nextLine();
			if(cor.compareTo("0") == 0) {
				break;
			}
			Model.JOG_CriaJogador(nome, cor);
			n++;
		}
		ent.close();
		return;
	}
}
