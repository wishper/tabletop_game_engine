package briscola;

import game_engine.Player;

public class RisultatoMano {
	private Player giocatoreVincente;
	private int punti;

	public RisultatoMano(Player giocatoreVincente, int punti) {
		this.giocatoreVincente = giocatoreVincente;
		this.punti = punti;
	}

	public Player getGiocatoreVincente() {
		return giocatoreVincente;
	}

	public int getPunti() {
		return punti;
	}

}
