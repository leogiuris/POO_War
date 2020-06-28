package MODEL;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Model {
	
	static Board b = Board.getInstance();
	
	public static void Reiniciar() {	
		Player.ResetPlayers();	
		for(Territorio t: Board.territorios) {	
			t.resetTerritorio();	
		}	
		BaralhoTerritorio.criaCartas();	
	}
	
	// Salva os dados do jogo num arquivo .json
	public static void SAVE_salvarJogo(File f) {
		SaveData.saveGame(f);
	}
		
	public static void SAVE_carregarJogo(File f) {	
		SaveData.loadGame(f);
	}
	
	// Faz o jogador da vez colocar #qtd de exercitos em num territorio (pelo indice)
	public static void JOG_AlocaExercitos(int index, int qtd) {
		Player p = Player.getJogadorDaVez();
		p.botarExercitos(Board.territorios[index], qtd);
	}
	
	// Muda o estado do jogador da vez para JOGANDO, permitindo que realize açoes
	public static void JOG_ComeçaJogada() {
		Player p = Player.getJogadorDaVez();
		p.IniciarJogada();
	}
	
	public static String JOG_getCor() {
		return Player.getJogadorDaVez().getCor().toString();
	}
	
	public static String JOG_getCor(int i) {
		return Player.jogadores.get(i).getCor().toString();
	}
	
	public static int getNumJogada() {
		return Player.jogada;
	}
	
	public static int JOG_getQtdJogadores() {
		return Player.getNumJogadores();
	}
	
	public static List<Integer> JOG_getMaoCartas() {
		Player p = Player.getJogadorDaVez();
		List<Integer> l = new ArrayList<Integer>();
		for(CartaTerritorio ct: p.getMaoCartas()) {
			l.add(ct.id);
		}
		return l;
	}
	
	public static void JOG_trocaCartas(List<Integer> selecionadas) {
		Player p = Player.getJogadorDaVez();
		p.trocarCartas(selecionadas);
	}
	
	public static char JOG_getFormaCartaMao(int id) {
		Player p = Player.getJogadorDaVez();
		for(CartaTerritorio ct: p.maoCartas) {
			if(ct.id == id)
				return ct.getForma();
		}
		return 1;
	}
	
	//Retorna true se o jogador da vez possui o territorio 'id'
	public static boolean JOG_possuiTerritorio(int id) {
		for(Territorio t: Player.getJogadorDaVez().territorios) {
			if(t.id == id) {
				return true;
			}
		}
		return false;
	}
	
	// Adiciona uma instancia de jogador, automaticamente sorteando
	// sua posição na rodada.
	public static void JOG_CriaJogador(String nome, String cor) {
		new Player(nome,cor);
	}
	
	// Faz o jogador da vez atacar um territorio inimigo
	public static int[] JOG_Atacar(int i_origem, int i_destino, int qtd_tropas) {
		Player p = Player.getJogadorDaVez();
		return p.Atacar(Board.territorios[i_origem], Board.territorios[i_destino], qtd_tropas);
	}
	
	// Retorna o objetivo do jogador da vez
	public static String JOG_getObjetivo() {
		Player p = Player.getJogadorDaVez();
		return p.getObjetivo();
	}

	// Retorna o estado do jogador da vez (se está jogando ou não)
	// O jogador da vez pode não estar 'jogando' se não tiver chamado
	// a função JOG_ComeçaJogada()
	public static boolean JOG_jogando() {
		return Player.getJogadorDaVez().jogando;
	}
	
	public static String JOG_getNomeJogadorVez() {
		return Player.getJogadorDaVez().nome;
	}
	
	// Retorna o total de exercitos de BonusContinente
	// que restam para alocar
	public static int JOG_getTotalBonusCont() {
		int total = 0;
		for(int i: Player.getJogadorDaVez().bonusContinente) {
			total += i;
		}
		return total;
	}
	
	public static int[] JOG_getBonusCont() {
		return Player.getJogadorDaVez().bonusContinente;
	}
	
	public static void JOG_moverExercitos(int origem, int destino, int qtd) {
		Player.getJogadorDaVez().moverExercitos(Board.territorios[origem], 
														Board.territorios[destino], qtd);
	}
	
	public static boolean JOG_avaliaAtaque(int origem, int destino, int qtd_tropas) {
		 return Player.getJogadorDaVez().avaliaAtaque (	Board.territorios[origem], 
				 										Board.territorios[destino], 
				 										qtd_tropas );
	}
	
	//Jogador da vez passa a vez para o proximo
	public static void JOG_TerminaJogada() {
		Player.getJogadorDaVez().TerminarJogada();
	}
	
	//Retorna a quantidade de exercitos disponiveis
	//do jogador da vez
	//para distribuir entre os territorios.
	//(sem contar c o bonus por continente)
	public static int JOG_qtdExercRodada() {
		return Player.getJogadorDaVez().exercitosRodada;
	}
	
	//Retorna true se o jogador da vez cumpriu o objetivo
	public static boolean JOG_cumpriuObjetivo() {
		return Player.getJogadorDaVez().cumpriuObjetivo();
	}
	
	//Retorna a quantidade de exercitos em um territorio pelo id
	public static int TER_getQtdExercitos(int id) {
		return Board.territorios[id].getQtdExercitos();
	}
	
	public static int TER_getIDbyName(String nome){
		for(Territorio t: Board.territorios) {
			if(t.nome.compareTo(nome) == 0) {
				return t.id;
			}
		}
		return -1;
	}
	
	public static String TER_getNome(int id) {
		return Board.territorios[id].nome;
	}
	
	public static String TER_getCorDono(int id) {
		return Board.territorios[id].getCor().toString();
	}
	
	//Retorna o numero de jogadas desde o inicio
	//(começa com 0 e incrementa quando um jogador termina sua jogada)
	public static int n_vez() {
		return Player.jogada;
	}
	
	//Verifica se dois territorios fazem fronteira
	//Retorna true se fizerem
	public static boolean MAPA_FazFronteira(int a, int b){
		return Board.fazFronteira(Board.territorios[a], Board.territorios[b]);
	}
	
	//Função de teste.
	//Retorna todos os territorios vizinhos de 'index'
	public static void MAPA_imprimeVizinhos(int id) {
		Player p;
		
		System.out.println(">> Vizinhos:");
		for(Territorio t: Board.getVizinhos(Board.territorios[id])) {
			System.out.print("\t" + t.id + " - " + t.nome);
			if((p = t.getDono()) != Player.getJogadorDaVez()) {
				System.out.println(" - jogador " + p.getCor().toString());
			}
		}
		System.out.println("\n");
	}
	
	//sorteia e distribui as cartas entre os jogadores já cadastrados
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
