package teste;

import java.util.Scanner;

import MODEL.*;

public class testeRapido {

	//PROBLEMA AQUI!
	static void entraJogadores() {
		Scanner ent=new Scanner(System.in);
		//cria novos jogadores ate q entrarem c o nome 0
		while(true && Player.jogadores.size() <= 6) {
			System.out.println("digite seu nome");
			String nome = ent.nextLine();
			System.out.println(nome);
			if(nome == "0") {
				ent.close();
				return;
			}
			System.out.println("digite a cor das suas peças");
			String cor = ent.nextLine();
			new Player(nome,cor);
		}
		
	}
	
	
	static void teste1() {
		Board board = new Board();
		//Dado d = new Dado();
		//board.TESTE_imprimeBoard();
		//d.TESTE_dado();
		//board.TESTE_imprimeFronteira(3);
		
		entraJogadores();
		BaralhoTerritorio.sorteiaCartas();
			
		Player.jogadores.get(0).TESTE_Jogador();
		board.TESTE_imprimeBoard();
		
		return;
	}

	
	static void teste2() {
		boolean fim = false;
		
		Board board = new Board();
		// cria jogadores
		
		//sorteia territorios
		BaralhoTerritorio.sorteiaCartas();
		//começam as rodadas
		while(!fim) {
			
		}
	}
	
	
	public static void main(String[] args) {
		teste1();
	}
	
	
}
