package MODEL;
import java.io.File;
import java.util.*;

import MODEL.CartaTerritorio.Forma;

public class BaralhoTerritorio {
	
	static private List<CartaTerritorio> baralho = new ArrayList<CartaTerritorio>();
	
	
	static public void criaCartas() {
		
		String[] pathnames;
        File f = new File("./images/CARTAS_TERRITORIO");
        pathnames = f.list();
		
        for(String str: pathnames) {
        	System.out.println(str);
        	int index = str.indexOf('_');
        	int id = Integer.parseInt(str.substring(0, index));
        	char forma = str.charAt(index + 1);
        	baralho.add(new CartaTerritorio(id, forma));
        }
        System.out.println("foram todas");
	}
	
	static public CartaTerritorio pegarCarta() {
		if(baralho.isEmpty()) {
			criaCartas();
		}
		return baralho.remove(0);
	}
	
	static public void devolverCarta(CartaTerritorio ct) {
		baralho.add(ct);
	}
	
	static public int getTamanho() {
		return baralho.size();
	}
	
	static public void sorteiaCartas() {
		baralho.clear();
		criaCartas();
		
		if(Player.jogadores.isEmpty()) {
			return;
		}
		
		Collections.shuffle(baralho);
		
		for(int i = 0; i<baralho.size(); i++) {
			CartaTerritorio ct = baralho.get(i);
			if(ct.forma == Forma.coringa)
				continue;
			Player p = Player.jogadores.get(i % Player.getNumJogadores());
			p.territorios.add(ct.territorio);
			
		}
		
		for (Player j: Player.jogadores) {
			j.botarExercitosInit();
		}
	}
	
	
	static public CartaTerritorio loadCarta(int id) {
		if(baralho.isEmpty()) {
			criaCartas();
			Collections.shuffle(baralho);
		}
		
		for(CartaTerritorio c: baralho) {
			if(c.id == id) {
				int index = baralho.indexOf(c);
				return baralho.remove(index);
			}
		}
		
		System.out.println("ERRO - load carta");
		return null;
	}
	
	static public void TESTE_imprimeBaralho() {
		System.out.println("--- TESTE IMPRIME BARALHO TERRITORIO ---");
		System.out.println("Cartas de territorio:\n");
		for(CartaTerritorio c: baralho) {
			System.out.println(c.getTerritorio().nome + ": " + c.forma);
		}
	}
	
	
}
