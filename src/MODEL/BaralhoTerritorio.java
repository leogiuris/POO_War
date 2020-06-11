package MODEL;
import java.util.*;

public class BaralhoTerritorio {
	
	static private List<CartaTerritorio> baralho = new ArrayList<CartaTerritorio>();
	
	
	static public void criaCartas() {
		for (int i = 0; i < Board.territorios.length; i++) {
			baralho.add(new CartaTerritorio(Board.territorios[i]));
		}
	}
	
	static public CartaTerritorio pegarCarta() {
		return baralho.remove(0);
	}
	
	static public void devolverCarta(CartaTerritorio ct) {
		baralho.add(ct);
	}
	
	static public int getTamanho() {
		return baralho.size();
	}
	
	static public void sorteiaCartas() {
		
		if(baralho.isEmpty()) {
			criaCartas();
		}
		
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
	
	
	static public CartaTerritorio loadCarta(int id) {
		for(CartaTerritorio c: baralho) {
			if(c.id == id) {
				int index = baralho.indexOf(c);
				return baralho.remove(index);
			}
		}
		
		return new CartaTerritorio(Board.territorios[id]);
	}
	
	static public void TESTE_imprimeBaralho() {
		System.out.println("--- TESTE IMPRIME BARALHO TERRITORIO ---");
		System.out.println("Cartas de territorio:\n");
		for(CartaTerritorio c: baralho) {
			System.out.println(c.getTerritorio().nome + ": " + c.forma);
		}
	}
	
	
}
