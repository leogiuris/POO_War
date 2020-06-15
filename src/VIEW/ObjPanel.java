package VIEW;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import CONTROL.Partida;
import CONTROL.Partida.Estado;
import MODEL.Model;

public class ObjPanel  extends JPanel{

	private Image bg;
	
	public ObjPanel(String obj) {
		
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension ImageDimension = new Dimension(132, 217);
		bg = tk.getImage("./images/war_carta_objetivo.png");
		
		JLabel label = new JLabel("obj");
	    label.setFont(new Font("Verdana",1,20));
	    label.setAlignmentX(CENTER_ALIGNMENT);
	    label.setAlignmentY(CENTER_ALIGNMENT);
	    this.add(label);
	    
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	}
}
