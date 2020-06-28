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
	public List<Integer> maoCartas;
	public List<Integer> cartasSelecionadas;
	int i;
	
	public CartasPanel() {
		Toolkit tk=Toolkit.getDefaultToolkit();
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		this.setMaximumSize(panelDimension);
		this.setMinimumSize(panelDimension);
		this.setPreferredSize(panelDimension);
		this.setBounds(400,470, panelDimension.width, panelDimension.height);
		
		for (i = 0; i < Model.JOG_getMaoCartas().size(); i++) {		
			JLabel cartaI = new JLabel(new ImageIcon("./images/CARTAS_TERRITORIO/" + maoCartas.get(i) + "_" + maoCartas.get(i).forma.toString()));
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
		
		for (i = 0; i < Model.JOG_getMaoCartas().size(); i++) {		
			JLabel cartaI = new JLabel(new ImageIcon("./images/CARTAS_TERRITORIO/" + maoCartas.get(i) + "_" + maoCartas.get(i).forma.toString()));
			cartaI.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                	cartasSelecionadas.add(maoCartas.get(i));
                }
            });
			this.add(cartaI);
			
		}
	}
	

	public void fechaPainel() {
		this.setVisible(false);
	}
		
}