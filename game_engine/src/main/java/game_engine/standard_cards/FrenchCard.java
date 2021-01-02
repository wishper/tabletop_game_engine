package game_engine.standard_cards;

import game_engine.Card;
import game_engine.Deck;
import game_engine.standard_cards.ItalianCard.Valore;

public class FrenchCard extends Card {
	public enum Suit {
		HEARTS, DIAMONDS, SPADES, CLUBS
	}

	public enum Value {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}

	public static Deck<FrenchCard> buildDeck(){
		Deck<FrenchCard> deck = new Deck<>();
		for (Suit suit: Suit.values()) {
			for (Value value: Value.values()) {
				deck.addCard(new FrenchCard(suit, value));
			}
		}
		return deck;
	}

	private final Suit suit;
	private final Value value;

	public FrenchCard(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}

	public Suit getSuit() {
		return suit;
	}

	public Valore getValue() {
		Valore value = getValue();
		return value;
	}

	@Override
	public String toString() {
		return value + " of " + suit;
	}

}
