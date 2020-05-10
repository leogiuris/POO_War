package MODEL;

import java.util.List;

public class Territorio {
	
	public String nome;
	public List<Exercito> fichas;
	
	public Territorio(String nome, Continente continente) {
		this.nome = nome;
		continente.AddTerritorio(this);
	}
	
}
