package VIEW;

import java.util.*;

public class Principal {
	
	public static void main (String[] args) {
		ListaImagens li = new ListaImagens();
		Frame f = new Frame("Board", li);
		Scanner s = new Scanner(System.in);
		
		f.setVisible(true);
		
		li.novaImagem();
		f.repaint();
	}
	
	
}
