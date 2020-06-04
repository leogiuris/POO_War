package CONTROL;

import MODEL.Model;
public class Objetivo {
	public Objetivos obj;
	
	
	private enum Objetivos{
		vazio,
		ConquistarAsia,
		ConquistarEuropa,
		ConquistarAmericaDoSul,
		ConquistarAmericaDoNorte,
		ConquistarAfrica,
		ConquistarOceania,
		EliminarJogadorAzul,
		EliminarJogadorBranco,
		EliminarJogadorVerde,
		EliminarJogadorAmarelo,
		EliminarJogadorPreto,
		EliminarJogadorVermelho,
		Conquistar24Territorios
	}
	
	public boolean cumpriuObjetivo() {
		return true;
	}
	
	
}
