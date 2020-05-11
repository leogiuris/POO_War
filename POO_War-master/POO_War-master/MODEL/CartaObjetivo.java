package MODEL;

public class CartaObjetivo {
	
	String Objetivo;
	
	CartaObjetivo(){
	}
	
	CartaObjetivo(String Obj){
		CartaObjetivo Nova = new CartaObjetivo();
		Nova.Objetivo = Obj;
		BaralhoObjetivo.lstObjetivo[BaralhoObjetivo.numCarta] = Nova; 
		BaralhoObjetivo.numCarta++;
	}

}
