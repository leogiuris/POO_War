<<<<<<< HEAD
package MODEL;
import java.util.*;

public class BaralhoTerritorio {
	
	static private List<CartaTerritorio> baralho = new ArrayList<CartaTerritorio>();
	
	static public void addCarta(CartaTerritorio carta) {
		baralho.add(carta);
	}
	
	CartaTerritorio sorteioObjetivo(Player a){
		Random random = new Random();
		int numero = random.nextInt(baralho.size());
		return baralho.get(numero);
	}
}
=======
package MODEL;
import java.util.*;

public class BaralhoTerritorio {
	
	static private List<CartaTerritorio> baralho = new ArrayList<CartaTerritorio>();
	
	static public void addCarta(CartaTerritorio carta) {
		baralho.add(carta);
	}
	
	CartaTerritorio sorteioObjetivo(Player a){
		Random random = new Random();
		int numero = random.nextInt(baralho.size());
		return baralho.get(numero);
	}
}
>>>>>>> 247bd6a16bd077be6e3dce1c7220c25385020c3c
