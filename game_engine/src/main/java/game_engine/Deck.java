package game_engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck<T extends Card> extends BoardItem {

	private final List<T> cards = new ArrayList<>();

	public List<T> getCards() {
		return Collections.unmodifiableList(cards);
	}

	public void addCard(T card){
		cards.add(card);
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public void shuffle(Random seed) {
		Collections.shuffle(cards, seed);
	}

	public T drawCard() {
		return cards.remove(0);
	}

	public List<T> drawCards(int cardsToDraw) {
		List<T> drawnCards = new LinkedList<>();
		for (int i = 0; i < cardsToDraw; i++) {
			drawnCards.add(drawCard());
		}
		return drawnCards;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("[");
		for (T t: cards) {
			stringBuilder.append(t.toString()).append(" ");
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
}
