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
import javax.swing.JPanel;
import javax.swing.JTextField;

import CONTROL.Partida;
import CONTROL.Partida.Estado;
import MODEL.Model;

public class BoardPanel extends JPanel{

	private Image bg;
	private Image mapa;
	private Image obj;
	Dimension textDimension = new Dimension(100, 30);
	
	
	public BoardPanel() {
		Toolkit tk=Toolkit.getDefaultToolkit();
		
		Dimension MapaDimension = new Dimension(1024, 768);
		
		this.setLayout(null);
		mapa = tk.getImage("./images/war_tabuleiro_mapa_copy.png");
		bg = tk.getImage("./images/war_tabuleiro_fundo.png");
		this.setMaximumSize(MapaDimension);
		this.setMinimumSize(MapaDimension);
		this.setPreferredSize(MapaDimension);
		
		JButton vObjetivo = new JButton("Objetivo"); 
		vObjetivo.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 ObjPanel oPanel = new ObjPanel(Partida.getInstance().getObjJogador());
				 VIEW.MainFrame.boardPanel.add(oPanel);
			 }
			 });
		vObjetivo.setBounds(25, 65, 80, 20);
		this.add(vObjetivo);
		
		JButton pVez = new JButton("Passar Vez"); 
		pVez.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				Partida.getInstance().PassarVez();
			 }
			 });
		pVez.setBounds(115, 65, 100, 20);
		this.add(pVez);
	
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(mapa, 0, 0, getWidth(), getHeight(), this);
		g.setColor(Color.white);
		
		g.fillRect(20, 20, 200, 70);
		
		g.setColor(Color.black);
		if(Partida.getInstance().estado != Estado.cadastrando) {
			g.drawString("Vez de " + Model.JOG_getNomeJogadorVez(), textDimension.width, textDimension.height);
			g.drawString(Partida.getInstance().getInfoJogador(), textDimension.width, textDimension.height);
			
			g.setColor(utils.adapataCor(Model.JOG_getCor()));
			g.fillOval(130, 20, 20, 20);
		}
		
		
	}
	
	
}
