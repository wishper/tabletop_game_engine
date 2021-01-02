package game_engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

	public static final BoardLocation NORTH = new BoardLocation("N");
	public static final BoardLocation EAST = new BoardLocation("E");
	public static final BoardLocation WEST = new BoardLocation("W");
	public static final BoardLocation SOUTH = new BoardLocation("S");
	public static final BoardLocation CENTER = new BoardLocation("C");

	SeatPlayTurn playTurn;

	private Map<BoardLocation, Player> seats = new HashMap<>(4);
	private Map<BoardLocation, BoardItem> items = new HashMap<>();


	public void setPlayerAt(Player player, BoardLocation location) {
		seats.put(location, player);
	}

	public Player getPlayerAt(BoardLocation location){
		return seats.get(location);
	}

	public void addPlayers(List<? extends Player> players) {
		if(players.size() == 2)
			playTurn = new ClockWisePlayTurn(NORTH, SOUTH);
		else if (players.size() == 4)
			playTurn = new ClockWisePlayTurn(NORTH, EAST, SOUTH, WEST);
		else
			throw new IllegalArgumentException("unsupported number of players");
	}

	public SeatPlayTurn getPlayTurn() {
		return playTurn;
	}

	public void addItemAt(BoardItem item, BoardLocation boardLocation) {
		items.put(boardLocation, item);
		item.setBoardLocation(boardLocation);
	}

}
