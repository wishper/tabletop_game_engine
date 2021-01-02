package game_engine;

public class BoardLocation {
	private final String ID;

	public BoardLocation(String ID) {
		this.ID = ID;
	}

	public String getID() {
		return ID;
	}

	@Override
	public String toString() {
		return ID;
	}
}
