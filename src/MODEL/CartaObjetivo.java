package MODEL;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CartaObjetivo {
	protected String descricao;
	static private List<CartaObjetivo> baralho = new ArrayList<CartaObjetivo>();
	protected Player dono;
	
	private enum Objetivos{
		vazio,
		ConquistarAsia,
		ConquistarEuropa,
		ConquistarAmericaDoSul,
		ConquistarAmericaDoNorte,
		ConquistarAfrica,
		ConquistarOceania,
		EliminarJogadorAzul,
		EliminarJogadorBranco,
		EliminarJogadorVerde,
		EliminarJogadorAmarelo,
		EliminarJogadorPreto,
		EliminarJogadorVermelho,
		Conquistar24Territorios
	}
	
	
	protected CartaObjetivo() {
        this.descricao = "sem descrição";
    }
	
	public boolean satisfeito() {
		return true;
	}
	
	
	static public CartaObjetivo sorteioObjetivo(){
		Random random = new Random();
		int numero = random.nextInt(baralho.size());
		return baralho.remove(numero); 
	}
	
	
	 public void setDono(Player jogador) {
	        this.dono = jogador;
	 }
}
