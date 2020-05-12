package MODEL;

public class Board {
	
	static Continente[] continentes = {
			new Continente("America do Sul",2),
			new Continente("America do Norte",5),
			new Continente("Africa",3),
			new Continente("Europa",5),
			new Continente("Asia",7),
			new Continente("Oceania",2)};
	
	static Territorio[] territorios = {
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
	
	private int[][] mapa = {
//		AM_SUL			AM_NORTE			AFRICA			EUROPA			ASIA						OCEANIA		
/*Col*/		{0,1,0,1,	1,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*chi*/		{1,0,1,1,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*arg*/		{0,1,0,1,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/*bra*/		{1,1,1,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
//AM_NORTE			
/**/		{1,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
//AFRICA			
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
//EUROPA			
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
//ASIA			
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
//OCEANIA			
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0},
/**/		{0,0,0,0,	0,0,0,0,0,0,0,0,0,	0,0,0,0,0,0,	0,0,0,0,0,0,0,	0,0,0,0,0,0,0,0,0,0,0,0,	0,0,0,0}			
	};
	
	
	
	public void TESTE_imprimeFronteira(int index) {
		System.out.println(territorios[index].nome + " faz fronteira com:");
		for(int i = 0; i<mapa[index].length; i++) {
			if(mapa[index][i] == 1) {
				System.out.println(territorios[i].nome);
			}
		}
	}
	
	public void TESTE_imprimeBoard() {
		for(int i = 0; i<continentes.length; i++){
			continentes[i].Imprime();
			System.out.println();
		}
	}
}
