package teste;

import MODEL.*;

public class testeRapido {

	
	public static void main(String[] args) {
		Board board = new Board();
		//Dado d = new Dado();
		//board.TESTE_imprimeBoard();
		//4 d.TESTE_dado();
		//board.TESTE_imprimeFronteira(3);
		Player.TESTE_criaJogadores();
		BaralhoTerritorio.sorteiaCartas();
		for(int i = 0; i < Player.jogadores.size(); i++) {
			Player.jogadores.get(i).botarExercitosInit();
		}
			
		Player.jogadores.get(0).TESTE_Jogador();
		//BaralhoTerritorio.TESTE_imprimeBaralho();
	}
	
	
}
