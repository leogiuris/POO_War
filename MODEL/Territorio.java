package MODEL;

import java.util.*;

import MODEL.Player.Cor;

public class Territorio {
	
	public String nome;
	public Continente continente;
	public List<Exercito> exercitos = new ArrayList<Exercito>();
	
	public Territorio(String nome, Continente continente) {
		this.nome = nome;
		this.continente = continente;
		continente.AddTerritorio(this);
		BaralhoTerritorio.addCarta(this);
	}
	
	public int getQtdExercitos() {
		return exercitos.size();
	}
	
	public Player.Cor getCor(){
		if(exercitos.isEmpty()) {
			return Player.Cor.vazio;
		}
		return exercitos.get(0).cor;
	}
	
	public boolean validaCor(Cor c) {
		if(c == getCor() || getCor() == Cor.vazio)
			return true;
		else
			return false;
	}
	
	public boolean botarExercito(Exercito e) {	
		if(validaCor(e.cor)){
			exercitos.add(e);
			return true;
		}

		return false;		
	}
}
