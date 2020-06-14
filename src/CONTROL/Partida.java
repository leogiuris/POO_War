package CONTROL;



import java.util.*;
import MODEL.Model;
import VIEW.*;
import GUI_TESTE.*;

public class Partida{
	static Scanner ent = new Scanner(System.in);
	static boolean temVencedor = false;
	private static Partida singleton = null;
	private Frame_simples frame;
	private MainFrame f;
	
	public boolean naoAgir = false;
	public Estado estado;
	public int t_orig = 99;
	public int t_dest = 99;
	public int qtd;
	
	public static Partida getInstance() {
		if(singleton == null) {
			Partida.singleton = new Partida();
		}
		return Partida.singleton;
	}
	
	public enum Estado{
		alocando,
		atac_origem,
		atac_destino,
		fim_origem,
		fim_destino
	}

	private Partida() {
		
		f = new MainFrame();
		f.init();
		teste1();
	}
	
	
	
	private int maxExercAtaque(int id_ter) {
		int qtd = Model.TER_getQtdExercitos(id_ter);
		if(qtd > 3) {
			return 3;
		}
		else {
			if(qtd>1)
				return qtd;
			else
				return 0;
		}
	}
	
	void CadastraJogadores() {
		frame = new Frame_simples();
		frame.PopCadastro();	
	}
	
	public void entraJogador(String nome, String cor) {
		if(cor == null || nome.compareTo("") == 0) {
			return;
		}

		Model.JOG_CriaJogador(nome, cor);
	}
	
	public void encerraCadastro() {
		Model.BART_SorteiaCartas();
		frame.PopTabuleiro();
	}
	
	
	public void clicouTerritorio(int id){
		
		if(naoAgir) {
			System.out.println("para de clicar");
			return;
		}
		
		if(estado == Estado.alocando) {
			if(!Model.JOG_possuiTerritorio(id))
				return;
			//tratar por GUI
			//System.out.println("digite a quantidade de exercitos que vai colocar:");
			//naoAgir = true;
			//int qtd = ent.nextInt();
			
			//System.out.println("digite a quantidade de exercitos a realocar:");
			//int qtd = ent.nextInt();
			
			//linha teste
			int qtd = 6;
			
			Model.JOG_AlocaExercitos(id, qtd);
			naoAgir = false;
			f.refresh();
			
			if(Model.JOG_qtdExercRodada() + Model.JOG_getTotalBonusCont() == 0) {
				estado = Estado.atac_origem;
				return;
			}
			return;
		}
		if(estado == Estado.atac_origem) {
			if(!Model.JOG_possuiTerritorio(id)) {
				System.out.println("nao possui territorio");
				return;
			}
			if(Model.TER_getQtdExercitos(id) < 2) {
				System.out.println("tropas insuficientes");
				return;
			}
			
			t_orig = id;
			estado = Estado.atac_destino;
			return;
		}
		if(estado == Estado.atac_destino) {
			if(Model.JOG_possuiTerritorio(id)) {
				System.out.println("territorio aliado");
				estado = Estado.fim_destino;
				clicouTerritorio(id);
				return;
			}
			t_dest = id;
			
			int qtd = maxExercAtaque(t_orig);
			Model.JOG_Atacar(t_orig, t_dest, qtd);
			estado = Estado.atac_origem;
			f.refresh();
			return;
		}
		if(estado == Estado.fim_origem) {
			if(!Model.JOG_possuiTerritorio(id)) {
				System.out.println("nao possui territorio");
				return;
			}
			
			t_orig = id;
			estado = Estado.fim_destino;
			return;
		}
		if(estado == Estado.fim_destino) {
			if(!Model.JOG_possuiTerritorio(id))
				return;
			
			naoAgir = true;
			t_dest = id;
			
			//System.out.println("digite a quantidade de exercitos a realocar:");
			//int qtd = ent.nextInt();
			
			//linha teste
			int qtd = Model.TER_getQtdExercitos(t_orig)/2;
			
			Model.JOG_moverExercitos(t_orig, t_dest, qtd);
			naoAgir = false;
			f.refresh();
			estado = Estado.fim_origem;
		}
	}
	
	
	public String getInfoJogador() {
		if(estado == Estado.alocando) {
			return ("tropas para distribuir: " + Model.JOG_qtdExercRodada());
		}
		if(estado == Estado.atac_origem) {
			return ("Escolha origem de ataque");
		}
		if(estado == Estado.atac_destino) {
			return ("Origem: " + Model.TER_getNome(t_orig));
		}
		if(estado == Estado.fim_origem) {
			return ("Realocando exercitos.\n" + "Selecione origem:" + "\n(não pode mais atacar)");
		}
		if(estado == Estado.fim_destino) {
			return ("Realocando exercitos.\n" + "Origem: " + Model.TER_getNome(t_orig) + "(não pode mais atacar)");
		}
		else
			return	"aaaa";
	}
	

