
package MODEL;

class CartaTerritorio {
	public int id;
	public Territorio territorio;
	public Forma forma;
	
	public enum Forma{
		triangulo,
		circulo,
		quadrado,
		coringa
	}
	
	
	public Forma setForma(char f) {
		if(f == 't')
			return Forma.triangulo;
		if(f == 'q')
			return Forma.quadrado;
		if(f == 'c')
			return Forma.circulo;
		if(f == 'a')
			return Forma.coringa;
		System.out.println("erro getForma");
		return null;
	}

	
	public CartaTerritorio(int id, char f){
		
		this.id = id;
		
		if(id == 99) {
			territorio = null;
			forma = Forma.coringa;
		}
		else {
			territorio = Board.territorios[id];
			forma = setForma(f);
		}
	}
	
	public char getForma() {
		if(forma == Forma.triangulo)
			return 't';
		if(forma == Forma.quadrado)
			return 'q';
		if(forma == Forma.circulo)
			return 'c';
		if(forma == Forma.coringa)
			return 'a';
		System.out.println("erro getForma");
		return '\0';
	}
	
	public Territorio getTerritorio() {
		return territorio;
	}

}