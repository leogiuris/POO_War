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
	
	public CartaTerritorio sorteioTerritorio(){
		Random random = new Random();
		int numero = random.nextInt(baralho.size());
		
		//usei o metodo remove pq a carta nao pode mais ficar no baralho dps q tira
		return baralho.remove(numero);  
	}
	
	static public void TESTE_imprimeBaralho() {
		System.out.println("Cartas de territorio:\n");
		for(CartaTerritorio c: baralho) {
			System.out.println(c.getTerritorio().nome + ": " + c.forma);
		}
	}
}
