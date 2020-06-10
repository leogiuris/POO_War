package VIEW;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import MODEL.Player.Cor;

public class Tabuleiro extends JPanel {
	
	Dimension panelDimension = new Dimension(1024, 768);
	Dimension nodeDimension = new Dimension(20, 20);
    ArrayList<Node> nodes;

    //Constructor
    public Tabuleiro() { 
    	
		nodes = new ArrayList<Node>();
		this.setBounds(0,0, panelDimension.width, panelDimension.height);
		this.setOpaque(false);
    }

    class Node {
	int x, y;
	int qtdExercito;
	Cor cor;
	String name;
	
		public Node(String myName, int myX, int myY) {
		    x = myX;
		    y = myY;
		    name = myName;
		}
		
		public Node(String myName,int qtdE, int myX, int myY,Cor c) {
		    x = myX;
		    y = myY;
		    qtdExercito = qtdE;
		    name = myName;
		    
		}
		
		public void setqtdExercito(int z) { 
			qtdExercito = z;
    	}
		
		public int getqtdExercito() { 
			return this.qtdExercito;
    	}
		
    }
    
    //add a node at pixel (x,y)
    public void addNode(String name, int x, int y) { 
	nodes.add(new Node(name,x,y));
	this.repaint();
    }
   
    
     // draw the nodes
    public void paint(Graphics g) {
    	
		FontMetrics f = g.getFontMetrics();
	
		g.setColor(Color.black);
		
		for (Node n : nodes) {
		    g.setColor(Color.white);
		    g.fillOval(n.x-10, n.y-10,nodeDimension.width, nodeDimension.height);
		    g.setColor(Color.black);
		    g.drawOval(n.x-10, n.y-10,nodeDimension.width, nodeDimension.height);
		    g.drawString(Integer.toString(n.qtdExercito), n.x-3,n.y+5);
		    g.drawString(n.name, n.x-16,n.y+17);
		}
    }
}

