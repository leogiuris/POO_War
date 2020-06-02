package MODEL;

import java.util.*;

import MODEL.Player.Cor;

public class Territorio {
	
	public String nome;
	public Continente continente;
	public int index;
	public List<Exercito> exercitos = new ArrayList<Exercito>();
	public Player dono;
	private int qtdTerritorios = 0;
	
	public Territorio(String nome, Continente continente) {
		this.nome = nome;
		this.continente = continente;
		this.index = qtdTerritorios;
		qtdTerritorios++;
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
	
	public void setDono(Player jogador) {
        this.dono = jogador;
    }

    public Player getDono() {
        return this.dono;
    }
}
