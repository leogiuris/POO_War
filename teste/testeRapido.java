package teste;

import java.util.*;

import MODEL.*;

public class testeRapido {
	
	static void RotinaInit() {
		entraJogadores();
		BaralhoTerritorio.sorteiaCartas();
	}
	
	static void RotinaJogada(int i) {
		Player j = Player.jogadores.get(i);
		
		j.contarExercitosRodada();
		j.TESTE_JogadorVez();
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
			new Player(nome,cor);
			n++;
		}
		ent.close();
		return;
	}
	
	
	static void teste1() {
		

		new Player("jon", "verde");
		entraJogadores();
		
		BaralhoTerritorio.sorteiaCartas();
		
		Player.TESTE_Status_Jogadores();
		//Player.jogadores.get(0).TESTE_Jogador();
		Board.TESTE_imprimeBoard();
		
		return;
	}

	
	static void teste2()  {
		Board b = Board.getInstance();
		Player.TESTE_criaJogadores();
		Player p = Player.jogadores.get(0);
		p.TESTE_JogadorVez();
		
		Board.TESTE_imprimeBoard();
		Board.TESTE_imprimeFronteira(3);
	}
	
	
	public static void main(String[] args) {
		teste2();
	}
		
}
