package MODEL;

import java.util.*;

public class Continente {
	public String nome;
	public int bonus;
	public List<Territorio> territorios;
	
	public Continente(String nome, int bonus) {
		this.nome = nome;
		this.bonus = bonus;
		territorios = new ArrayList<Territorio>();
		BaralhoObjetivo.criaCarta("coquistar todo o continente " + nome);
	}
	
	public void AddTerritorio(Territorio t) {
		territorios.add(t);
	}
	
	public Boolean validaBonus(Player.Cor c) {
		for(int i = 0; i < territorios.size(); i++) {
			if(territorios.get(i).getCor() != c) {
				return false;
			}
		}
		return true;
	}
	
	public void Imprime() {
		System.out.println("--- " + nome + " ---");
		for (Territorio t : territorios) {
			System.out.println(t.nome);
		}
	}
}
