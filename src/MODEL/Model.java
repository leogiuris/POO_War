package MODEL;

public class Model {
	
	static Board b = Board.getInstance();


	
	public static void JOG_AlocaExercitos(int index, int qtd) {
		Player p = Player.getJogadorDaVez();
		p.botarExercitos(Board.territorios[index], qtd);
	}
	
	public static void JOG_Come�aJogada() {
		Player p = Player.getJogadorDaVez();
		p.IniciarJogada();
	}
	
	public static void SAVE_salvarJogo() {
		SaveData.saveGame();
	}
	
	public static void JOG_CriaJogador(String nome, String cor) {
		new Player(nome,cor);
	}
	
	public static void JOG_Atacar(int i_origem, int i_destino, int qtd_tropas) {
		Player p = Player.getJogadorDaVez();
		p.Atacar(Board.territorios[i_origem], Board.territorios[i_destino], qtd_tropas);
	}
	
	public String JOG_getObjetivo() {
		Player p = Player.getJogadorDaVez();
		return p.getObjetivo();
	}

	public static boolean JOG_jogando() {
		return Player.getJogadorDaVez().jogando;
	}
	
	public static String JOG_getNomeJogadorVez() {
		return Player.getJogadorDaVez().nome;
	}
	
	public static int JOG_getTotalBonusCont() {
		int total = 0;
		for(int i: Player.getJogadorDaVez().bonusContinente) {
			total += i;
		}
		return total;
	}
	
	public static void JOG_TerminaJogada() {
		Player.getJogadorDaVez().TerminarJogada();
	}
	
	public static int JOG_qtdExercRodada() {
		return Player.getJogadorDaVez().exercitosRodada;
	}
	
	public static boolean JOG_cumpriuObjetivo() {
		return Player.getJogadorDaVez().cumpriuObjetivo();
	}
	
	public static int TER_getQtdExercitos(int i) {
		return Board.territorios[i].getQtdExercitos();
	}
	
	public static int n_vez() {
		return Player.jogada;
	}
	
	public static int JOG_getQtdJogadores() {
		return Player.getNumJogadores();
	}
	
	public static boolean JOG_possuiTerritorio(int index) {
		for(Territorio t: Player.getJogadorDaVez().territorios) {
			if(t.index == index) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean MAPA_FazFronteira(int a, int b){
		return Board.fazFronteira(Board.territorios[a], Board.territorios[b]);
	}
	
	public static void MAPA_imprimeVizinhos(int index) {
		Player p;
		
		System.out.println(">> Vizinhos:");
		for(Territorio t: Board.getVizinhos(Board.territorios[index])) {
			System.out.print("\t" + t.index + " - " + t.nome);
			if((p = t.getDono()) != Player.getJogadorDaVez()) {
				System.out.println(" - jogador " + p.getCor().toString());
			}
		}
		System.out.println("\n");
	}
	
	public static void BART_SorteiaCartas() {
		BaralhoTerritorio.sorteiaCartas();
	}
	
	
	// TESTES
	public static void TESTE_jogadorAlocaPrimeiroTer() {
		Player p = Player.getJogadorDaVez();
		p.botarExercitos(p.territorios.get(0), p.exercitosRodada);
	}
	
	public static void TESTE_jogadorVez() {
		Player.TESTE_Status_JogadorVez();
	}
	
	public static void TESTE_imprimeBoard() {
		Board.TESTE_imprimeBoard();
	}
	
	public static void TESTE_criaJogadores() {
		Player.TESTE_criaJogadores();
	}
}
