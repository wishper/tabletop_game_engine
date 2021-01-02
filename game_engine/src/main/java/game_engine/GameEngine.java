package game_engine;

import java.util.List;

public interface GameEngine {
	/**
	 * Prepare the game (create players, boards, decks etc.)
	 */
	void prepareGame();

	List<? extends Player> getPlayers();

	/**
	 * Starts a new game (starting first turn etc.)
	 */
	void startGame();

}
