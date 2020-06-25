package MODEL;

import java.awt.Desktop;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.nio.file.*;


import com.google.gson.*;
	
public class SaveData {

	
	public static boolean saveGame(File f) {

		DataPlayer[] d_array = new DataPlayer[Player.getNumJogadores()];
		
		Gson gobj = new GsonBuilder().create();
		
		for (int i = 0; i < Player.jogadores.size(); i++) {
			d_array[i] = new DataPlayer( Player.jogadores.get(i) );
		}
		
		System.out.println("salvando...");

		try {
			Writer writer = new FileWriter(f.getPath());
			
			gobj.toJson(d_array, writer);
			writer.flush();
			writer.close();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

	
	public static void loadGame(File f) {
		
		Player.ResetPlayers();
		
		Gson gson = new Gson();
		String json;
		try {
			json = Files.readString(f.toPath());
			DataPlayer[] dp_array = gson.fromJson(json , DataPlayer[].class);
			System.out.println(json);
			for(DataPlayer dp: dp_array) {
				dp.teste_print_obj();
				dp.loadData();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

class DataPlayer{
	
	String[] data = new String[3];
	
	boolean[] estado = new boolean[3];
	
	int[] tropas_d = new int[7]; 
	
	int ordem;
	
	List<Integer> id_territorios;
	List<Integer> tropas_t ;
	List<Integer> idCartas_t;

	DataPlayer(Player p){
		
		this.data = new String[] {p.nome, p.cor.toString(), p.getObjetivo()};

		this.estado = new boolean[] {p.eliminado, p.jogando, p.conquistouTerritorio};
		
		this.tropas_d = new int[] {
				p.exercitosRodada,
				p.bonusContinente[0],
				p.bonusContinente[1],
				p.bonusContinente[2],
				p.bonusContinente[3],
				p.bonusContinente[4],
				p.bonusContinente[5]				
		};

		ordem = Player.jogadores.indexOf(p);
		
		id_territorios = new ArrayList<Integer>();
		tropas_t = new ArrayList<Integer>();
		
		for(Territorio t: p.territorios) {
			id_territorios.add(t.id);
			tropas_t.add(t.getQtdExercitos());
		}
		
		idCartas_t = new ArrayList<Integer>();
		for(CartaTerritorio ct: p.maoCartas) {
			idCartas_t.add(ct.id);
		}	
	}
	
	void teste_print_obj() {
		System.out.println("\n---- TESTE JSON READ ----\n\n");
		
		System.out.println("data:");
		for(String s: data) {
			System.out.println(s);
		}
		System.out.println("estados");
		for(boolean b: estado) {
			System.out.println(b);
		}
		System.out.println("tropas_d");
		for(Integer i: tropas_d) {
			System.out.println(i);
		}
		System.out.println("id_territorios");
		for(Integer i: id_territorios) {
			System.out.println(i);
		}
		
		
	}
	
	void loadData() {
		Player.loadJogador(this.data, this.estado, this.tropas_d, this.ordem,
				this.id_territorios, this.tropas_t, this.idCartas_t);
	}
	
}







