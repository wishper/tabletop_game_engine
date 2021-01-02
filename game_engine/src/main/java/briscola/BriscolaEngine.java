package briscola;

import game_engine.CardEngine;
import game_engine.CardPlayer;
import game_engine.Deck;
import game_engine.GameEngine;
import game_engine.standard_cards.ItalianCard;
import game_engine.standard_cards.ItalianCard.Seme;
import java.util.Random;

public class BriscolaEngine extends CardEngine<ItalianCard> implements GameEngine {

	private Seme briscola;

	public BriscolaEngine(int playerCount) {
		super(playerCount);
	}

	public BriscolaEngine(int playerCount, Random seed) {
		super(playerCount, seed);
	}

	@Override public void startGame() {
		Deck<ItalianCard> mazzo = getDeck();
		ItalianCard cartaDiBriscola = mazzo.drawCard();
		setBriscola(cartaDiBriscola.getSeme());

		for (CardPlayer<ItalianCard> giocatore : players) {
			giocatore.addToHand(mazzo.drawCards(3));
		}
	}

	private void setBriscola(Seme briscola) {
		this.briscola = briscola;
	}

	public Seme getBriscola() {
		return briscola;
	}

	@Override
	protected Deck<ItalianCard> buildDeck() {
		return ItalianCard.buildDeck();
	}

	public Mano nuovaMano() {
		return new Mano(briscola);
	}

	public static int forzaDellaCarta(ItalianCard carta) {
		int punteggio = punteggioDellaCarta(carta);
		if(punteggio == 0)
			return carta.getValore().ordinal() - 10;
		else
			return punteggio;
	}

	public static int punteggioDellaCarta(ItalianCard carta) {
		switch (carta.getValore()) {
		case ASSO:
			return 11;
		case RE:
			return 4;
		case CAVALLO:
			return 3;
		case FANTE:
			return 2;
		case TRE:
			return 10;
		default:
			return 0;
		}
	}
}
