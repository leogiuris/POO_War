
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
	
	
	public Forma getForma(char f) {
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
		territorio = Board.territorios[id];
		forma = getForma(f);
	}
	
	
	public Territorio getTerritorio() {
		return territorio;
	}

}