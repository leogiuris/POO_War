package MODEL;

import MODEL.Player.Cor;

public class DerrotarJogador extends CartaObjetivo {

    final private Cor corInimigo;
    final private CartaObjetivo alternativo;

    // objetivo alternativo � usado no caso do inimigo ser o pr�prio dono
    public DerrotarJogador(Cor corInimigo, CartaObjetivo alternativo) {
        this.corInimigo = corInimigo;
        this.alternativo = alternativo;
        this.descricao = "derrotar todos os ex�rcitos do jogador " + corInimigo +
                " se esse for voc� ou n�o estiver jogando ent�o " + alternativo.toString();
    }

    public void setDono(Player jogador) {
        super.setDono(jogador);
        this.alternativo.setDono(jogador);
    }
    
    //FALTA FINALIZAR !Board.territorios.validaCor(corInimigo)
    public boolean satisfeito() {
        if (dono.getCor() == corInimigo || !Board.territorios.validaCor(corInimigo)) {
            return alternativo.satisfeito();
        }

        List<Territorio> territorios = Board.territorios;
        for (Territorio territorio : territorios)
            if (territorio.getDono().getCor() == corInimigo)
                return false;

        return true;
    }
}