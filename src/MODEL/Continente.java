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
	}
	
	public void AddTerritorio(Territorio t) {
		territorios.add(t);
	}
	
	public Boolean validarBonus(Player.Cor c) {
		for(int i = 0; i < territorios.size(); i++) {
			if(territorios.get(i).getCor() != c) {
				return false;
			}
		}
		return true;
	}

	
	// se não tiver dono retorna null
    public Player getDono() {
        // deve ter pelo menos 1 país por razões óbvias
        Iterator<Territorio> territorioIterator = territorios.iterator();
        Player jogador = territorioIterator.next().getDono();

        while (territorioIterator.hasNext())
            if (territorioIterator.next().getDono() != jogador)
                return null;

        return jogador;
    }
	
	public void TESTE_continente() {
		System.out.println("< " + nome + " >");
		for (Territorio t : territorios) {
			System.out.println(t.id + ": " + t.nome + ": " + t.getQtdExercitos() + " " + t.getCor());
		}
	}
}
