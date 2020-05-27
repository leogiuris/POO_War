package MODEL;

public class Facade {
	
	static Board b = Board.getInstance();

	//esta função é chamada pelo Controller ao clicar num territorio,
	//então o indice do territorio virá com o clique no GUI.
	public static void JOG_AlocaExercitos(int index, int qtd) {
		Player p = Player.getJogadorDaVez();
		p.botarExercitos(Board.territorios[index], qtd);
	}
	
	public static void JOG_ComeçaJogada() {
		Player p = Player.getJogadorDaVez();
		p.IniciarJogada();
	}
	
	public static void JOG_CriaJogador(String nome, String cor) {
		new Player(nome,cor);
	}
	
	public static void JOG_Atacar(int i_origem, int i_destino, int qtd_tropas) {
		Player p = Player.getJogadorDaVez();
		p.Atacar(Board.territorios[i_origem], Board.territorios[i_destino], qtd_tropas);
	}
	
	public static boolean MAPA_FazFronteira(Territorio a, Territorio b){
		return Board.fazFronteira(a, b);
	}
	
	
	
	
	// TESTES
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
