package game_engine;

import java.util.List;

public interface CardPlayer<T extends Card> extends Player {
	Deck<T> getHand();
	void addToHand(List<T> drawCards);
	void askForMove(Object context);
}
