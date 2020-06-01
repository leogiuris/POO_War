package MODEL;

public class ConquistarMundo extends CartaObjetivo {

    public ConquistarMundo() {
        this.descricao = "conquistar o mundo (todos os territ�rios)";
    }

    @Override
    public boolean satisfeito() {
    	
        for (Territorio territorio : Board.territorios)
            if (territorio.getDono() != dono)
                return false;
        return true;
    }
    
}
