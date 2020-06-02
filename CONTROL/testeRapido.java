package CONTROL;

import MODEL.*;
import java.util.*;

import MODEL.Facade;

public class testeRapido {

	static void RotinaInit() {
		entraJogadores();
		BaralhoTerritorio.sorteiaCartas();
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
			Facade.JOG_CriaJogador(nome, cor);
			n++;
		}
		ent.close();
		return;
	}	
	
	
	static void teste1() {
		RotinaInit();
		
		Facade.TESTE_jogadorVez();
		Facade.TESTE_imprimeBoard();
	}
	
	static void teste2()  {
		Facade.TESTE_criaJogadores();
		Facade.JOG_ComeçaJogada();
		Facade.TESTE_jogadorVez();		
		Facade.TESTE_imprimeBoard();
		
		Scanner ent = new Scanner(System.in);
		System.out.println("digite o indice do territorio escolhido:");
		int i = ent.nextInt();
		System.out.println("digite a quantidade de exercitos que vai colocar:");
		int qtd = ent.nextInt();
		
		Facade.JOG_AlocaExercitos(i, qtd);
		Facade.TESTE_jogadorVez();	
	}
	
	//public static void main(String[] args) {
		//teste2();
	//}		
}





