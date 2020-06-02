package VIEW;


import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;



public class Tabuleiro extends JPanel{
	public static final int IMG_X = 100;
	public static final int IMG_Y = 100;
	private BancoImagens li;
	
	public Tabuleiro(BancoImagens l) {
		li = l;
	}
	
	public void MostraMapa(Graphics g) {
		super.paintComponent(g);
		Image []vi = li.getImagem();
		int larg = IMG_X, alt = IMG_Y;
		
		g.drawImage(vi[0],larg,alt,null);
		g.drawImage(vi[79], larg, alt,null);
		
	}
}
