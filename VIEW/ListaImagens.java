package VIEW;

import javax.imageio.*;
import java.awt.*;
import java.io.*;

public class ListaImagens {
	private	Image [] vet = new Image[100];
	private	Image i;
	private	int tam;
	
	public	ListaImagens () {
		try {
			i = ImageIO.read(getClass().getResource("images/war_tabuleiro_mapa copy.png"));
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	void novaImagem() {
		vet[tam] = i;
		tam++;
	}
	
	int getTam() {
		return tam;
	}
	
	Image []getImagem(){
		return vet;
	}
}
