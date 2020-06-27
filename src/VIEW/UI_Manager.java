package VIEW;

import java.awt.event.*;

import javax.swing.*;



import CONTROL.Partida;

public class UI_Manager {
	public MainFrame mf;

	
	public UI_Manager() {
		mf = new MainFrame();		

	}
	
	
	// falta implementar
	public void mostrarFimDialogo() {
		
		String[] mensagem = {Partida.getInstance().getInfoJogador(), "\nDeseja jogar novamente?"};
		String[] opcoes = {"Recomeçar", "Sair"};
		
		int returnVal = JOptionPane.showOptionDialog(null, mensagem, "Fim de Jogo",
				JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, null);
		
		if(returnVal == JOptionPane.YES_OPTION) {
			Partida.getInstance().Recomeçar();
		}
	}
	
	public void mostrarCadastro() {
		mf.cadastro();
	}
	
	
	public int inputDesloca() {
		String resp = JOptionPane.showInputDialog(null,
				"oi", "titulo", JOptionPane.INFORMATION_MESSAGE);
		
		if(resp == null)
			return 0;
		else
			return Integer.parseInt(resp);
	}
	
	public void refreshMain() {
		mf.refresh();
	}
	
	
}

