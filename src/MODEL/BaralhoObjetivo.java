package MODEL;

import java.util.*;

public class BaralhoObjetivo {
	
	static private List<CartaObjetivo> baralho = new ArrayList<CartaObjetivo>();
	
	
	static public void criaCarta() {
		CartaObjetivo carta = new CartaObjetivo();
		baralho.add(carta);
	}
	
	static public CartaObjetivo sorteioObjetivo(){
		Random random = new Random();
		int numero = random.nextInt(baralho.size());
		return baralho.remove(numero); 
	}
	
	
	
}
