package VIEW;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import CONTROL.Partida;
import CONTROL.Partida.Estado;
import MODEL.Model;

public class BoardPanel extends JPanel {

	private Image bg;
	private Image mapa;
	
	public BoardPanel() {
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension textDimension = new Dimension(100, 30);
		Dimension MapaDimension = new Dimension(1024, 768);
		
		this.setLayout(null);
		mapa = tk.getImage("./images/war_tabuleiro_mapa_copy.png");
		bg = tk.getImage("./images/war_tabuleiro_fundo.png");
		this.setMaximumSize(MapaDimension);
		this.setMinimumSize(MapaDimension);
		this.setPreferredSize(MapaDimension);
	
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(mapa, 0, 0, getWidth(), getHeight(), this);
		g.setColor(Color.white);
		
		g.fillRect(20, 20, 200, 70);
		
		g.setColor(Color.black);
		if(Partida.getInstance().estado != Estado.cadastrando) {
			g.drawString("Vez de " + Model.JOG_getNomeJogadorVez(), 30, 35);
			g.drawString(Partida.getInstance().getInfoJogador(), 30, 55);
			
			g.setColor(utils.adapataCor(Model.JOG_getCor()));
			g.fillOval(130, 20, 20, 20);
		}
		
	}
	

}
