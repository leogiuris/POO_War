

package VIEW;

import javax.imageio.*;
import java.awt.*;
import java.io.*;
import java.io.File;
import java.nio.file.*;


public class BancoImagens {
	private Path relPath = FileSystems.getDefault().getPath("images\\");
	private	Image [] vet = new Image[100];
	private	Image img;
	private	int tam;

	
	private File f = new File("url");
	private File [] arq_imagens = f.listFiles();
	
	
	
	public	BancoImagens () {
		
		System.out.println(relPath.toAbsolutePath().toString());
		
		for (int i = 0; i < arq_imagens.length; i++) {
			try {
				vet[i] = ImageIO.read(getClass().getResource("images/"+arq_imagens[i].getName()));
			}
			catch(IOException e) {
				System.out.println(e.getMessage());
				System.exit(1);
			}
		}
	}	
	
	
	void novaImagem() {
		vet[tam] = img;
		tam++;
	}
	
	int getTam() {
		return tam;
	}
	
	Image []getImagem(){
		return vet;
	}
		
	public void TESTA_LISTA_IMAGENS() {

		
		if(!f.isDirectory()) System.out.println("nao é folder");
		
		if(vet.length > 0 && vet[0] != null) {
			System.out.print("tem files");
		}
		
		for(File a : arq_imagens){
			System.out.println(a.getName());
		}
	}
}
