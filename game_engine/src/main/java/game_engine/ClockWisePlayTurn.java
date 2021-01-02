package game_engine;

import java.util.HashMap;
import java.util.Map;

public class ClockWisePlayTurn implements SeatPlayTurn {

	Map<BoardLocation, BoardLocation> circleTurn = new HashMap<>();
	private BoardLocation currentLocation;

	public ClockWisePlayTurn(BoardLocation ... locations) {
		setCurrentLocation(locations[0]);
		for (int i = 0; i < locations.length -1; i++) {
			BoardLocation iterLocation = locations[i];
			BoardLocation nextLocation = locations[i+1];
			circleTurn.put(iterLocation, nextLocation);
		}
		circleTurn.put(locations[locations.length-1], locations[0]);
	}

	@Override
	public BoardLocation nextLocation() {
		return circleTurn.get(currentLocation);
	}

	@Override public BoardLocation nextTurn(){
		BoardLocation nextLocation = nextLocation();
		return currentLocation = nextLocation;
	}

	@Override
	public void setCurrentLocation(BoardLocation location) {
		this.currentLocation = location;
	}

	@Override
	public BoardLocation getCurrentLocation() {
		return this.currentLocation;
	}

}
