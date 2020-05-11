package MODEL;

import java.util.Random;

public class BaralhoTerritorio {
	static CartaTerritorio lstTerritorio [];
	public static int numCarta;
	
	CartaTerritorio sorteioObjetivo(Player a){
		Random random = new Random();
		int numero = random.nextInt(lstTerritorio.length);
		return lstTerritorio[numero];
	}

}

