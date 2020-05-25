package MODEL;
import java.util.*;


public class Dado {
	
	int valor;
	
	public int RolarDado() {
		Random r = new Random();
		valor = r.nextInt(6) + 1;
		return valor;
	}
	
	public void TESTE_dado() {
		for(int i = 0; i< 12; i++) {
			System.out.print(RolarDado() + ", ");
		}
		System.out.println();
	}
}
