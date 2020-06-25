package MODEL;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import MODEL.Player.Cor;

public class CartaObjetivo {
	protected Objetivos descricao;
	static private List<CartaObjetivo> baralho = new ArrayList<CartaObjetivo>();
	protected Player dono;

	
	
	protected enum Objetivos{
		Conquistar_Asia,
		Conquistar_Europa,
		Conquistar_America_Do_Sul,
		Conquistar_America_Do_Norte,
		Conquistar_Africa,
		Conquistar_Oceania,
		Eliminar_Jogador_Azul,
		Eliminar_Jogador_Branco,
		Eliminar_Jogador_Verde,
		Eliminar_Jogador_Amarelo,
		Eliminar_Jogador_Preto,
		Eliminar_Jogador_Vermelho,
		Conquistar_24_Territorios
	}
	
	private CartaObjetivo(Objetivos o) {
        this.descricao = o;
        
    }
	
	static private void loadObjetivos() {
		if(!baralho.isEmpty())
			baralho.clear();
		
		for(Objetivos o: Objetivos.values()) {
			baralho.add(new CartaObjetivo(o));
		}
	}
	
	static public CartaObjetivo sorteioObjetivo(Player p){
		
		if(baralho.isEmpty()) {
			loadObjetivos();
		}
		
		Random random = new Random();
		int numero = random.nextInt(baralho.size());
		baralho.get(numero).dono = p;
		return baralho.remove(numero); 
	}
	
	static public CartaObjetivo loadCarta(String d) {
		
		for(Objetivos o: Objetivos.values()) {
			if(o.toString().compareTo(d) == 0)
				return new CartaObjetivo(o);
		}
		
		for(CartaObjetivo o: baralho) {
			if(o.descricao.toString() == d) {
				int index = baralho.indexOf(o);
				return baralho.remove(index);
			}
		}
		
		System.out.println(d);
		return null;
	}

	 // Checagem para todos os objetivos
	public boolean cumpriuObjetivo() {
		Player p = Player.getJogadorDaVez();
		if(this.descricao == Objetivos.Conquistar_24_Territorios) {
			
			if(p.territorios.size() >= 24) {
				return true;
			}
			else
				return false;
		}
		
		if(this.descricao == Objetivos.Conquistar_Asia) {
			if(Board.continentes[4].getDono() == p) {
				return true;
			}
			else
				return false;
		}
		
		if(this.descricao == Objetivos.Conquistar_Europa) {
			if(Board.continentes[3].getDono() == p) {
				return true;
			}
			else
				return false;
		}
		
		if(this.descricao == Objetivos.Conquistar_America_Do_Sul) {
			if(Board.continentes[0].getDono() == p) {
				return true;
			}
			else
				return false;
		}
		
		if(this.descricao == Objetivos.Conquistar_America_Do_Norte) {
			if(Board.continentes[1].getDono() == p) {
				return true;
			}
			else
				return false;
		}
		
		if(this.descricao == Objetivos.Conquistar_Africa) {
			if(Board.continentes[2].getDono() == p) {
				return true;
			}
			else
				return false;
		}
		
		if(this.descricao == Objetivos.Conquistar_Oceania) {
			if(Board.continentes[5].getDono() == p) {
				return true;
			}
			else
				return false;
		}
		
		if(this.descricao == Objetivos.Eliminar_Jogador_Azul) {
			Player op = Player.getJogadorPorCor(Cor.azul);
			
			if(op == null || op == this.dono) {
				descricao = Objetivos.Conquistar_24_Territorios;
				return cumpriuObjetivo();
			}
			
			if(op.eliminado) {
				if(op.quemEliminou == p) {
					return true;
				}
				else {
					descricao = Objetivos.Conquistar_24_Territorios;
					return cumpriuObjetivo();
				}	
			}
			else
				return false;
		}
		
		if(this.descricao == Objetivos.Eliminar_Jogador_Amarelo) {
			Player op = Player.getJogadorPorCor(Cor.amarelo);
			
			if(op == null || op == this.dono) {
				descricao = Objetivos.Conquistar_24_Territorios;
				return cumpriuObjetivo();
			}
			
			if(op.eliminado) {
				if(op.quemEliminou == p) {
					return true;
				}
				else {
					descricao = Objetivos.Conquistar_24_Territorios;
					return cumpriuObjetivo();
				}	
			}
			else
				return false;
		}
		
		if(this.descricao == Objetivos.Eliminar_Jogador_Branco) {
			Player op = Player.getJogadorPorCor(Cor.branco);
			
			if(op == null || op == this.dono) {
				descricao = Objetivos.Conquistar_24_Territorios;
				return cumpriuObjetivo();
			}
			
			if(op.eliminado) {
				if(op.quemEliminou == p) {
					return true;
				}
				else {
					descricao = Objetivos.Conquistar_24_Territorios;
					return cumpriuObjetivo();
				}	
			}
			else
				return false;
		}
		
		if(this.descricao == Objetivos.Eliminar_Jogador_Preto) {
			Player op = Player.getJogadorPorCor(Cor.preto);
			
			if(op == null || op == this.dono) {
				descricao = Objetivos.Conquistar_24_Territorios;
				return cumpriuObjetivo();
			}
			
			if(op.eliminado) {
				if(op.quemEliminou == p) {
					return true;
				}
				else {
					descricao = Objetivos.Conquistar_24_Territorios;
					return cumpriuObjetivo();
				}	
			}
			else
				return false;
		}
		
		if(this.descricao == Objetivos.Eliminar_Jogador_Verde) {
			Player op = Player.getJogadorPorCor(Cor.verde);
			
			if(op == null || op == this.dono) {
				descricao = Objetivos.Conquistar_24_Territorios;
				return cumpriuObjetivo();
			}
			
			if(op.eliminado) {
				if(op.quemEliminou == p) {
					return true;
				}
				else {
					descricao = Objetivos.Conquistar_24_Territorios;
					return cumpriuObjetivo();
				}	
			}
			else
				return false;
		}
		
		if(this.descricao == Objetivos.Eliminar_Jogador_Vermelho) {
			Player op = Player.getJogadorPorCor(Cor.vermelho);
			
			if(op == null || op == this.dono) {
				descricao = Objetivos.Conquistar_24_Territorios;
				return cumpriuObjetivo();
			}
			
			if(op.eliminado) {
				if(op.quemEliminou == p) {
					return true;
				}
				else {
					descricao = Objetivos.Conquistar_24_Territorios;
					return cumpriuObjetivo();
				}	
			}
			else
				return false;
		}
		
		System.out.println("ERRO - cumpriuObjetivo");
		return false;
		
	}
 
}
