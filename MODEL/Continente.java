<<<<<<< HEAD
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
=======
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
>>>>>>> 247bd6a16bd077be6e3dce1c7220c25385020c3c
