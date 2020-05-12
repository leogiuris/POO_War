package MODEL;
import java.util.*;


public class Dado {
	
	public int RolarDado() {
		Random r = new Random();
		return r.nextInt(6) + 1;
	}
	
	public void TESTE_dado() {
		for(int i = 0; i< 12; i++) {
			System.out.print(RolarDado() + ", ");
		}
		System.out.println();
	}
}
