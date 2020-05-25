package MODEL;

class Board {
	
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
			new Territorio("Colombia",continentes[0]),
			new Territorio("Chile",continentes[0]),
			new Territorio("Argentina",continentes[0]),
			new Territorio("Brasil",continentes[0]),
			//America do Norte
			new Territorio("Mexico",continentes[1]),
			new Territorio("California",continentes[1]),
			new Territorio("NovaYork",continentes[1]),
			new Territorio("Labrador",continentes[1]),
			new Territorio("Ottawa",continentes[1]),
			new Territorio("Vancouver",continentes[1]),
			new Territorio("Mackenzie",continentes[1]),
			new Territorio("Alasca",continentes[1]),
			new Territorio("Groenlandia",continentes[1]),
			//Africa
			new Territorio("Egito",continentes[2]),
			new Territorio("Argelia",continentes[2]),
			new Territorio("Congo",continentes[2]),
			new Territorio("Sudao",continentes[2]),
			new Territorio("Madagascar",continentes[2]),
			new Territorio("Africa do Sul",continentes[2]),
			//Europa
			new Territorio("Islandia",continentes[3]),
			new Territorio("Inglaterra",continentes[3]),
			new Territorio("Suecia",continentes[3]),
			new Territorio("Alemanha",continentes[3]),
			new Territorio("Espanha",continentes[3]),
			new Territorio("Polonia",continentes[3]),
			new Territorio("Moscou",continentes[3]),
			//Asia
			new Territorio("Oriente Medio",continentes[4]),
			new Territorio("Aral",continentes[4]),
			new Territorio("Omsk",continentes[4]),
			new Territorio("Dudinka",continentes[4]),
			new Territorio("Siberia",continentes[4]),
			new Territorio("Tchita",continentes[4]),
			new Territorio("Mongolia",continentes[4]),
			new Territorio("Vladivostok",continentes[4]),
			new Territorio("China",continentes[4]),
			new Territorio("India",continentes[4]),
			new Territorio("Japao",continentes[4]),
			new Territorio("Vietna",continentes[4]),
			//Oceania
			new Territorio("Borneu",continentes[5]),
			new Territorio("Sumatra",continentes[5]),
			new Territorio("NovaGuinea",continentes[5]),
			new Territorio("Australia",continentes[5])};
	
	private static int[][] mapa = {
//		AM_SUL			AM_NORTE			AFRICA			EUROPA			ASIA						OCEANIA		
/*Col*/		{0,1,0,1,	1,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*chi*/		{1,0,1,1,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*arg*/		{0,1,0,1,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*bra*/		{1,1,1,0,	0,0,0,0,0,0,0,0,0,	0,1,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
//AM_NORTE			
/*mex*/		{1,0,0,0,	0,1,1,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*cal*/		{0,0,0,0,	1,0,1,0,1,1,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*ny*/		{0,0,0,0,	1,1,0,1,1,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*lab*/		{0,0,0,0,	0,0,1,0,1,0,0,0,1,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*ott*/		{0,0,0,0,	0,1,1,1,0,1,1,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*van*/		{0,0,0,0,	0,1,0,0,1,0,1,1,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*mak*/		{0,0,0,0,	0,0,0,0,1,1,0,1,1,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*ala*/		{0,0,0,0,	0,0,0,0,0,1,1,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,1,0,0,0,0,	0,0,0,0},
/*gro*/		{0,0,0,0,	0,0,0,1,0,0,1,0,0,	0,0,0,0,0,0,	1,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
//AFRICA			
/*egi*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,1,0,1,0,0,	0,0,0,0,1,1,0,	1,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*arg*/		{0,0,0,1,	0,0,0,0,0,0,0,0,0,	1,0,1,1,0,0,	0,0,0,0,1,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*con*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,1,0,1,0,1,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*sud*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	1,1,1,0,1,1,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*mad*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,1,0,1,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*afs*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,1,1,1,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
//EUROPA			
/*isl*/		{0,0,0,0,	0,0,0,0,0,0,0,0,1,	0,0,0,0,0,0,	0,1,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*ing*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	1,0,1,1,1,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*sue*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,1,0,0,0,0,1,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*ale*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,1,0,0,1,1,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*esp*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	1,1,0,0,0,0,	0,1,0,1,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*pol*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	1,0,0,0,0,0,	0,0,0,1,0,0,1,	1,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*mos*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,1,0,0,1,0,	1,1,1,0,0,0,0,0,0,0,0,0,	0,0,0,0},
//ASIA			
/*orm*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	1,0,0,0,0,0,	0,0,0,0,0,1,1,	0,1,0,0,0,0,0,0,0,1,0,0,	0,0,0,0},
/*ara*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,1,	1,0,1,0,0,0,0,0,1,1,0,0,	0,0,0,0},
/*oms*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,1,	0,1,0,1,0,0,1,0,1,0,0,0,	0,0,0,0},
/*dud*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,1,0,1,1,1,0,0,0,0,0,	0,0,0,0},
/*sib*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,1,0,1,0,1,0,0,0,0,	0,0,0,0},
/*tch*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,1,1,0,1,1,1,0,0,0,	0,0,0,0},
/*mon*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,1,1,0,1,0,0,1,0,0,0,	0,0,0,0},
/*vla*/		{0,0,0,0,	0,0,0,0,0,0,0,1,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,1,1,0,0,1,0,1,0,	0,0,0,0},
/*chi*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,1,1,0,0,1,1,1,0,1,1,1,	0,0,0,0},
/*ind*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	1,1,0,0,0,0,0,0,1,0,0,1,	0,1,0,0},
/*jap*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,1,1,0,0,0,	0,0,0,0},
/*vie*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,1,1,0,0,	1,0,0,0},
//OCEANIA			
/*bor*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,1,	0,0,1,1},
/*sum*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,1,0,0,	0,0,0,1},
/*nov*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	1,0,0,1},
/*aus*/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	1,1,1,0}			
	};
	
	public static Board getInstance() {
		if(singleton == null) {
			singleton = new Board();
		}
		return singleton;
	}
	
	
	
	public static boolean fazFronteira(Territorio a, Territorio b) {
		for(int i = 0; i < territorios.length; i++) {
			if(territorios[i] == a) {
				for(int j = 0; j < territorios.length; j++) {
					if(territorios[j] == b) {
						if(mapa[i][j] == 1) {
							return true;
						}
						else
							return false;
					}
				}
			}
		}
		System.out.print("ERRO_fazFronteira()");
		return false;
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
