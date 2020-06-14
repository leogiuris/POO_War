package VIEW;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import CONTROL.Partida;
import MODEL.Model;

public class Tabuleiro extends JPanel {
	
	Dimension panelDimension = new Dimension(1024, 768);
	Dimension nodeDimension = new Dimension(20, 20);
    ArrayList<Node> nodes;
    
    
    //Construtor
    public Tabuleiro() { 
		nodes = new ArrayList<Node>();
		this.setBounds(0,0, panelDimension.width, panelDimension.height);
		this.setOpaque(false);
    }

  
    //add a node at pixel (x,y)
    public void addNode(String name, int x, int y) { 

		nodes.add(new Node(name,x,y));
		this.repaint();
    }
   
    public void updateNodes() {
    	for(Node n: nodes) {
    		n.cor = Model.TER_getCorDono(n.id);
    		n.qtdExercito = Model.TER_getQtdExercitos(n.id);
    	}
    }
    
    public void carregaNodes() {
    	//America do Sul
    	this.addNode("Venezuela",201,432);
    	this.addNode("Peru",239,489);
    	this.addNode("Argentina",275,552);
    	this.addNode("Brasil",285,453);
    	//America do Norte
    	this.addNode("Mexico",146,359);
    	this.addNode("California",122,245);
    	this.addNode("Texas",167,266);
    	this.addNode("NovaYork",212,267);	
    	this.addNode("Vancouver",162,192);
    	this.addNode("Quebec",285,191);
    	this.addNode("Alasca",99,138);
    	this.addNode("Calgary",188,146);
    	this.addNode("Groenlandia",332,113);
    	//Africa
    	this.addNode("Argelia",458,370);
    	this.addNode("Egito",567,386);
    	this.addNode("Angola",555,507);
    	this.addNode("Nigeria",528,432);
    	this.addNode("Somalia",620,486);
    	this.addNode("Africa do Sul",576,560);
    	//Europa
    	this.addNode("Romenia",581,257);
    	this.addNode("Reino Unido",465,180);
    	this.addNode("Suecia",534,149);
    	this.addNode("Franca",488,246);
    	this.addNode("Espanha",452,282);
    	this.addNode("Italia",542,228);
    	this.addNode("Ucrania",600,231);
    	this.addNode("Polonia",576,203);
    	//Asia
    	this.addNode("Estonia",677,141);
    	this.addNode("Russia",785,161);
    	this.addNode("Siberia",891,147);
    	this.addNode("Letonia",653,188);
    	this.addNode("Cazaquistao",836,222);
    	this.addNode("Turquia",719,245);
    	this.addNode("Mongolia",857,257);
    	this.addNode("Japao",950,273);
    	this.addNode("China",800,294);
    	this.addNode("Correia Do Norte",867,310);
    	this.addNode("Correia Do Sul",864,335);
    	this.addNode("Tailandia",885,413);
    	this.addNode("Bangladesh",852,369);
    	this.addNode("India",801,378);
    	this.addNode("Paquistao",750,318);
    	this.addNode("Ira",716,339);
    	this.addNode("Iraque",675,335);
    	this.addNode("Arabia Saudita",672,411);
    	this.addNode("Jordania",623,350);
    	this.addNode("Siria",678,285);
    	//Oceania
    	this.addNode("Indonesia",896,495);
    	this.addNode("Nova Zelandia",936,633);
    	this.addNode("Perth",813,590);
    	this.addNode("Australia",870,609);
    }
    
    
    
     // draw the nodes
    public void paint(Graphics g) {
    	
		FontMetrics f = g.getFontMetrics();
		
		g.setColor(Color.black);
		for (Node n : nodes) {
		    g.setColor(utils.adapataCor(n.cor));
		    g.fillOval(n.x-10, n.y-10,nodeDimension.width, nodeDimension.height);
		    g.setColor(Color.black);
		    g.drawOval(n.x-10, n.y-10,nodeDimension.width, nodeDimension.height);
		    
		    if(n.cor == "preto")
		    	g.setColor(Color.white);
		    
		    g.drawString(Integer.toString(n.qtdExercito), n.x-3,n.y+5);
		    g.setColor(Color.black);
		    g.drawString(n.name, n.x-16,n.y+17);
		}

    }
    
    class Node implements MouseListener{
		int x, y;
		int qtdExercito;
		int id;
		String cor;
		String name;
		
		public Node(String myName, int myX, int myY) {
			x = myX;
		    y = myY;
		    name = myName;
		    id = Model.TER_getIDbyName(name);
		    qtdExercito = Model.TER_getQtdExercitos(id);
		    cor = Model.TER_getCorDono(id);
		    addMouseListener(this);
		}
	
		public void setqtdExercito(int z) { 
			qtdExercito = z;
    	}
		
		public int getqtdExercito() { 
			return this.qtdExercito;
    	}
		
		public void mouseClicked(MouseEvent e) {
			int xx=e.getX(),yy=e.getY();
			//System.out.println("x = " + xx + ",yy = " + yy);
			if(xx >= this.x-11 && xx < (this.x + 11))
				if(yy >= this.y-11 && yy < (this.y + 11)) {
					Partida.getInstance().clicouTerritorio(id);
				}
			repaint();
		}
		
		public void mouseEntered(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
    }
    
}

