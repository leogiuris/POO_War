package VIEW;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Container;
import javax.swing.*;
import CONTROL.Partida;
import MODEL.Model;
public class DadosPanel extends JPanel {
	
	Dimension panelDimension = new Dimension(192, 32);
	int[] retDados;
	
	public DadosPanel() {	
		
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		this.setMaximumSize(panelDimension);
		this.setMinimumSize(panelDimension);
		this.setPreferredSize(panelDimension);
		this.setBounds(340,620, panelDimension.width, panelDimension.height);
		
	}
	
	protected void paintComponent(Graphics g) {
		
		Partida p = Partida.getInstance();
		super.paintComponent(g);
		
		retDados = Model.JOG_Atacar(i_origem, i_destino, qtd_tropas)();
		
		for (int i = 0; i < retDados.length; i++) {
			DadoLabel dadoI = new DadoLabel(retDados[i]);
			this.add(dadoI);
		}
	}
	
	class DadoLabel extends JLabel{
		JLabel dado;
		
		public DadoLabel(int n) {
			int count=0;
		
			if(count<3) {
				dado = new JLabel(new ImageIcon("./images/DADOS/dado_ataque" 
						+ n + ".png"));
				count++;
			}
			if(count>=3) {
				dado = new JLabel(new ImageIcon("./images/DADOS/dado_defesa" 
						+ n + ".png"));
				count++;
			}
			
		}
		
	}
}
