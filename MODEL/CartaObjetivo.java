package MODEL;

import VIEW.Tabuleiro;

public abstract class CartaObjetivo {
	protected String descricao;
	protected Player dono;
	
	protected CartaObjetivo() {
        this.descricao = "sem descrição";
    }
	
	public abstract boolean satisfeito();
	
	 public void setDono(Player jogador) {
	        this.dono = jogador;
	 }
}
