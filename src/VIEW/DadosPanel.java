package VIEW;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Container;
import javax.swing.*;
import CONTROL.Partida;
import MODEL.Model;
public class DadosPanel extends JPanel {
	
	Dimension panelDimension = new Dimension(300, 300);
	
	public DadosPanel() {	
		this.setBounds(375,30, panelDimension.width, panelDimension.height);
		
		Container dados = new Container();
		dados.setLayout(new GridLayout(3, 2, 2, 2));
		
		
	}
	
}
