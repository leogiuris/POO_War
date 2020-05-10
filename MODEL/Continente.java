package MODEL;

import java.util.*;

public class Continente {
	private String nome;
	private List<Territorio> territorios;
	
	public Continente(String nome) {
		this.nome = nome;
		territorios = new ArrayList<Territorio>();
	}
	
	public void AddTerritorio(Territorio t) {
		territorios.add(t);
	}
	
	public void Imprime() {
		System.out.println(nome);
		for (Territorio t : territorios) {
			System.out.println(t.nome);
		}
	}
	
}
