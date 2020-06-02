package MODEL;

public class ConquistarNPaises extends CartaObjetivo {

    private final int nTerritorios;
    private final int minExercitos;

    public ConquistarNPaises(int nTerritorios) {
        this(nTerritorios, 1);
    }

    public ConquistarNPaises(int nTerritorios, int minExercitos) {
        this.nTerritorios = nTerritorios;
        this.minExercitos = minExercitos;
        this.descricao = "conquistar " + nTerritorios
                + " território" + (nTerritorios > 2 ? "s" : "");
        if (minExercitos > 1)
            this.descricao += " com pelo menos " + minExercitos + " exércitos cada";
    }

    @Override
    public boolean satisfeito() {
        int count = 0;
        for (Territorio territorios : Board.territorios)
            if (territorios.getDono() == dono && territorios.getQtdExercitos() >= minExercitos)
                count++;
        return count >= nTerritorios;
    }
    
}

