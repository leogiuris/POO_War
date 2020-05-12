package MODEL;
import java.util.*;

public class BaralhoTerritorio {
	
	static private List<CartaTerritorio> baralho = new ArrayList<CartaTerritorio>();
	
	
	static public void addCarta(Territorio t) {
		CartaTerritorio carta = new CartaTerritorio(t);
		baralho.add(carta);
	}
	
	static public int getTamanho() {
		return baralho.size();
	}
	
	static public void sorteiaCartas() {
		Random r = new Random();
		int index;
		
		if(Player.jogadores.isEmpty()) {
			return;
		}
		
		for(int i = 0; !baralho.isEmpty(); i++) {
			index = r.nextInt(baralho.size());
			Player.jogadores.get(i%Player.jogadores.size()).maoTer.add(baralho.remove(index));
		}
	}
	
	static public void TESTE_imprimeBaralho() {
		System.out.println("--- TESTE IMPRIME BARALHO TERRITORIO ---");
		System.out.println("Cartas de territorio:\n");
		for(CartaTerritorio c: baralho) {
			System.out.println(c.getTerritorio().nome + ": " + c.forma);
		}
	}
}
