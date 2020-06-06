package MODEL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;

public class SaveData {

	public static void saveGame() {

		Player p = Player.getJogadorDaVez();
		
		String [] data = { p.nome, p.cor.toString(), p.getObjetivo() };
		
		boolean [] estado = { p.eliminado, p.jogando, p.conquistouTerritorio };
		
		int[] tropas_d = {
				p.exercitosRodada,
				p.bonusContinente[0], p.bonusContinente[1], p.bonusContinente[2], 
				p.bonusContinente[3], p.bonusContinente[4], p.bonusContinente[5], 
		};
		
		int ordem = Player.jogadores.indexOf(p);
		
		List<Integer> id_territorios = new ArrayList<Integer>();
		List<Integer> tropas_t = new ArrayList<Integer>();
		for(Territorio t: p.territorios) {
			id_territorios.add(t.index);
			tropas_t.add(t.getQtdExercitos());
		}
		
		List<Integer> idCartas_t = new ArrayList<Integer>();
		for(CartaTerritorio ct: p.maoCartas) {
			idCartas_t.add(ct.id);
		}
		
		Player.jogadores.remove(p);
		Player.loadJogador(data, estado, tropas_d, ordem, id_territorios, tropas_t, idCartas_t);
	}
	

	
	public static void loadGame() {
		
	}
	
}
