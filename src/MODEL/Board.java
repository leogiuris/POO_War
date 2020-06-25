package MODEL;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	private static Board singleton = null;
	
	public static Continente[] continentes = {
			new Continente("America do Sul",2),
			new Continente("America do Norte",5),
			new Continente("Africa",3),
			new Continente("Europa",5),
			new Continente("Asia",7),
			new Continente("Oceania",2)};
	
	public static Territorio[] territorios = {
			//America do Sul
			new Territorio("Venezuela",continentes[0]),
			new Territorio("Peru",continentes[0]),
			new Territorio("Argentina",continentes[0]),
			new Territorio("Brasil",continentes[0]),
			//America do Norte
			new Territorio("Mexico",continentes[1]),
			new Territorio("California",continentes[1]),
			new Territorio("Texas",continentes[1]),
			new Territorio("NovaYork",continentes[1]),
			new Territorio("Vancouver",continentes[1]),
			new Territorio("Quebec",continentes[1]),
			new Territorio("Alasca",continentes[1]),
			new Territorio("Calgary",continentes[1]),
			new Territorio("Groenlandia",continentes[1]),
			//Africa
			new Territorio("Argelia",continentes[2]),
			new Territorio("Egito",continentes[2]),
			new Territorio("Angola",continentes[2]),
			new Territorio("Nigeria",continentes[2]),
			new Territorio("Somalia",continentes[2]),
			new Territorio("Africa do Sul",continentes[2]),
			//Europa
			new Territorio("Romenia",continentes[3]),
			new Territorio("Reino Unido",continentes[3]),
			new Territorio("Suecia",continentes[3]),
			new Territorio("Franca",continentes[3]),
			new Territorio("Espanha",continentes[3]),
			new Territorio("Italia",continentes[3]),
			new Territorio("Ucrania",continentes[3]),
			new Territorio("Polonia",continentes[3]),
			
			//Asia
			new Territorio("Estonia",continentes[4]),
			new Territorio("Russia",continentes[4]),
			new Territorio("Siberia",continentes[4]),
			new Territorio("Letonia",continentes[4]),
			new Territorio("Cazaquistao",continentes[4]),
			new Territorio("Turquia",continentes[4]),
			new Territorio("Mongolia",continentes[4]),
			new Territorio("Japao",continentes[4]),
			new Territorio("China",continentes[4]),
			new Territorio("Correia Do Norte",continentes[4]),
			new Territorio("Correia Do Sul",continentes[4]),
			new Territorio("Tailandia",continentes[4]),
			new Territorio("Bangladesh",continentes[4]),
			new Territorio("India",continentes[4]),
			new Territorio("Paquistao",continentes[4]),
			new Territorio("Ira",continentes[4]),
			new Territorio("Iraque",continentes[4]),
			new Territorio("Arabia Saudita",continentes[4]),
			new Territorio("Jordania",continentes[4]),
			new Territorio("Siria",continentes[4]),
			
			//Oceania
			new Territorio("Indonesia",continentes[5]),
			new Territorio("Nova Zelandia",continentes[5]),
			new Territorio("Perth",continentes[5]),
			new Territorio("Australia",continentes[5])};
	
	private static int[][] mapa = {
//			AM_SUL		AM_NORTE			AFRICA			EUROPA				ASIA										OCEANIA		
/*ven*/		{0,1,0,1,	1,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*per*/		{1,0,1,1,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*arg*/		{0,1,0,1,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*bra*/		{1,1,1,0,	0,0,0,0,0,0,0,0,0,	0,0,0,1,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
//AM_NORTE			
/*mex*/		{1,0,0,0,	0,1,1,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*cal*/		{0,0,0,0,	1,0,1,0,1,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*tex*/		{0,0,0,0,	1,1,0,1,1,1,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*ny*/		{0,0,0,0,	0,0,1,0,0,1,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*van*/		{0,0,0,0,	0,1,1,0,0,1,1,1,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*que*/		{0,0,0,0,	0,0,1,1,1,0,0,0,1,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*ala*/		{0,0,0,0,	0,0,0,0,1,0,0,1,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*cal*/		{0,0,0,0,	0,0,0,0,1,0,1,0,1,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*gro*/		{0,0,0,0,	0,0,0,0,0,1,0,1,0,	0,0,0,0,0,0,	0,1,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
//AFRICA			
/*arg*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,1,0,1,0,0,	0,0,0,0,1,1,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*egi*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	1,0,0,1,1,0,	1,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,	0,0,0,0},
/*ang*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,1,1,1,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*nig*/		{0,0,0,1,	0,0,0,0,0,0,0,0,0,	1,1,1,0,1,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*som*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,1,1,1,0,1,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,	0,0,0,0},
/*afs*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,1,0,1,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
//EUROPA			
/*rom*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,1,0,0,0,0,	0,0,0,0,0,1,1,1,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*reu*/		{0,0,0,0,	0,0,0,0,0,0,0,0,1,	0,0,0,0,0,0,	0,0,0,1,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*sue*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,1,0,1,0,0,	1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*fra*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,1,1,0,1,1,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*esp*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	1,0,0,0,0,0,	0,0,0,1,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*ita*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	1,0,0,0,0,0,	1,0,1,1,0,0,0,1,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*ucr*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	1,0,0,0,0,0,0,1,	0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*pol*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	1,0,0,0,0,1,1,0,	0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
//ASIA			
/*est*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,1,0,0,0,0,0,	0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*rus*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	1,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*sib*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*let*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,1,0,0,0,1,1,	1,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*caz*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,1,0,1,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*tur*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,1,0,	0,0,0,1,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,	0,0,0,0},
/*mon*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*jap*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*chi*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,1,1,1,0,0,1,1,0,0,1,1,0,0,0,0,0,	0,0,0,0},
/*coN*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,1,1,0,1,0,0,0,0,0,0,0,0,0,	0,1,0,0},
/*coS*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,1,1,0,1,1,1,0,0,0,0,0,0,	0,0,0,0},
/*tai*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,	0,0,0,0},
/*ban*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,1,1,0,1,0,0,0,0,0,0,	1,0,0,0},
/*ind*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,	1,0,0,0},
/*paq*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,1,0,0,0,1,	0,0,0,0},
/*ira*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,1,	0,0,0,0},
/*irq*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,1,	0,0,0,0},
/*ars*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,1,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,	0,0,0,0},
/*jor*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,1,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,	0,0,0,0},
/*sir*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,1,1,0,1,0,	0,0,0,0},

//OCEANIA			
/*ind*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,	0,1,0,1},
/*nze*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,	1,0,0,1},
/*per*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,1},
/*aus*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,	1,1,1,0}			
	};
	
	public static Board getInstance() {
		if(singleton == null) {
			singleton = new Board();
			completaMatriz();
		}
		return singleton;
	}
	
	private static void completaMatriz() {
		for(int i = 0; i<territorios.length; i++) {
			for (int j = 0; j < territorios.length; j++) {
				if(mapa[i][j] == 1)
					mapa[j][i] = 1;
				if(mapa[j][i] == 1)
					mapa[i][j] = 1;
			}
		}
	}
	
	public static boolean fazFronteira(Territorio a, Territorio b) {
		if(mapa[a.id][b.id] == 1) {
			return true;
		}
		else
			return false;
	}
	
	
	public static List<Territorio> getVizinhos(Territorio t) {
		List<Territorio> l = new ArrayList<Territorio>();
		for(Territorio elem: territorios) {
			if(fazFronteira(t,elem)) {
				l.add(elem);
			}
		}
		return l;
	}
	
 	static public void TESTE_imprimeFronteira(int index) {
		
		if(singleton == null) {
			singleton = new Board();
		}
		
		System.out.println(territorios[index].nome + " faz fronteira com:");
		for(int i = 0; i<mapa[index].length; i++) {
			if(mapa[index][i] == 1) {
				System.out.println(territorios[i].nome);
			}
		}
	}
	
	static public void TESTE_imprimeBoard() {
		
		if(singleton == null) {
			singleton = new Board();
		}
		
		System.out.println("\n--- IMPRIME BOARD ---");
		for(int i = 0; i<continentes.length; i++){
			continentes[i].TESTE_continente();
			System.out.println();
		}
		System.out.println();
	}
}
