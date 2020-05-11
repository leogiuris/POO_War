
package MODEL;

public class CartaTerritorio {
	public String nome;
	public Forma tricirqua;
	public enum Forma{
		triangulo,
		circulo,
		quadrado,
	}
	
	CartaTerritorio(){
	}
	
	public CartaTerritorio(String nome, Forma f){
		CartaTerritorio nova = new CartaTerritorio();
		nova.nome = nome;
		nova.tricirqua = f;
		BaralhoTerritorio.addCarta(nova); 
		
	}

}