package MODEL;

import java.util.*;

public class BaralhoObjetivo {
	
	static private List<CartaObjetivo> baralho = new ArrayList<CartaObjetivo>();
	
	
	static public void addCarta(CartaObjetivo carta) {
		baralho.add(carta);
	}
	CartaObjetivo sorteioObjetivo(){
		Random random = new Random();
		int numero = random.nextInt(baralho.size());
		return baralho.remove(numero); 
	}
	
}
