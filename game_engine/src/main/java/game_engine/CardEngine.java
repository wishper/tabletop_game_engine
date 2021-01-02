package game_engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class CardEngine<T extends Card> implements GameEngine {
	private Board board;
	private Deck<T> deck;
	protected List<CardPlayer<T>> players;
	private Random randomSeed;

	public CardEngine (int playerCount){
		this(playerCount, new Random());
	}

	public CardEngine (int playerCount, Random seed){
		if(playerCount != 2 && playerCount != 4)
			throw new IllegalArgumentException("Only 2 or 4 players");
		randomSeed = seed;
		players = new ArrayList<>(playerCount);
		for (int x = 0; x < playerCount; x++) {
			CardPlayer<T> player = new DefaultCardPlayer<>();
			players.add(player);
		}
	}

	public Board getBoard() {
		return board;
	}

	@Override
	public void prepareGame() {
		board = new Board();
		deck = buildDeck();
		board.addItemAt(deck, Board.CENTER);
		board.addPlayers(players);
		SeatPlayTurn playTurn = getBoard().getPlayTurn();
		for (Player player : players) {
			getBoard().setPlayerAt(player, playTurn.getCurrentLocation());
			playTurn.nextTurn();
		}
		getDeck().shuffle(randomSeed);
	}

	protected abstract Deck<T> buildDeck();

	public Deck<T> getDeck() {
		return deck;
	}

	@Override public List<CardPlayer<T>> getPlayers() {
		return players;
	}

}
