package game_engine.standard_cards;

import game_engine.Card;
import game_engine.Deck;

public class ItalianCard extends Card {
	public enum Seme {
		ORO, QUADRO, COPPE, BASTONI
	}

	public enum Valore {
		ASSO, DUE, TRE, QUATTRO, CINQUE, SEI, SETTE, FANTE, CAVALLO, RE
	}

	public static Deck<ItalianCard> buildDeck(){
		Deck<ItalianCard> deck = new Deck<>();
		for (Seme seme: Seme.values()) {
			for (Valore valore : Valore.values()) {
				deck.addCard(new ItalianCard(seme, valore));
			}
		}
		return deck;
	}

	private final Seme seme;
	private final Valore valore;

	public ItalianCard(Seme seme, Valore valore) {
		this.seme = seme;
		this.valore = valore;
	}

	public Seme getSeme() {
		return seme;
	}

	public Valore getValore() {
		return valore;
	}

	@Override
	public String toString() {
		return valore + " di " + seme;
	}

}
