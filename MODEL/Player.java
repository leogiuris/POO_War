package MODEL;
import java.util.*;

public class Player {
	String nome;
	Cor cor;
	int ordemJogada;
	BaralhoTerritorio Territorios;
	CartaObjetivo Objetivo;
	
	public enum Cor{
		branco,
		preto,
		azul,
		verde,
		amarelo,
		vermelho
	}
	
	Player(String nome, Cor cor){
		
		this.nome = nome;
		this.cor = cor;
		this.ordemJogada = sorteioOrdemJogada();
		
		BaralhoObjetivo barObj = new BaralhoObjetivo();
		this.Objetivo = barObj.sorteioObjetivo();
		
		BaralhoTerritorio barTer = new BaralhoTerritorio();
		this.Territorios = sorteioTerritorios();
		
	}
	
	int sorteioOrdemJogada() {
		int ordem[] = {1,2,3,4,5,6};
		int result;
		Random random = new Random();
		int numero = random.nextInt(5);
		
		if(ordem[numero]=!0) {
			result = ordem[numero];
			ordem[numero] = 0;
		}
		else {
			while(ordem[numero]==0) {
				numero++;
			}
			result = ordem[numero];
			ordem[numero] = 0;
		}
		
		return result;
	}
}
