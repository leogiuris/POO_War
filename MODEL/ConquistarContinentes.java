package MODEL;

import java.util.Iterator;
import java.util.List;

public class ConquistarContinentes extends CartaObjetivo{
	
	private final List<Continente> continentes;
    private final int minExtraContinentes;
	
	public ConquistarContinentes(int minExtraContinentes, List<Continente> continentes) {

        this.continentes = continentes;
        this.minExtraContinentes = minExtraContinentes;

        Iterator<Continente> iter = this.continentes.iterator();
        Continente c = iter.next();
        this.descricao = "conquistar os continentes da " + c.getNome();
        while (iter.hasNext()) {
            c = iter.next();
            this.descricao += (iter.hasNext() || minExtraContinentes > 0 ? ", " : " e ") + c.getNome();
        }

        if (minExtraContinentes > 0)
            this.descricao += " e mais " + minExtraContinentes + " de sua escolha";
    }
	
	 public boolean satisfeito() {
	        // conferir se é dono dos continentes desejados
	        for (Continente continente : continentes)
	            if (continente.getDono() != dono)
	                return false;

	        // contar continentes extras
	        if (minExtraContinentes > 0) {
	            int count = 0;

	            // iterar sobre os outros continentes
	            for (Continente continente : Board.continentes) {
	                if (continentes.contains(continente))
	                    continue;

	                if (continente.getDono() == dono)
	                    count++;
	            }

	            return count >= minExtraContinentes;
	        } else {
	            return true;
	        }
	    }
	

}
