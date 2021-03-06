package MODEL;
import java.util.*;

public class BaralhoTerritorio {
	
	static private List<CartaTerritorio> baralho = new ArrayList<CartaTerritorio>();
	
	
	static public void addCarta(Territorio t) {
		CartaTerritorio carta = new CartaTerritorio(t);
		baralho.add(carta);
	}
	
	static public CartaTerritorio pegarCarta() {
		return baralho.remove(0);
	}
	
	static public int getTamanho() {
		return baralho.size();
	}
	
	static public void sorteiaCartas() {

		
		if(Player.jogadores.isEmpty()) {
			return;
		}
		
		Collections.shuffle(baralho);
		
		for(int i = 0; i<baralho.size(); i++) {
			Player p = Player.jogadores.get(i % Player.jogadores.size());
			p.territorios.add(baralho.get(i).territorio);
			
		}
		
		for (Player j: Player.jogadores) {
			j.botarExercitosInit();
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
