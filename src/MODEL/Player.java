package MODEL;
import java.util.*;

import VIEW.Tabuleiro;

public class Player {
	String nome;
	Cor cor;
	int qtd_jogadores = 0;
	int exercitosRodada = 0;
	private CartaObjetivo objetivo;
	public List<CartaTerritorio> maoCartas = new ArrayList<CartaTerritorio>();
	public List<Territorio> territorios = new ArrayList<Territorio>();
	public int[] bonusContinente = {0,0,0,0,0,0};
	
	boolean jogando = false;
	boolean conquistouTerritorio = false;
	
	static public List<Player> jogadores = new ArrayList<Player>();
	static int jogada = 0;
	static int maior = 0;
	static int numTroca = 1;
	
	public enum Cor{
		vazio,
		branco,
		preto,
		azul,
		verde,
		amarelo,
		vermelho
	}
	
	public Cor getCor(String s) {
		if(s.compareTo("vazio") == 0)
			return Cor.vazio;
		if(s.compareTo("branco") == 0)
			return Cor.branco;
		if(s.compareTo("preto") == 0)
			return Cor.preto;
		if(s.compareTo("azul") == 0)
			return Cor.azul;
		if(s.compareTo("verde") == 0)
			return Cor.verde;
		if(s.compareTo("amarelo") == 0)
			return Cor.amarelo;
		if(s.compareTo("vermelho") == 0)
			return Cor.vermelho;
		else
			return null;
	}
	
	public Cor getCor() {
		return this.cor;
	}
	
	
//	CONSTRUTOR	
	public Player(String nome, String cor){
		this.nome = nome;
		this.cor = getCor(cor);
		qtd_jogadores++;
		
		//sorteio da ordem
		Random r = new Random();
		int num = r.nextInt(6);
		
		objetivo = BaralhoObjetivo.sorteioObjetivo();
		System.out.println(nome + " rolou... " + (num+1) ); 
		
		if(num>=maior) {
			jogadores.add(0, this);
			maior = num;
		}
		else {
			jogadores.add(this);
		}
	}




	
	//---------  FUNÇÕES ESTATICAS  ---------
	
	public static int getNumJogadores() {
		return jogadores.size();
	}
	
	public static Player getJogadorDaVez() {
		return jogadores.get(jogada%getNumJogadores());
	}
	
	public static Player getJogadorPorCor(Cor c) {
		for (Player p : jogadores) {
			if(p.cor == c)
				return p;
		}
		System.out.println("ERRO - não ha jogador com essa cor");
		return getJogadorDaVez();
	}
	
	public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
	
	//--------- FUNÇÕES DO OBJETO -----------
	public void IniciarJogada() {
		jogando = true;
		conquistouTerritorio = false;
		contarExercitosRodada();
	}
	
	public void TerminarJogada() {
		if(conquistouTerritorio) {
			ReceberCarta();
		}
		jogando = false;
		jogada++;
	}
	

	
	
	
	
	public void Atacar(Territorio origem, Territorio destino, int qtd_tropas) {
		
		//verificar se fazem fronteira
		if(!Board.fazFronteira(origem, destino)) {
			System.out.println("ERRO - ataque invalido (nao fazem fronteira)");
			return;
		}
		
		//verificar se origem pertence ao jogador
		if(origem.getCor() != cor) {
			System.out.println("ERRO - territorio de origem nao pertence ao jogador");
		}
		
		//verificar se origem possui mais de um exercito
		if(origem.getQtdExercitos() <= qtd_tropas) {
			System.out.println("ERRO - ataque invalido (ataque nao possui exercitos suficiente)");
			return;
		}
		
		//verificar se destino pertence a outro jogador
		if(destino.getCor() == this.cor) {
			System.out.println("ERRO - ataque invalido (territorios do mesmo jogador)");
			return;
		}
		//verificar se qtd_tropas é menor que 3
		if(qtd_tropas > 3) {
			System.out.println("ERRO - ataque invalido (qtd_tropas > 3)");
			return;
		}
		
		//instanciar dados de acordo c qtd_tropas
		Dado []dadosAtaque = new Dado[qtd_tropas];
		Dado []dadosDefesa;
		if(destino.getQtdExercitos() > 3)
			dadosDefesa = new Dado[3];
		
		else
			dadosDefesa = new Dado[destino.getQtdExercitos()];
		
		//rolar dados ataque
		int [] valoresAtaque = new int[qtd_tropas];
		
		for (int i = 0; i < valoresAtaque.length; i++) {
			valoresAtaque[i] = dadosAtaque[i].RolarDado();
		}
		
		Arrays.sort(valoresAtaque);
		
		
		//rolar dados defesa
		int [] valoresDefesa = new int[qtd_tropas];
		
		for (int i = 0; i < valoresDefesa.length; i++) {
			valoresDefesa[i] = dadosDefesa[i].RolarDado();
		}
		
		Arrays.sort(valoresDefesa);
		
		//compara dados (parte mais importante)
		int tropasAvante = qtd_tropas;
		for (int i = 0; i < valoresDefesa.length && i < valoresAtaque.length; i++) {
			if(valoresAtaque[i] > valoresDefesa[i])
				destino.exercitos.remove(0);
			else {
				tropasAvante--;
				origem.exercitos.remove(0);
			}
		}
		
		//caso conquiste o territorio inimigo
		if(destino.getCor() == Cor.vazio) {
			conquistouTerritorio = true;
			moverExercitos(origem,destino,tropasAvante);
		}
		
	}
	
