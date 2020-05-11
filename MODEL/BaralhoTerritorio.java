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
