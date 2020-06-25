package VIEW;

import java.awt.event.*;

import javax.swing.*;

public class UI_Manager {
	public MainFrame mf;
	public FimFrame ff;
	
	public UI_Manager() {
		mf = new MainFrame();
		ff = new FimFrame();
		
		mf.init();
	}
	
	
	// falta implementar
	public void mostrarFimDialogo() {
		//ff.setVisible(true);
	}
	
	public void refreshMain() {
		mf.refresh();
	}
	
	
}

class FimFrame extends JFrame{
	
	JButton novoJogo = new JButton();
	JButton sair = new JButton();
	JPanel painel = new JPanel();
	
	public FimFrame() {
		
		novoJogo.setText("Novo Jogo");
		sair.setText("Sair");
	    
	    //this.setVisible(true);

	    novoJogo.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent evt) {
	        	JOptionPane.showConfirmDialog(getParent(), "de novo");
	        	
	            //String name = JOptionPane.showInputDialog(getParent(),"What is your name?", null);
	        }
	    });
	    
	    this.add(novoJogo);
	    this.add(sair);
	    this.pack();
	}
	
    
	
}