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
	
	CartaTerritorio(String nome, Forma a){
		CartaTerritorio Nova = new CartaTerritorio();
		Nova.nome = nome;
		Nova.tricirqua = a;
		BaralhoTerritorio.lstTerritorio[BaralhoTerritorio.numCarta] = Nova; 
		BaralhoTerritorio.numCarta++;
	}

	
	
}
