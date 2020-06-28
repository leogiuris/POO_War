package CONTROL;



import java.io.File;
import java.util.*;
import MODEL.Model;
import VIEW.*;


public class Partida{
	
	private static Partida singleton = null;

	private UI_Manager ui;
	
	public boolean naoAgir = false;
	public Estado estado;
	
	public int t_orig = 99;
	public int t_dest = 99;
	public List<Integer> cartasTroca = new ArrayList<Integer>();
	public List<Integer> t_desloc = new ArrayList<Integer>();

	
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
		desloc_origem,
		desloc_destino,
		cartas,
		fim_jogo
	}
	
	private Partida() {
		estado = Estado.cadastrando;
		//f = new MainFrame();
		ui = new UI_Manager();
		
		//f.init();
		//teste1();
	}

	
	public void Recomeçar() {
		Model.Reiniciar();
		estado = Estado.cadastrando;
		ui.mostrarCadastro();
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
		ChecaObjetivo();
		estado = Estado.alocando;
		
		Model.TESTE_imprimeBoard();
		
		refresh();		
	}
	
	public void carregaSave(File file) {
		
		Model.SAVE_carregarJogo(file);
		//Model.JOG_ComeçaJogada();
		
		if((Model.JOG_getTotalBonusCont() + Model.JOG_qtdExercRodada()) > 0)
			estado = Estado.alocando;
		else
			estado = Estado.atac_origem;
		
		
		ChecaObjetivo();
		refresh();
	}
	
	public void refresh() {
		//f.refresh();
		ui.refreshMain();
	}
	
	public void cancelarAcao() {
		if(estado == Estado.atac_destino)
			estado = Estado.atac_origem;
		if(estado == Estado.desloc_destino)
			estado = Estado.desloc_origem;
		refresh();
	}
	
 	public void clicouTerritorio(int id){		
		
		if(estado == Estado.alocando) {
			if(!Model.JOG_possuiTerritorio(id))
				return;

			Model.JOG_AlocaExercitos(id, 1);

			//f.alocaPanel(id);

			refresh();
			
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
			refresh();
			ChecaObjetivo();
			return;
		}
		
		if(estado == Estado.atac_destino) {
			if(id == t_orig) return;
			if(Model.JOG_possuiTerritorio(id)) {				
				System.out.println("territorio aliado");
				return;
			}
			t_dest = id;
						
			int qtd = maxExercAtaque(t_orig);
			
			if(qtd == 0)
				return;
			
			if(!Model.JOG_avaliaAtaque(t_orig, t_dest, qtd))
				return;
			
			int[] a = Model.JOG_Atacar(t_orig, t_dest, qtd);
			estado = Estado.atac_origem;
			refresh();
			ChecaObjetivo();
			return;
		}
		
		if(estado == Estado.desloc_origem) {
			if(!Model.JOG_possuiTerritorio(id) || t_desloc.contains(id) || 
											Model.TER_getQtdExercitos(id)<=1) {
				refresh();
				return;
			}
			
			t_orig = id;
			estado = Estado.desloc_destino;
			refresh();
			ChecaObjetivo();
			return;
		}
		
		if(estado == Estado.desloc_destino) {
			if(!Model.JOG_possuiTerritorio(id) || !Model.MAPA_FazFronteira(t_orig, id)) {
				refresh();
				estado = Estado.desloc_origem;
				return;
			}
				
			int qtd = ui.inputDesloca();
			if(qtd == 0) {
				estado = Estado.desloc_origem;
				return;
			}
			
			t_desloc.add(id);
			t_dest = id;
			
			Model.JOG_moverExercitos(t_orig, t_dest, qtd);

			refresh();
			estado = Estado.desloc_origem;
		}
	}


	public void EncerrarJogada() {
		t_desloc.clear();
		ChecaObjetivo();
		Model.JOG_TerminaJogada();
		
		Model.JOG_ComeçaJogada();
		estado = Estado.alocando;

		refresh();
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
		if(estado == Estado.desloc_origem) {
			return ("Deslocando exercitos.");
		}
		if(estado == Estado.desloc_destino) {
			return ("Deslocando exercitos.\nOrigem: " + Model.TER_getNome(t_orig));
		}
		if(estado == Estado.fim_jogo) {
			return(Model.JOG_getNomeJogadorVez() + " venceu!\nObjetivo: " + Model.JOG_getObjetivo());
		}
		else
			return	"ERRO - getInfo";
	}
	
	public void ChecaObjetivo() {
		if(Model.JOG_cumpriuObjetivo())
			fim();
	}
	
	public void fim() {
		estado = Estado.fim_jogo;
		ui.mostrarFimDialogo();
		return;
	}

	public void aloca(int i, int id) {
		Model.JOG_AlocaExercitos(id, i);
	}
	


	public void TESTE_CriaJogadores() {
		Model.TESTE_criaJogadores();
	}

}
