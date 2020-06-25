package VIEW;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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

import CONTROL.Partida;
import CONTROL.Partida.Estado;
import MODEL.Model;

public class BoardPanel extends JPanel{

	private Image bg;
	private Image mapa;
	//private Image obj;
	private boolean mostraObj = false;
	Dimension textDimension = new Dimension(100, 30);
	
	JButton pVez = new JButton("Passar Vez"); 
	JButton vObjetivo = new JButton("Objetivo"); 
	JButton salvar = new JButton("Salvar");
	
	
	public BoardPanel() {
		Toolkit tk=Toolkit.getDefaultToolkit();
		
		Dimension MapaDimension = new Dimension(1024, 768);
		
		this.setLayout(null);
		mapa = tk.getImage("./images/war_tabuleiro_mapa_copy.png");
		bg = tk.getImage("./images/war_tabuleiro_fundo.png");
		this.setMaximumSize(MapaDimension);
		this.setMinimumSize(MapaDimension);
		this.setPreferredSize(MapaDimension);
		
		
		
		vObjetivo.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 if(!mostraObj)
					 mostraObj = true;
				 else
					 mostraObj = false;
				 Partida.getInstance().refresh();
			 }
		});
		
		vObjetivo.setBounds(25, 65, 80, 20);
		this.add(vObjetivo);
		
		 
		pVez.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				Partida.getInstance().EncerrarJogada();
				mostraObj = false;
			 }
		});
		
		pVez.setBounds(115, 65, 100, 20);
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
		
	}
	

	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(mapa, 0, 0, getWidth(), getHeight(), this);
		g.setColor(Color.white);
		
		g.fillRect(10, 10, 220, 80);

	
		g.setColor(Color.black);

		Partida p = Partida.getInstance();
		
		pVez.setVisible(!(p.estado == Estado.cadastrando));
		vObjetivo.setVisible(!(p.estado == Estado.cadastrando));
		salvar.setVisible(!(p.estado == Estado.cadastrando));
			
		if(p.estado == Estado.cadastrando)
			return;
		
		// informações gerais do jogador
		g.drawString("Vez de " + Model.JOG_getNomeJogadorVez(), 20, 30);
		g.drawString(p.getInfoJogador(), 20, 45);
		if(mostraObj) {
			g.drawString(Model.JOG_getObjetivo(),20, 60);
			
		}
		
		//cor do jogador
		g.setColor(utils.adapataCor(Model.JOG_getCor()));
		g.fillOval(160, 18, 20, 20);
		g.setColor(Color.BLACK);
		g.drawOval(160, 18, 20, 20);
		
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
