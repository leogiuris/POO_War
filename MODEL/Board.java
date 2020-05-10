package MODEL;

public class Board {
	
	static Continente continentes[] = {new Continente("Continente 1"), new Continente("Continente 2")};
	
	static Territorio territorios[] = 
				{new Territorio("A",continentes[0]), new Territorio("B",continentes[0]),
				new Territorio("C",continentes[0]), new Territorio("D",continentes[1]),
				new Territorio("E",continentes[1]), new Territorio("F",continentes[1])};
	
	public void imprimeBoard() {
		for(int i = 0; i<continentes.length; i++){
			continentes[i].Imprime();
			System.out.println();
		}
	}
	
	
}
