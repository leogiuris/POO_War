package CONTROL;


import java.util.*;

import MODEL.Model;

public class testeRapido {
	static Scanner ent = new Scanner(System.in);
	static boolean temVencedor = false;
	
	
	static void RotinaInit() {
		entraJogadores();
		Model.BART_SorteiaCartas();
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
	
	
	static void MenuJogada() {
		//Scanner ent = new Scanner(System.in);
		Model.TESTE_jogadorVez();
		
		
		System.out.println("Selecione a sua ação:\n[1 - atacar oponente] [2 - passar a vez]: ");
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
				//ent.close();
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
		
		MenuJogada();

	}
	
	
	static void aloca() {
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
	
	static void Jogada() {
		System.out.println("\n\n\n------------- TURNO -------------\n");
		
		Model.JOG_ComeçaJogada();
		
		if(Model.n_vez() == Model.JOG_getQtdJogadores())
			Model.SAVE_salvarJogo();
		
		if(Model.JOG_cumpriuObjetivo()) {
			temVencedor = true;
			return;
		}
		
		while(Model.JOG_qtdExercRodada() + Model.JOG_getTotalBonusCont() > 0) {
			Model.TESTE_jogadorVez();
			aloca();
			
			if(!Model.JOG_jogando()) {
				return;
			}
				
		}
		
		MenuJogada();	
	}
	
	
	
	
	static void teste1() {
		RotinaInit();
		
		Model.TESTE_jogadorVez();
		Model.TESTE_imprimeBoard();
	}
	
	static void teste2()  {
		//Scanner ent = new Scanner(System.in);
		Model.TESTE_criaJogadores();
		
		while(!temVencedor)
			Jogada();
		System.out.println("\nJogador " + Model.JOG_getNomeJogadorVez() + " é o vencedor!");
		System.out.println("\n\n\t----- FIM DE JOGO -----\n\n");
	}
	
	public static void main(String[] args) {
		teste2();

		ent.close();
	}		
}





