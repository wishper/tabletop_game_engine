package briscola;

import game_engine.Player;
import game_engine.standard_cards.ItalianCard;

public class AzioneDellaMano {
	private final Player giocatore;
	private final ItalianCard carta;

	public AzioneDellaMano(Player giocatore, ItalianCard carta) {
		this.giocatore = giocatore;
		this.carta = carta;
	}

	public Player getGiocatore() {
		return giocatore;
	}

	public ItalianCard getCarta() {
		return carta;
	}
}
