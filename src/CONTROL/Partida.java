package CONTROL;



import java.io.File;
import java.util.*;
import MODEL.Model;
import VIEW.*;


public class Partida{
	static Scanner ent = new Scanner(System.in);
	static boolean temVencedor = false;
	private static Partida singleton = null;

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
		cadastrando,
		alocando,
		atac_origem,
		atac_destino,
		fim_origem,
		fim_destino
	}
	
	private Partida() {
		estado = Estado.cadastrando;
		f = new MainFrame();
		f.init();
		//teste1();
	}
	
	
	
	private int maxExercAtaque(int id_ter) {
		int qtd = Model.TER_getQtdExercitos(id_ter);
		if(qtd > 3) {
			return 3;
		}
		else {
			if(qtd>1)
				return qtd - 1;
			else {
				System.out.println("Partida_ERRO - nao possui exerc suficiente");
				return 0;
			}
				
		}
	}
	
	
	public void entraJogador(String nome, String cor) {
		if(cor == null || nome.compareTo("") == 0) {
			return;
		}

		Model.JOG_CriaJogador(nome, cor);
	}
	
	public void encerraCadastro() {
		Model.BART_SorteiaCartas();
		Model.JOG_ComeçaJogada();
		estado = Estado.alocando;
		ChecaObjetivo();
		f.refresh();
	}
	
	public void carregaSave(File file) {
		
		Model.SAVE_carregarJogo(file);
		Model.JOG_ComeçaJogada();
		estado = Estado.alocando;
		ChecaObjetivo();
		f.refresh();
	}
	
	//função chamada por fora
	public void refresh() {
		f.refresh();
	}
	
 	public void clicouTerritorio(int id){
		
		if(naoAgir) {
			System.out.println("para de clicar");
			return;
		}
		
		if(estado == Estado.alocando) {
			if(!Model.JOG_possuiTerritorio(id))
				return;

			Model.JOG_AlocaExercitos(id, 1);
			naoAgir = false;

			f.alocaPanel(id);

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
			f.refresh();
			ChecaObjetivo();
			return;
		}
		
		if(estado == Estado.atac_destino) {
			if(id == t_orig) return;
			if(Model.JOG_possuiTerritorio(id)) {				
				System.out.println("territorio aliado");
				estado = Estado.fim_destino;
				clicouTerritorio(id);
				return;
			}
			t_dest = id;
			
			int qtd = maxExercAtaque(t_orig);
			
			if(qtd == 0)
				return;
			
			Model.JOG_Atacar(t_orig, t_dest, qtd);
			estado = Estado.atac_origem;
			f.refresh();
			ChecaObjetivo();
			return;
		}
		
		if(estado == Estado.fim_origem) {
			if(!Model.JOG_possuiTerritorio(id)) {
				System.out.println("nao possui territorio");
				return;
			}
			
			t_orig = id;
			estado = Estado.fim_destino;
			ChecaObjetivo();
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
	
	public void EncerrarJogada() {
		ChecaObjetivo();
		Model.JOG_TerminaJogada();
		
		Model.JOG_ComeçaJogada();
		estado = Estado.alocando;
		f.refresh();
	}
	
	public String getInfoJogador() {
		if(estado == Estado.alocando) {
			return ("Tropas para distribuir: " + Model.JOG_qtdExercRodada());
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
	
	
	public void ChecaObjetivo() {
		if(Model.JOG_cumpriuObjetivo())
			fim();
	}
	
	public void fim() {
		System.out.println("\nJogador " + Model.JOG_getNomeJogadorVez() + " é o vencedor!");
		System.out.println("\n\n\t----- FIM DE JOGO -----\n\n");
		return;
	}

	public void aloca(int i, int id) {
		Model.JOG_AlocaExercitos(id, i);
	}
	


	public void TESTE_CriaJogadores() {
		Model.TESTE_criaJogadores();
	}

}
