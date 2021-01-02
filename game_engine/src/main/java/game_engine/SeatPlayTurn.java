package game_engine;

public interface SeatPlayTurn {
	public void setCurrentLocation(BoardLocation location);
	public BoardLocation getCurrentLocation();
	public BoardLocation nextLocation();
	BoardLocation nextTurn();
}
