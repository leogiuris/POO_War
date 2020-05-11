package MODEL;
import java.util.Random;

public class BaralhoObjetivo {
	
	static CartaObjetivo lstObjetivo [];
	public static int numCarta;
	
	CartaObjetivo sorteioObjetivo(Player a){
		Random random = new Random();
		int numero = random.nextInt(lstObjetivo.length);
		return lstObjetivo[numero];
	}

}
