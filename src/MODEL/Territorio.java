package MODEL;

import java.util.*;

import MODEL.Player.Cor;

class Territorio {
	
	public String nome;
	public Continente continente;
	public int id;
	public List<Exercito> exercitos = new ArrayList<Exercito>();
	static private int qtdTerritorios = 0;
	
	public Territorio(String nome, Continente continente) {
		this.nome = nome;
		this.continente = continente;
		this.id = qtdTerritorios;
		qtdTerritorios++;
		continente.AddTerritorio(this);
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
	
	public void botarExercito(Exercito e, int qtd) {
		while(qtd > 0) {
			exercitos.add(e);
			qtd--;
		}
	}
	
	public void resetTerritorio() {
		exercitos.clear();
	}
	
    public Player getDono() {
    	if(exercitos.isEmpty()) {
			return null;
		}
    	
    	Cor c = getCor();
		return Player.getJogadorPorCor(c);
    }
}
