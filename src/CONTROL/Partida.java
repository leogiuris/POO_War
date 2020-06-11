package CONTROL;

import java.util.*;
import MODEL.Model;
import VIEW.*;
import GUI_TESTE.*;

public class Partida {
	static Scanner ent = new Scanner(System.in);
	static boolean temVencedor = false;
	private static Partida singleton = null;
	private Frame_simples frame;
	
	
	public static Partida getInstance() {
		if(singleton == null) {
			Partida.singleton = new Partida();
		}
		return Partida.singleton;
	}
	
	private Partida() {
		teste1();
	}
	
	void CadastraJogadores() {
		frame = new Frame_simples();
		frame.PopCadastro();	
	}
	
	
	public void entraJogador(String nome, String cor) {
		if(cor == null || nome.compareTo("") == 0) {
			return;
		}

		Model.JOG_CriaJogador(nome, cor);
	}
	
	public void encerraCadastro() {
		Model.BART_SorteiaCartas();
		frame.PopTabuleiro();
		
		//cicloGeral();
	}
	
	void MenuJogada() {
		
		Model.TESTE_jogadorVez();
		
		
		System.out.println("Selecione a sua ação:"
				+ "\n[1 - atacar oponente] [2 - passar a vez] [3 - salvar jogo]: ");
		
		int i = ent.nextInt();
		if(i == 1) {
			System.out.println("digite o indice do territorio escolhido:");
			int origem = ent.nextInt();
			if(!Model.JOG_possuiTerritorio(origem)) {
				MenuJogada();
				return;
			}
			
			Model.MAPA_imprimeVizinhos(origem);
			
			System.out.println("digite o indice do territorio a ser atacado:");
			int destino = ent.nextInt();
			
			System.out.println("digite o numero de exercitos:\n");
			int qtd = ent.nextInt();
			if(Model.TER_getQtdExercitos(origem) <= qtd) {
				System.out.println("ERRO - nao possui exercitos suficiente\n");
				MenuJogada();
				return;
			}
			
			Model.JOG_Atacar(origem, destino, qtd);
			
			if(Model.JOG_cumpriuObjetivo()) {
				temVencedor = true;
				return;
			}
			
			MenuJogada();
		}
		else if(i == 2){
			System.out.println("passou a vez...");
			Model.JOG_TerminaJogada();
			return;
		}
		else {
			Model.SAVE_salvarJogo();
			MenuJogada();
		}
		
	}
	
	void aloca() {
		System.out.println("--- Alocar Exercitos ---\n");
		//Scanner ent = new Scanner(System.in);
	
		System.out.println("digite o indice do territorio escolhido:");
		int i = ent.nextInt();
		
		
		// opção para pular jogadores (usar em testes)
		if(i > 42) {
			Model.JOG_TerminaJogada();
			return;
		}
		
		System.out.println("digite a quantidade de exercitos que vai colocar:");
		int qtd = ent.nextInt();
		
		Model.JOG_AlocaExercitos(i, qtd);
		//ent.close();
		
		return;
	}
	
	void Jogada() {
		System.out.println("\n\n\n------------- TURNO -------------\n");
		
		Model.JOG_ComeçaJogada();
		
		if(Model.JOG_cumpriuObjetivo()) {
			temVencedor = true;
			return;
		}
		
		while(Model.JOG_qtdExercRodada() + Model.JOG_getTotalBonusCont() > 0) {
			Model.TESTE_jogadorVez();
			aloca();
			
			// o jogador pode passar a vez na fase de alocar
			// os exercitos, 
			if(!Model.JOG_jogando()) {
				Jogada();
			}
				
		}
		
		MenuJogada();	
	}
	
	void cicloGeral() {
		while(!temVencedor)
			Jogada();
		System.out.println("\nJogador " + Model.JOG_getNomeJogadorVez() + " é o vencedor!");
		System.out.println("\n\n\t----- FIM DE JOGO -----\n\n");
	}
	
	void teste1() {
		CadastraJogadores();
		
		

	}
	
	void teste2()  {
		
		Model.TESTE_criaJogadores();
		
		while(!temVencedor)
			Jogada();
		System.out.println("\nJogador " + Model.JOG_getNomeJogadorVez() + " é o vencedor!");
		System.out.println("\n\n\t----- FIM DE JOGO -----\n\n");
	}
	
	
}
