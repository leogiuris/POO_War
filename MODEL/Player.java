package MODEL;
import java.util.*;

public class Player {
	String nome;
	Cor cor;
	int qtd_jogadores = 0;
	public int ordemJogada = 0;   //  acho isso não devia estar nessa classe
	private CartaObjetivo objetivo;
	public List<CartaTerritorio> maoTer = new ArrayList<CartaTerritorio>();
	public List<Territorio> territorios = new ArrayList<Territorio>();
	
	static public List<Player> jogadores = new ArrayList<Player>();
	static int maior = 0;
	
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
		qtd_jogadores++;
		ordemJogada = sorteioOrdemJogada();
		objetivo = BaralhoObjetivo.sorteioObjetivo();
		if(ordemJogada>=maior) {
			jogadores.add(0, this);
			maior = ordemJogada;
		}
		else {
			jogadores.add(this);
		}
	}
	
	int sorteioOrdemJogada() {
		Random random = new Random();
		int numero = random.nextInt(6);
		return numero;
	}
	
	public static void TESTE_criaJogadores() {
		System.out.println("--- TESTE CRIA JOGADORES ---");
		Player[] galera = {
				new Player("marcelinho", Cor.amarelo),
				new Player("joao", Cor.preto),
				new Player("maria", Cor.azul)				
		};
		System.out.println("Ordem dos Jogadores:");
		
		for(int i = 0; i<jogadores.size(); i++) {
			System.out.println(i + " : " + jogadores.get(i).nome + "\tobjetivo: " + jogadores.get(i).objetivo.objetivo); 
		}
		System.out.println();
	}
	
	public void TESTE_Jogador() {
		System.out.println("--- TESTE JOGADOR ---");
		
		System.out.println("nome:\t " + nome);
		System.out.println("cor:\t " + cor);
		System.out.println("ordem:\t " + ordemJogada);
		System.out.println("objetivo:\t " + objetivo.objetivo); 
		System.out.println("Cartas de territorio:");
		for(int i = 0; i<maoTer.size(); i++) {
			System.out.println("- " + maoTer.get(i).territorio.nome);
		}
	}
	
}
