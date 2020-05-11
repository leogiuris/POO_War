<<<<<<< HEAD
package MODEL;

import java.util.*;

public class BaralhoObjetivo {
	
	static private List<CartaObjetivo> baralho = new ArrayList<CartaObjetivo>();
	
	
	static public void addCarta(CartaObjetivo carta) {
		baralho.add(carta);
	}
	
	CartaObjetivo sorteioObjetivo(Player a){
		Random random = new Random();
		int numero = random.nextInt(baralho.size());
		return baralho.get(numero);
	}
	
}
=======
package MODEL;

import java.util.*;

public class BaralhoObjetivo {
	
	static private List<CartaObjetivo> baralho = new ArrayList<CartaObjetivo>();
	
	
	static public void addCarta(CartaObjetivo carta) {
		baralho.add(carta);
	}
	
	CartaObjetivo sorteioObjetivo(Player a){
		Random random = new Random();
		int numero = random.nextInt(baralho.size());
		return baralho.get(numero);
	}
	
}
>>>>>>> 247bd6a16bd077be6e3dce1c7220c25385020c3c
