package MODEL;
import java.util.*;


class Player {
	String nome;
	Cor cor;
	Player quemEliminou;
	int qtd_jogadores = 0;
	int exercitosRodada = 0;
	private CartaObjetivo objetivo;
	public List<CartaTerritorio> maoCartas = new ArrayList<CartaTerritorio>();
	public List<Territorio> territorios = new ArrayList<Territorio>();
	public int[] bonusContinente = {0,0,0,0,0,0};
	
	boolean eliminado = false;
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
	
	static public Cor getCor(String s) {
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
		
		//sorteio da ordem
		Random r = new Random();
		int num = r.nextInt(6);
		
		objetivo = CartaObjetivo.sorteioObjetivo(this);
		
		
		System.out.println(nome + " rolou... " + (num+1) ); 
		
		if(num>=maior) {
			jogadores.add(0, this);
			maior = num;
		}
		else {
			jogadores.add(this);
		}
	}

	private Player() {	}


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
		System.out.println("Não ha jogador dessa cor");
		return null;
	}
	
	public static void ResetPlayers() {
		jogadores.clear();
	}
	
	public static void loadJogador(String[] data, boolean[] estado, int[] tropas_d, int jogada_d, 
			int ordem, List<Integer> s_territorios, List<Integer> tropas_t, List<Integer> idCartasT ) {
		
		Player p = new Player();
		jogadores.add(ordem, p);
		jogada = jogada_d;
		p.nome = data[0];
		p.cor = getCor(data[1]);
		p.objetivo = CartaObjetivo.loadCarta(data[2]);
		
		p.eliminado = estado[0];
		p.jogando = estado[1];
		p.conquistouTerritorio = estado[2];
		
		if(s_territorios.isEmpty()) {
			p.eliminado = true;
			p.quemEliminou = null;
			return;
		}
		
		for(int i = 0; i< tropas_d.length; i++) {
			if(i == 0) {
				p.exercitosRodada = tropas_d[i];
			}
			else
				p.bonusContinente[i-1] = tropas_d[i];
		}
		
		for(Integer id: s_territorios) {
			Territorio t = Board.territorios[id];
			t.resetTerritorio();
			p.territorios.add(t);
			int qtd = tropas_t.remove(0);
			t.botarExercito(new Exercito(p.cor), qtd);
		}
		
		for(Integer id: idCartasT) {
			p.maoCartas.add(BaralhoTerritorio.loadCarta(id));
		}
		
		System.out.println("terminou loadJogador");
		
	}
	
	
	//--------- FUNÇÕES DO OBJETO -----------
 	public void IniciarJogada() {
		if(eliminado == true){
			TerminarJogada();
			return;
		}
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
		
		//getJogadorDaVez().IniciarJogada();
	}
	
	public boolean cumpriuObjetivo() {
		return objetivo.cumpriuObjetivo();
	}
		
	public void Atacar(Territorio origem, Territorio destino, int qtd_tropas) {
		
		//verificar se fazem fronteira
		if(!Board.fazFronteira(origem, destino)) {
			System.out.println("Player_ERRO - ataque invalido (nao fazem fronteira)");
			return;
		}
		
		//verificar se origem pertence ao jogador
		if(origem.getCor() != cor) {
			System.out.println("Player_ERRO - territorio de origem nao pertence ao jogador");
		}
		
		//verificar se origem possui mais de um exercito
		if(origem.getQtdExercitos() <= qtd_tropas) {
			System.out.println("Player_ERRO - ataque invalido (ataque nao possui exercitos suficiente)");
			return;
		}
		
		//verificar se destino pertence a outro jogador
		if(destino.getCor() == this.cor) {
			System.out.println("Player_ERRO - ataque invalido (territorios do mesmo jogador)");
			return;
		}
		
		Player oponente = destino.getDono();
		int qtd_def = destino.getQtdExercitos();
		//verificar se qtd_tropas é menor que 3
		if(qtd_tropas > 3) {
			System.out.println("ERRO - (qtd_tropas > 3)");
			qtd_tropas = 3;
		}
		
		//instanciar dados de acordo c qtd_tropas
		Dado []dadosAtaque = new Dado[qtd_tropas];
		Dado []dadosDefesa;
		if(qtd_def > 3) {
			dadosDefesa = new Dado[3];
			qtd_def = 3;
		}
			
		else
			dadosDefesa = new Dado[qtd_def];

		
		//rolar dados ataque
		int [] valoresAtaque = new int[qtd_tropas];
		
		for (int i = 0; i < valoresAtaque.length; i++) {
			dadosAtaque[i] = new Dado();
			
			valoresAtaque[i] = dadosAtaque[i].RolarDado();
		}
		
		Arrays.sort(valoresAtaque);
		
		
		//rolar dados defesa
		int [] valoresDefesa = new int[qtd_def];
		
		for (int i = 0; i < valoresDefesa.length; i++) {
			dadosDefesa[i] = new Dado();
			valoresDefesa[i] = dadosDefesa[i].RolarDado();
		}
		
		Arrays.sort(valoresDefesa);
		
		//compara dados (parte mais importante)
		int tropasAvante = qtd_tropas;
		System.out.println("\n\nATAQUE\tDEFESA");
			
		for (int i = 0, j = 0; !destino.exercitos.isEmpty() && i < valoresAtaque.length; i++) {
			

			
			if(i<valoresDefesa.length)
				System.out.println(valoresAtaque[i] + "\t" + valoresDefesa[i]);
			else
				System.out.println(valoresAtaque[i]); 
			
			if(valoresAtaque[i] > valoresDefesa[j]) {
				destino.exercitos.remove(0);
				j++;
			}
			else {
				tropasAvante--;
				origem.exercitos.remove(0);
			}
		}
		
		//caso conquiste o territorio inimigo
		if(destino.getCor() == Cor.vazio) {
			System.out.println("\n(conquistou territorio!)\n\n");
			conquistouTerritorio = true;
			
			//q linha horrivel
			territorios.add(oponente.territorios.remove(oponente.territorios.indexOf(destino)));
			moverExercitos(origem,destino,tropasAvante);
		}
		else {
			System.out.println("\n(nao conquistou)\n\n");
		}
		
		//caso elimine um jogador
		if(oponente.territorios.isEmpty()) {
			Eliminar(oponente);
		}
		

		
	}
	
 	public void Eliminar(Player p) {
		p.quemEliminou = this;
		p.eliminado = true;
	}
	
	public void ReceberCarta() {
		if(conquistouTerritorio) {
			CartaTerritorio c = BaralhoTerritorio.pegarCarta();
			maoCartas.add(c);
			
			System.out.println("recebeu carta:\n- " + c.id + " " + c.forma.name());
		}
			
	}
	
	public void botarExercitos(Territorio t, int qtd_tropas) {
		// o jogador possui dois fundos de onde pode tirar tropas:
		// - as que ganha toda rodada;
		// - as que ganha de bonus por continente conquistado
		
		int iBonus = getBonusIndex(t);
		
		if((qtd_tropas > exercitosRodada + bonusContinente[iBonus]) || !t.validaCor(cor)) {
			System.out.println("Erro entrada botarExercitos\nnome: " 
		+ this.nome + "\nterritorio: " + t.nome + "\nqtd: " + qtd_tropas + "\n");
			//TESTE_Status_JogadorVez();
			return;
		}
		
		// apos verificar que possui tropas suficiente;
		
		// Para cada tropa disponivel, o jogador aloca para o novo territorio
		// e decide de onde vai tirar as tropas
		for (int i = 0; i < qtd_tropas; i++) {
			
			if( !t.botarExercito(new Exercito(cor)) ) {
				System.out.println("Erro ao posicionar tropa");	
			}
			
			if(exercitosRodada + bonusContinente[iBonus] <= 0) {
				return;
			}
			
			if(bonusContinente[iBonus] > 0) {
				System.out.println("usou bonus continente");
				bonusContinente[iBonus]--;
			}
			else
				exercitosRodada--;
		}
	}
	
	public void moverExercitos(Territorio a, Territorio b, int qtd) {
		if(!Board.fazFronteira(a, b)) {
			System.out.println("Player_ERRO - territorios nao fazem fronteira");
			return;
		}
		
		if(qtd >= a.getQtdExercitos()) {
			System.out.println("Player_ERRO - territorios nao fazem fronteira");
			return;
		}
		
		for (int i = 0; i < qtd; i++) {
			b.exercitos.add(a.exercitos.remove(0));
		}
	}
	
	public int getBonusIndex(Territorio t) {
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
		
		for (int i = 0; i < ret.length; i++) {
			
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
		
		//Scanner ent=new Scanner(System.in);
		//System.out.println("Deseja fazer a troca de cartas?(Sim/Nao)"); 
		//String troca=ent.nextLine();
		//if(troca == "s" || maoCartas.size()>=5) {
		//	trocarCartas();
		//}
		//ent.close();
	}
	
	public String getObjetivo() {

		return this.objetivo.descricao.toString();

	}
	
	public Cor getCor() {
		return this.cor;
	}
	
//	--------- FUNÇÕES DE TESTE ----------
	public static void TESTE_criaJogadores() {
		System.out.println("--- TESTE CRIA JOGADORES ---");

		new Player("marcelo", "branco");
		new Player("joao", "vermelho");
		new Player("maria", "preto");
		new Player("jorge", "verde");

		//BaralhoTerritorio.criaCartas();
		//BaralhoTerritorio.sorteiaCartas();
		System.out.println("Ordem dos Jogadores:");
		
		for(int i = 0; i<jogadores.size(); i++) {

			System.out.println((i+1) + " : " + jogadores.get(i).nome 
					+ "\tcor: " + jogadores.get(i).cor
					+ "\tobjetivo: " + jogadores.get(i).objetivo.descricao); 

		}
				
		System.out.println();
	}
	
	public static void TESTE_Status_JogadorVez() { 
		System.out.println("--- Jogador da Vez ---");

		Player p = Player.getJogadorDaVez();
		System.out.println("-> " + p.nome);
		System.out.println("cor:\t " + p.cor);
		System.out.println("objetivo:\t " + p.objetivo.descricao); 
		
		//p.contarExercitosRodada();
		System.out.println("tropas para distribuir:\t " + p.exercitosRodada + '\n');
		System.out.println("bonus por continente:\n"
				+ "AM_SUL - " + p.bonusContinente[0] + '\t' + "AM_NORTE - " + p.bonusContinente[1] + '\n'
				+ "AFRICA - " + p.bonusContinente[2] + '\t' + "EUROPA - " + p.bonusContinente[3] + '\n'
				+ "ASIA - " + p.bonusContinente[4] + '\t' + "OCEANIA - " + p.bonusContinente[5] + '\n');
		
		
		
		System.out.println("Territorios:");
		for(int i = 0; i<p.territorios.size(); i++) {
			
			System.out.println(p.territorios.get(i).id 
					+ " - " + p.territorios.get(i).nome
					+ ", "+ p.territorios.get(i).exercitos.size()
					+ " exercitos");
		}
		System.out.println("\n");
	}
	
	static public void TESTE_Status_Jogadores() {
		for(Player p: jogadores) {
			System.out.println("--- Jogadores ---");
			
			System.out.println("-> " + p.nome);
			System.out.println("cor:\t " + p.cor);
			System.out.println("objetivo:\t " + p.objetivo.descricao); 
			System.out.println("territorios:\t " + p.territorios.size()); 
			
			System.out.println("tropas a disposiçao:\t " + p.exercitosRodada + '\n');
		}
		System.out.println("É a vez de " + jogadores.get(0).nome);
	}

	public void TESTE_PrimeiroJogador() {
		System.out.println("--- TESTE PRIMEIRO JOGADOR ---");
		
		System.out.println("nome:\t " + nome);
		System.out.println("cor:\t " + cor);
		System.out.println("objetivo:\t " + objetivo.descricao); 
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
