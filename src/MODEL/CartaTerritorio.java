
package MODEL;

public class CartaTerritorio {
	public int id;
	public Territorio territorio;
	public Forma forma;
	
	public enum Forma{
		triangulo,
		circulo,
		quadrado		
	}
	
	public Forma getForma(int n) {
		if(n%3 == 0) {
			return Forma.triangulo;
		}
		else if(n%3 == 1) {
			return Forma.circulo;
		}
		else
			return Forma.quadrado;
	}

	public CartaTerritorio(Territorio t){
		id = BaralhoTerritorio.getTamanho();
		territorio = t;
		forma = getForma(BaralhoTerritorio.getTamanho());
	}
	
	public Territorio getTerritorio() {
		return territorio;
	}

}