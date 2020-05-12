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
	
	public BaralhoTerritorio sorteioTerritorio(){
		Random random = new Random();
		BaralhoTerritorio barTer = new BaralhoTerritorio();
		
		//Pare aqui
		for(int i =0;i<7;i++){
			int numero = random.nextInt(baralho.size());
			barTer.addCarta(baralho[numero]); 
		}
		
	
		return baralho.remove(numero);  
	}
	
	static public void TESTE_imprimeBaralho() {
		System.out.println("Cartas de territorio:\n");
		for(CartaTerritorio c: baralho) {
			System.out.println(c.getTerritorio().nome + ": " + c.forma);
		}
	}
}
