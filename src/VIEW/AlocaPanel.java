package VIEW;

import java.awt.Color;
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
import javax.swing.*;
import CONTROL.Partida;
import java.util.*;

public class AlocaPanel extends JPanel implements ActionListener {
	Dimension textDimension = new Dimension(100, 30);
	Dimension panelDimension = new Dimension(200, 200);
	Dimension intDimension = new Dimension(100,180);
	JTextField intAloca = new JTextField(20);
	int territorioId = 0;
	
	public AlocaPanel(int id) {
		territorioId = id;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setMaximumSize(panelDimension);
		this.setMinimumSize(panelDimension);
		this.setPreferredSize(panelDimension);
		this.setBounds(375,30, panelDimension.width, panelDimension.height);
		this.setVisible(true);

		JButton submitButton = new JButton("Submit");
		
		intAloca.setMaximumSize(textDimension);
		intAloca.setMinimumSize(textDimension);
		intAloca.setPreferredSize(textDimension);
		intAloca.setHorizontalAlignment(JTextField.LEFT);
		intAloca.setAlignmentX(Component.CENTER_ALIGNMENT); 
		intAloca.setFont(new Font("Arial", Font.PLAIN, 12));
		
		submitButton.setAlignmentX(Component.CENTER_ALIGNMENT); 
		submitButton.addActionListener(this);
		
		this.add(intAloca);
		this.add(Box.createRigidArea(new Dimension(0, 50)));
		this.add(submitButton);
	}
	

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	public void actionPerformed(ActionEvent e) { 
		
		int i = Integer.parseInt(intAloca.getText());
	    Partida.getInstance().aloca(i,territorioId);
	    /*
	    JComponent comp = (JComponent) e.getSource();
	    Window win = SwingUtilities.getWindowAncestor(comp);
	    win.dispose();
	    */
	    this.setVisible(false);
	    
	}
	
}
