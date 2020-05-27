package VIEW;


import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;



public class Tabuleiro extends JPanel{
	public static final int IMG_X = 0;
	public static final int IMG_Y = 0;
	private ListaImagens li;
	
	public Tabuleiro(ListaImagens l) {
		li = l;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image []vi = li.getImagem();
		int larg = IMG_X, alt = IMG_Y;
		
		g.drawImage(vi[0],larg,alt,null);
	}
}
