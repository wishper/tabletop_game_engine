package game_engine;

import java.util.List;

public class DefaultCardPlayer<T extends Card> implements CardPlayer<T> {

	private Deck<T> hand = new Deck<>();

	@Override
	public Deck<T> getHand() {
		return hand;
	}

	@Override
	public void addToHand(List<T> drawCards) {
		for (T card : drawCards) {
			hand.addCard(card);
		}
	}

}
