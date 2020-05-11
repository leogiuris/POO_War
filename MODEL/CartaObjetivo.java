package MODEL;

public class CartaObjetivo {
	String objetivo;
	
	CartaObjetivo(){
	}
	
	CartaObjetivo(String Obj){
		CartaObjetivo nova = new CartaObjetivo();
		nova.objetivo = Obj;
		
		BaralhoObjetivo.addCarta(nova);
		//BaralhoObjetivo.lstObjetivo[BaralhoObjetivo.numCarta] = Nova; 
		//BaralhoObjetivo.numCarta++;
	}
}
