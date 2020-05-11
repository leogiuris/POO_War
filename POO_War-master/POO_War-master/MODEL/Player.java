package MODEL;
import java.util.Random;

public class Player {
	String nome;
	Cor cor;
	int OrdemJogada;
	int numPlayers;
	CartaObjetivo Objetivo;
	CartaTerritorio lstTerritorio [];
	
	public enum Cor{
		branco,
		preto,
		azul,
		verde,
		amarelo,
		vermelho
	}
	
	Player(String nome,Cor cor){
		
	}
	
	int sorteioOrdemJogada(){
		Random random = new Random();
		int numero = random.nextInt(numPlayers);
		return numero;
	}
	
}
