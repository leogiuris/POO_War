package MODEL;

import java.util.*;

public class Territorio {
	
	public String nome;
	public List<Exercito> exercitos = new ArrayList<Exercito>();
	
	public Territorio(String nome, Continente continente) {
		this.nome = nome;
		continente.AddTerritorio(this);
		BaralhoTerritorio.addCarta(this);
	}
	
	public void botarExercito(Exercito e) {
		exercitos.add(e);
	}
}
