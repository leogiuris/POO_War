package MODEL;

public class Facade {

	
	static Board b = Board.getInstance();

	//esta fun��o � chamada pelo Controller ao clicar num territorio,
	//ent�o o indice do territorio vir� com o clique no GUI.
	public static void AlocaExercitos(int index, int qtd) {
		Player p = Player.getJogadorDaVez();
		p.botarExercitos(Board.territorios[index], qtd);
	}
	
	public static void Come�aJogada() {
		Player p = Player.getJogadorDaVez();
		p.IniciarJogada();
	}
	
	public static boolean fazFronteira(Territorio a, Territorio b){
		return Board.fazFronteira(a, b);
	}
	
	public static void criaJogador(String nome, String cor) {
		new Player(nome,cor);
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