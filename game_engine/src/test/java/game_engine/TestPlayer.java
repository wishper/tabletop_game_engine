package game_engine;

public class TestPlayer<T extends Card> extends DefaultCardPlayer<T> {
	private String name;

	public TestPlayer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
