package VIEW;

import java.awt.Color;

public class utils {
	
	public static Color adapataCor(String c) {
		if(c.compareTo("preto") == 0)
			return Color.BLACK;
		if(c.compareTo("branco") == 0)
			return Color.WHITE;
		if(c.compareTo("azul") == 0)
			return Color.BLUE;
		if(c.compareTo("verde") == 0)
			return Color.GREEN;
		if(c.compareTo("amarelo") == 0)
			return Color.YELLOW;
		if(c.compareTo("vermelho") == 0)
			return Color.RED;
		
		return null;
	}
	
	public static String adaptaCor(Color c) {
		if(c == Color.BLACK)
			return "preto";
		if(c == Color.WHITE)
			return "branco";
		if(c == Color.BLUE)
			return "azul";
		if(c == Color.GREEN)
			return "verde";
		if(c == Color.YELLOW)
			return "amarelo";
		if(c == Color.RED)
			return "vermelho";
		
		return null;
	}
}