	void MenuJogada() {
		
		Model.TESTE_jogadorVez();
		
		
		System.out.println("Selecione a sua ação:"
				+ "\n[1 - atacar oponente] [2 - passar a vez] [3 - salvar jogo]: ");
		
		int i = ent.nextInt();
		if(i == 1) {
			System.out.println("digite o indice do territorio escolhido:");
			int origem = ent.nextInt();
			if(!Model.JOG_possuiTerritorio(origem)) {
				MenuJogada();
				return;
			}
			
			Model.MAPA_imprimeVizinhos(origem);
			
			System.out.println("digite o indice do territorio a ser atacado:");
			int destino = ent.nextInt();
			
			int qtd = maxExercAtaque(origem);
			
			if(Model.TER_getQtdExercitos(origem) <= qtd) {
				System.out.println("ERRO - nao possui exercitos suficiente\n");
				MenuJogada();
				return;
			}
			
			Model.JOG_Atacar(origem, destino, qtd);
			f.refresh();
			
			if(Model.JOG_cumpriuObjetivo()) {
				temVencedor = true;
				return;
			}
			
			MenuJogada();
		}
		else if(i == 2){
			System.out.println("passou a vez...");
			Model.JOG_TerminaJogada();
			return;
		}
		else {
			Model.SAVE_salvarJogo();
			MenuJogada();
		}
	}
	
	void aloca() {
		System.out.println("--- Alocar Exercitos ---\n");
		//Scanner ent = new Scanner(System.in);
	
		System.out.println("digite o indice do territorio escolhido:");
		int i = ent.nextInt();
		
		
		// opção para pular jogadores (usar em testes)
		if(i > 42) {
			Model.JOG_TerminaJogada();
			return;
		}
		
		System.out.println("digite a quantidade de exercitos que vai colocar:");
		int qtd = ent.nextInt();
		
		Model.JOG_AlocaExercitos(i, qtd);
		//ent.close();
		
		return;
	}
	
	void Jogada() {
		System.out.println("\n\n\n------------- TURNO -------------\n");
		
		Model.JOG_ComeçaJogada();
		
		if(Model.JOG_cumpriuObjetivo()) {
			temVencedor = true;
			return;     
		}
		
		while(Model.JOG_qtdExercRodada() + Model.JOG_getTotalBonusCont() > 0) {
			Model.TESTE_jogadorVez();
			aloca();
			f.refresh();
			// o jogador pode passar a vez na fase de alocar
			// os exercitos, 
			if(!Model.JOG_jogando()) {
				Jogada();
			}
				
		}
		
		MenuJogada();	
	}
	
	void cicloGeral() {
		while(!temVencedor)
			Jogada();
		System.out.println("\nJogador " + Model.JOG_getNomeJogadorVez() + " é o vencedor!");
		System.out.println("\n\n\t----- FIM DE JOGO -----\n\n");
	}
	
	void teste1() {
		
		Model.TESTE_criaJogadores();
		Model.JOG_ComeçaJogada();
		Model.TESTE_jogadorVez();
		estado = Estado.alocando;
		f.refresh();
		
	}
	
	void teste2()  {
		
		Model.TESTE_criaJogadores();
		estado = Estado.alocando;
		f.refresh();
		
		while(!temVencedor) {
			System.out.println("Vez do jogador " + Model.JOG_getCor());
			Jogada();
		}
			
		System.out.println("\nJogador " + Model.JOG_getNomeJogadorVez() + " é o vencedor!");
		System.out.println("\n\n\t----- FIM DE JOGO -----\n\n");
	}
	
	
}
