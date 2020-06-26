package VIEW;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import CONTROL.Partida;
import CONTROL.Partida.Estado;
import MODEL.Model;

/*
	Essa classe contém o mapa e a maioria dos botoes
	e informações que compoem o UI do jogo.

*/

public class BoardPanel extends JPanel{
	private Image bg;
	private Image mapa;
	//private Image obj;
	private boolean mostraObj = false;
	Dimension textDimension = new Dimension(100, 30);
	
	JButton pVez = new JButton("Passar Vez"); 
	JButton vObjetivo = new JButton("Objetivo"); 
	JButton salvar = new JButton("Salvar");
	JButton deslocar = new JButton("Deslocar Tropas");
	JButton cancelar = new JButton("Voltar");
	JButton passar = new JButton("Voltar");
	
	Dimension MapaDimension = new Dimension(1024, 768);
	
	public BoardPanel() {
		Toolkit tk=Toolkit.getDefaultToolkit();
		Font font = new Font("Roboto", Font.PLAIN, 14);
		this.setFont(font);
		this.setLayout(null);
		mapa = tk.getImage("./images/war_tabuleiro_mapa_copy.png");
		bg = tk.getImage("./images/war_tabuleiro_fundo.png");
		this.setMaximumSize(MapaDimension);
		this.setMinimumSize(MapaDimension);
		this.setPreferredSize(MapaDimension);		
		
		vObjetivo.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 Partida.getInstance().ChecaObjetivo();
				 if(!mostraObj)
					 mostraObj = true;
				 else
					 mostraObj = false;
				 Partida.getInstance().refresh();
			 }
		});	
		vObjetivo.setBounds(150, 65, 90, 20);
		this.add(vObjetivo);		
		 
		pVez.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				Partida.getInstance().EncerrarJogada();
				mostraObj = false;
			 }
		});
		pVez.setBounds(130, 675, 150, 50);
		this.add(pVez);
		
		salvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser("./saves");

				int returnVal = fc.showSaveDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
			        try {
			        	Model.SAVE_salvarJogo(fc.getSelectedFile());
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
			    }
			}
		});
		salvar.setBounds(20, 675, 100, 50);
		this.add(salvar);
		
		deslocar.addActionListener(new ActionListener() {
			
			 public void actionPerformed(ActionEvent e) {
				Partida.getInstance().estado = Estado.desloc_origem;
				mostraObj = false;
				Partida.getInstance().refresh();
			 }
		});
		deslocar.setBounds(130, 675, 150, 50);
		this.add(deslocar);
		
		cancelar.addActionListener(new ActionListener() {
			
			 public void actionPerformed(ActionEvent e) {
				Partida.getInstance().cancelarAcao();
			 }
		});
		cancelar.setBounds(130, 675, 100, 50);
		cancelar.setBackground(Color.red.brighter().brighter().brighter().brighter());
		this.add(cancelar);
		
		
	}
	

	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Font font = new Font("Roboto", Font.PLAIN, 14);
		this.setFont(font);
		
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(mapa, 0, 0, getWidth(), getHeight(), this);
	
		g.setColor(Color.black);

		Partida p = Partida.getInstance();
		
		
		vObjetivo.setVisible(!(p.estado == Estado.cadastrando));
		salvar.setVisible(!(p.estado == Estado.cadastrando));
		deslocar.setVisible((p.estado == Estado.atac_origem));
		cancelar.setVisible(p.estado == Estado.atac_destino || 
							p.estado == Estado.desloc_destino);
		pVez.setVisible(p.estado == Estado.alocando ||
						p.estado == Estado.desloc_origem);
			
		if(p.estado == Estado.cadastrando)
			return;
		
		
		g.setColor(Color.white);		
		g.fillRect(10, 10, 250, 80);
		g.setColor(Color.black);
		// informações gerais do jogador
		g.drawString("Vez de " + Model.JOG_getNomeJogadorVez(), 20, 30);
		String str = p.getInfoJogador();
		
		g.drawString(str, 20, 45);
		if(mostraObj) {
			g.drawString(Model.JOG_getObjetivo().replace('_', ' '),20, 60);
			
		}
		
		//cor do jogador da vez
		g.setColor(utils.adapataCor(Model.JOG_getCor()));
		g.fillOval(215, 18, 30, 30);
		g.setColor(Color.BLACK);
		g.drawOval(215, 18, 30, 30);
		
		
		//mostra ordem dos jogadores
		int qtdJog = Model.JOG_getQtdJogadores();
		int nJog = Model.getNumJogada() ;
		for(int i = 1; i < qtdJog; i++) {	
			g.setColor(utils.adapataCor(Model.JOG_getCor((nJog + i) % qtdJog)));
			g.fillOval(215 + i*60, 18, 30, 30);
			g.setColor(Color.BLACK);
			g.drawOval(215 + i*60, 18, 30, 30);
			
		}		
		
		// qtd bonus por continente
		if(Model.JOG_getTotalBonusCont() > 0) {
			int alt = 45;
			g.setColor(Color.white);
			g.fillRect(700, 10, 300, 80);
			g.setColor(Color.black);
			g.drawString("Bonus por Continente", 710, alt-15);
			g.drawString("America do Sul: " + Model.JOG_getBonusCont()[0], 710, alt);
			g.drawString("America do Norte: " + Model.JOG_getBonusCont()[1], 850, alt + 15);
			g.drawString("Africa: " + Model.JOG_getBonusCont()[2], 710, alt + 30);
			g.drawString("Europa: " + Model.JOG_getBonusCont()[3], 850, alt);
			g.drawString("Asia: " + Model.JOG_getBonusCont()[4], 710, alt + 15);
			g.drawString("Oceania: " + Model.JOG_getBonusCont()[5], 850, alt + 30);
		}
		

	}
	

	
	
	
}
