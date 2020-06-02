package MODEL;

import VIEW.Tabuleiro;

public abstract class CartaObjetivo {
	protected String descricao;
	protected Player dono;
	
	protected CartaObjetivo() {
        this.descricao = "sem descri��o";
    }
	
	public abstract boolean satisfeito();
	
	 public void setDono(Player jogador) {
	        this.dono = jogador;
	 }
}
