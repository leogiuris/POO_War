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
	
	boolean jogando = false;
	boolean conquistouTerritorio = false;
	
	static public List<Player> jogadores = new ArrayList<Player>();
	static int jogada = 0;
	static int maiorDado = 0;
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
	
	
//	CONSTRUTOR	
	public Player(String nome, String cor){
		this.nome = nome;
		this.cor = getCor(cor);
		qtd_jogadores++;
		int num = sorteioOrdemJogada();
		objetivo = BaralhoObjetivo.sorteioObjetivo();
		System.out.println(nome + " rolou... " + (num+1) ); 
		
		if(num>=maiorDado) {
			jogadores.add(0, this);
			maiorDado = num;
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

	
	
	
	
	//---------  FUNÇÕES ESTATICAS  ---------
	
	public static int getNumJogadores() {
		return jogadores.size();
	}
	
	public static Player getJogadorDaVez() {
		return jogadores.get(jogada%getNumJogadores());
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
	
	private void ReceberCarta() {
		//implementar
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
		if(troca == "s" || maoCartas.size()>=3) {
			trocarCartas();
		}
		ent.close();
	}
	
	public boolean playerAtaque(Territorio a, Territorio b){
		
		/*if(fazFronteira(a,b)) func do controller*/
		
		Dado Ataque = new Dado();
		Dado Defesa = new Dado();
		ArrayList<Integer> dadosAtaque = new ArrayList<Integer>();
		if(a.getQtdExercitos()<=4) {
			for(int i =0; i<=(a.getQtdExercitos()-1);i++) {
				dadosAtaque.add(Ataque.RolarDado()); 
			}
		}
		else {
			for(int i =0; i<=3;i++) {
				dadosAtaque.add(Ataque.RolarDado()); 
			}
		}
		ArrayList<Integer> dadosDefesa = new ArrayList<Integer>();
		if(b.getQtdExercitos()<=3)
			for(int i =0; i<=b.getQtdExercitos();i++) {
				dadosDefesa.add(Defesa.RolarDado()); 
			}
		else {
			for(int i =0; i<=3;i++) {
				dadosDefesa.add(Defesa.RolarDado()); 
			}
		}
		
		//dadosAtaque(0)= min
		Collections.sort(dadosAtaque);
		Collections.sort(dadosDefesa);
		
		//Remove exercitos dependendo do valor dos dados
		if(dadosAtaque.get(dadosAtaque.size() - 1)<=dadosDefesa.get(dadosDefesa.size() - 1)) {
			a.exercitos.remove(0);
		}
		else {
			b.exercitos.remove(0);
		}
		
		if(dadosAtaque.get(dadosAtaque.size() - 2)<=dadosDefesa.get(dadosDefesa.size() - 2)) {
			a.exercitos.remove(0);
		}
		else {
			b.exercitos.remove(0);
		}
		
		if(dadosAtaque.get(dadosAtaque.size() - 3)<=dadosDefesa.get(dadosDefesa.size() - 3) ) {
			a.exercitos.remove(0);
		}
		else {
			b.exercitos.remove(0);
		}
		//Conquista territorio
		if(b.getQtdExercitos()==0) {
			b.setCor(a.getCor());
			//Deslocamento de exercitos pos ataque
			Scanner ent=new Scanner(System.in);
			System.out.println("Deseja deslocar quantas unidades para territorio conquistado? (1,2,3)");
			int qtdExercito =ent.nextInt();
			for(int i =0;i<qtdExercito;i++) {
				b.botarExercito(a.exercitos.remove(0));
			}
			ent.close();
		}
		
		return (b.getQtdExercitos()==0);
		
	}
	

	
//	------ FUNÇÕES DE TESTE ------
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
	
	public void TESTE_Ataque() {
	
	}
	
}
