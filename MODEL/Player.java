package MODEL;
import java.util.*;

public class Player {
	String nome;
	Cor cor;
	int qtd_jogadores = 0;
	int exercitosRodada;
	private CartaObjetivo objetivo;
	public List<CartaTerritorio> maoCartas = new ArrayList<CartaTerritorio>();
	public List<Territorio> territorios = new ArrayList<Territorio>();
	
	static public List<Player> jogadores = new ArrayList<Player>();
	static int maior = 0;
	static int numTroca;
	
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
		int num = sorteioOrdemJogada();
		objetivo = BaralhoObjetivo.sorteioObjetivo();
		if(num>=maior) {
			jogadores.add(0, this);
			maior = num;
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

	
	public void botarExercitosInit() {
		//ler lista de territorios, colocar 1 exercito em cada
		for(int i = 0; i<territorios.size(); i++) {
			territorios.get(i).botarExercito(new Exercito(cor));
		}
		
	}
	
	public void contarExercitosRodada() {
		int numContinente=0;
		//Exercitos comuns da rodada
		exercitosRodada = territorios.size()/2;
		//Percorre lista de territorios e compara com continentes
		for(int i = 0; i<6; i++) {
			for(int j = 0; i<territorios.size(); i++) {
				
				if(Board.continentes[i].territorios.get(j) ==  territorios.get(j)) {
					numContinente++;
				}
				if(numContinente == Board.continentes[i].territorios.size()) {
					exercitosRodada = exercitosRodada + Board.continentes[i].bonus;
				}
			}
		}
		//Troca de cartas
		if(maoCartas.size()>=3) {
			Scanner ent=new Scanner(System.in);
			System.out.println("Deseja fazer a troca de cartas?(Sim/Nao)"); 
			String troca=ent.nextLine();
			if(troca == "Sim") {
				//Falta selecionar cartas para trocar e remove-las da mao
				exercitosRodada = 4+2*(numTroca);
				numTroca++;
			}
		}
		
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
		System.out.println("objetivo:\t " + objetivo.objetivo); 
		System.out.println("Cartas de territorio:");
		for(int i = 0; i<territorios.size(); i++) {
			System.out.println("- " + territorios.get(i).nome + ", "+ territorios.get(i).exercitos.size() + " exercitos");
		}
	}
	
}
