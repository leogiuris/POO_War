package GUI_TESTE;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;

import javax.swing.*;

public class Tabuleiro extends JPanel {

	private Image img_mapa;

	
	public Tabuleiro() {
		Toolkit tk=Toolkit.getDefaultToolkit();
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		img_mapa = tk.getImage(	"./images/war_tabuleiro_mapa_copy.png");
		
		int LARG_DEFAULT = img_mapa.getWidth(null);
		int ALT_DEFAULT = img_mapa.getHeight(null);
		
		Dimension panelDimension = new Dimension(LARG_DEFAULT, ALT_DEFAULT);
		
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		
		this.setMaximumSize(panelDimension);
		this.setMinimumSize(panelDimension);
		this.setPreferredSize(panelDimension);
		this.setBounds(x,y, panelDimension.width, panelDimension.height);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img_mapa, 0, 0, getWidth(), getHeight(), this);
	}
	
}
