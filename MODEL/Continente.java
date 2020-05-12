package MODEL;

import java.util.*;

public class Continente {
	private String nome;
	int bonus;
	private List<Territorio> territorios;
	
	public Continente(String nome, int bonus) {
		this.nome = nome;
		this.bonus = bonus;
		territorios = new ArrayList<Territorio>();
		BaralhoObjetivo.criaCarta("coquistar todo o continente " + nome);
	}
	
	public void AddTerritorio(Territorio t) {
		territorios.add(t);
	}
	
	public void Imprime() {
		System.out.println("--- " + nome + " ---");
		for (Territorio t : territorios) {
			System.out.println(t.nome);
		}
	}
}
