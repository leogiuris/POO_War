/**/
package VIEW;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Array;

import javax.swing.*;
import CONTROL.Partida;
import CONTROL.Partida.Estado;

import MODEL.Model;

import java.util.*;

public class CartasPanel extends JPanel  {
	
	Dimension panelDimension = new Dimension(660, 218);
	ImageIcon placeHolder;
	JButton tCartas = new JButton("Trocar Cartas");
	JButton fechar = new JButton("Fechar");
	
	public List<Integer> maoCartas;
	int i;
	int maxCartas = 5;
	
	
	public CartasPanel() {
		Toolkit tk=Toolkit.getDefaultToolkit();
		placeHolder = new ImageIcon("./images/war_carta_placeholder.png");
		
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		this.setMaximumSize(panelDimension);
		this.setMinimumSize(panelDimension);
		this.setPreferredSize(panelDimension);
		this.setBounds(200,400, placeHolder.getIconWidth()*6, placeHolder.getIconHeight());
		
		
		
		fechar.setAlignmentX(Component.RIGHT_ALIGNMENT);
		fechar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("fecha");
				Partida.getInstance().esvaziaTroca();
				fechaPainel();
			}
		});
		
		tCartas.setAlignmentX(Component.RIGHT_ALIGNMENT);
		tCartas.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) { 
				//Model.JOG_trocaCartas(cartasSelecionadas);
				Partida.getInstance().efetuarTroca();
				fechaPainel();
			}
		});
		
		
		this.add(tCartas);
		this.add(fechar);
	}
	
	protected void paintComponent(Graphics g) {
		
		Partida p = Partida.getInstance();

		
		super.paintComponent(g);
		

		maoCartas = Model.JOG_getMaoCartas();
		
		for (i = 0; i < maoCartas.size(); i++) {
			
			int idCarta = maoCartas.get(i);
			
			if(i >= maoCartas.size()) {
				System.out.println("place holder");
				JLabel ph = new JLabel(placeHolder);
				this.add(ph);
				return;
			}
			
			CartaLabel cartaI = new CartaLabel(idCarta);
			cartaI.carta.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                	cartaI.carta.setBorder(BorderFactory.createLineBorder(Color.yellow,4));
                	//System.out.println("clicou carta " + idCarta);
                	
                	p.SelecionarCarta(idCarta);
                	//cartasSelecionadas.add(maoCartas.get(i-1));
                }
            });
			this.add(cartaI.carta);
			
		}
	}
	
	public void abrePainel() {
		this.setVisible(true);
	}
	
	public void fechaPainel() {
		this.setVisible(false);
	}
		
}

class CartaLabel extends JLabel{
	JLabel carta;
	int id;
	
	public CartaLabel(int n) {
		carta = new JLabel(new ImageIcon("./images/CARTAS_TERRITORIO/" 
				+ n + "_" 
				+ Model.JOG_getFormaCartaMao(n) + ".png"));
		
		id = n;
	}
	
}


/*/
package VIEW;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Array;

import javax.swing.*;
import CONTROL.Partida;
import CONTROL.Partida.Estado;
import MODEL.CartaTerritorio;
import MODEL.Model;

import java.util.*;

public class CartasPanel extends JPanel  {
	
	Dimension panelDimension = new Dimension(660, 218);
	public List<CartaTerritorio> maoCartas = Model.JOG_getMaoCartas();
	public List<CartaTerritorio> cartasSelecionadas;
	int i;
	
	public CartasPanel() {
		Toolkit tk=Toolkit.getDefaultToolkit();
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		this.setMaximumSize(panelDimension);
		this.setMinimumSize(panelDimension);
		this.setPreferredSize(panelDimension);
		this.setBounds(400,470, panelDimension.width, panelDimension.height);
		
		for (i = 0; i < Model.JOG_getMaoCartas().size(); i++) {
			
			JLabel cartaI = new JLabel(new ImageIcon("./images/CARTAS_TERRITORIO/" + maoCartas.get(i).id + "_" + Model.getformaCartaMao(maoCartas.get(i))));
			cartaI.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                	cartasSelecionadas.add(maoCartas.get(i));
                }

            });
			this.add(cartaI);
			
		}
		
		JButton tCartas = new JButton("Trocar Cartas");
		tCartas.setAlignmentX(Component.RIGHT_ALIGNMENT);
		tCartas.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) { 
				Model.JOG_trocaCartas(cartasSelecionadas);
				fechaPainel();
			}
		});
		this.add(tCartas);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	

	public void fechaPainel() {
		this.setVisible(false);
	}
		
}
*/
