package VIEW;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BoardPanel extends JPanel {

	private Image bg;
	
	public BoardPanel() {
		
		Dimension textDimension = new Dimension(100, 30);
		Dimension panelDimension = new Dimension(1024, 768);
		
		this.setLayout(null);
		this.setBackgroundImage("C:/Users/Antonio/Desktop/POO_War-develop/POO_War-develop/images/war_tabuleiro_mapa copy.png");
		this.setMaximumSize(panelDimension);
		this.setMinimumSize(panelDimension);
		this.setPreferredSize(panelDimension);
	
	}

	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	}
	
	public void setBackgroundImage(String path) {
		try {
			this.bg = new ImageIcon(path).getImage();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}
}