	public void ReceberCarta() {
		if(conquistouTerritorio)
			maoCartas.add(BaralhoTerritorio.pegarCarta());
	}
	
	public void botarExercitos(Territorio t, int qtd_tropas) {
		
		int iBonus = getBonusIndex(t);
		
		if((qtd_tropas > exercitosRodada + bonusContinente[iBonus]) || !t.validaCor(cor)) {
			System.out.print("Erro entrada botarExercitos");
			return;
		}
		
		for (int i = 0; i < qtd_tropas; i++) {
			
			if( !t.botarExercito(new Exercito(cor)) ) {
				System.out.println("Erro ao posicionar tropa");	
			}
			
			if(exercitosRodada + bonusContinente[iBonus] <= 0) {
				return;
			}
			
			if(exercitosRodada <= 0) {
				System.out.println("entrou aqui");
				bonusContinente[iBonus]--;
			}
			else
				exercitosRodada--;
		}
	}
	
	public void moverExercitos(Territorio a, Territorio b, int qtd) {
		for (int i = 0; i < qtd; i++) {
			b.exercitos.add(a.exercitos.remove(0));
		}
	}
	
	private int getBonusIndex(Territorio t) {
		for (int i = 0; i < bonusContinente.length; i++) {
			if(t.continente == Board.continentes[i]) {
				return i;
			}
		}
		System.out.print("ERRO_getBonusCont");
		return 0;
	}
	
	public void botarExercitosInit() {
		//ler lista de territorios, colocar 1 exercito em cada
		for(int i = 0; i<territorios.size(); i++) {
			exercitosRodada++;
			botarExercitos(territorios.get(i), 1);
		}
	}

	private void verificaContinentes() {
		for(int i = 0; i<Board.continentes.length; i++) {
			if(Board.continentes[i].validarBonus(cor)) {
				bonusContinente[i] = Board.continentes[i].bonus;
				System.out.println("possui " + Board.continentes[i].nome);		
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
		ent.close();
	}
	
	public String getObjetivo() {
		return this.objetivo.objetivo;
	}
	
	
	
//	--------- FUNÇÕES DE TESTE ----------
	public static void TESTE_criaJogadores() {
		System.out.println("--- TESTE CRIA JOGADORES ---");

		new Player("marcelo", "amarelo");
		new Player("joao", "vermelho");
		new Player("maria", "azul");
		new Player("jorge", "verde");

		BaralhoTerritorio.sorteiaCartas();
		System.out.println("Ordem dos Jogadores:");
		
		for(int i = 0; i<jogadores.size(); i++) {

			System.out.println((i+1) + " : " + jogadores.get(i).nome + "\tcor: " + jogadores.get(i).cor + "\tobjetivo: " + jogadores.get(i).objetivo.objetivo); 

		}
		System.out.println("Territorios sorteados...");
		
		System.out.println();
	}
	
	public static void TESTE_Status_JogadorVez() { 
		System.out.println("--- Jogador da Vez ---");

		Player p = jogadores.get(0);
		System.out.println("-> " + p.nome);
		System.out.println("cor:\t " + p.cor);
		System.out.println("objetivo:\t " + p.objetivo.objetivo); 
		
		//p.contarExercitosRodada();
		System.out.println("tropas a disposiçao:\t " + p.exercitosRodada + '\n');
		
		//System.out.println("vai colocar todas as tropas no primeiro territorio...\n");		
		//p.botarExercitos(p.territorios.get(0), p.exercitosRodada);
		
		System.out.println("Territorios:");
		for(int i = 0; i<p.territorios.size(); i++) {
			System.out.println("- " + p.territorios.get(i).nome + ", "+ p.territorios.get(i).exercitos.size() + " exercitos");
		}
	}
	
	static public void TESTE_Status_Jogadores() {
		for(Player p: jogadores) {
			System.out.println("--- Jogadores ---");
			
			System.out.println("-> " + p.nome);
			System.out.println("cor:\t " + p.cor);
			System.out.println("objetivo:\t " + p.objetivo.objetivo); 
			System.out.println("territorios:\t " + p.territorios.size()); 
			
			System.out.println("tropas a disposiçao:\t " + p.exercitosRodada + '\n');
		}
		System.out.println("É a vez de " + jogadores.get(0).nome);
	}

	public void TESTE_PrimeiroJogador() {
		System.out.println("--- TESTE PRIMEIRO JOGADOR ---");
		
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
