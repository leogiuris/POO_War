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
		
		Player.jogadores.get(0).TESTE_Jogador();
		//BaralhoTerritorio.TESTE_imprimeBaralho();
	}
	
	
}
