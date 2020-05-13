package MODEL;
import java.util.*;

public class Player {
	String nome;
	Cor cor;
	int qtd_jogadores = 0;
	int exercitosRodada = 0;
	private CartaObjetivo objetivo;
	public List<CartaTerritorio> maoCartas = new ArrayList<CartaTerritorio>();
	public List<Territorio> territorios = new ArrayList<Territorio>();
	public int[] bonusContinente = {0,0,0,0,0,0};
	
	static public List<Player> jogadores = new ArrayList<Player>();
	static int maior = 0;
	static int numTroca = 1;
	
	public enum Cor{
		branco,
		preto,
		azul,
		verde,
		amarelo,
		vermelho
	}
	public Cor getCor(String s) {
		if(s == "branco")
			return Cor.branco;
		if(s == "preto")
			return Cor.preto;
		if(s == "azul")
			return Cor.azul;
		if(s == "verde")
			return Cor.verde;
		if(s == "amarelo")
			return Cor.amarelo;
		if(s == "vermelho")
			return Cor.vermelho;
		else
			return null;
	}
	
	
//	CONSTRUTOR	
	public Player(String nome, String cor){
		this.nome = nome;
		this.cor = getCor(cor);
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

	public void botarExercitos(Territorio t, int qtd_tropas) {
		for (int i = 0; i < qtd_tropas; i++) {
			t.exercitos.add(new Exercito(cor));
		}
	}
	
	public void botarExercitosInit() {
		//ler lista de territorios, colocar 1 exercito em cada
		for(int i = 0; i<territorios.size(); i++) {
			botarExercitos(territorios.get(i), 1);
		}
	}

	private void verificaContinentes() {
		for(int i = 0; i<Board.continentes.length; i++) {
			if(Board.continentes[i].validaBonus(cor)) {
				bonusContinente[i] = Board.continentes[i].bonus;
			}
		}
	}

	public void trocarCartas() {
		//Falta selecionar cartas para trocar e remove-las da mao			
		exercitosRodada =+ 2+2*(numTroca);
		numTroca++;
		
		CartaTerritorio ret[] = {
				maoCartas.remove(0),
				maoCartas.remove(0),
				maoCartas.remove(0),
				};
		
		for(int i =0; i<ret.length; i++) {
			for(int j =0; j<territorios.size(); j++) {
				if(ret[i].territorio == territorios.get(j)) {
					botarExercitos(territorios.get(j), 1);
				}
			}
		}
	}
	
	public void contarExercitosRodada() {
		//Exercitos comuns da rodada
		exercitosRodada = territorios.size()/2;
		
		//Percorre lista de territorios e compara com continentes
		verificaContinentes();
		
		//Troca de cartas
		if(maoCartas.size()<3)
			return;
		
		Scanner ent=new Scanner(System.in);
		System.out.println("Deseja fazer a troca de cartas?(Sim/Nao)"); 
		String troca=ent.nextLine();
		if(troca == "s" || maoCartas.size()>=5) {
			trocarCartas();
		}
	}
	
//	------ FUNÇÕES DE TESTE ------
	public static void TESTE_criaJogadores() {
		System.out.println("--- TESTE CRIA JOGADORES ---");
		Player[] galera = {
				new Player("marcelinho", "amarelo"),
				new Player("joao", "preto"),
				new Player("maria", "azul"),
				new Player("jorge", "verde"),
				
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
		contarExercitosRodada();
		System.out.println("tropas a disposiçao:\t " + exercitosRodada + '\n');
		
		System.out.println("vai colocar todas as tropas no primeiro territorio...\n");		
		botarExercitos(territorios.get(0), exercitosRodada);
		
		System.out.println("Territorios:");
		for(int i = 0; i<territorios.size(); i++) {
			System.out.println("- " + territorios.get(i).nome + ", "+ territorios.get(i).exercitos.size() + " exercitos");
		}
		System.out.println();
	}
	
}
