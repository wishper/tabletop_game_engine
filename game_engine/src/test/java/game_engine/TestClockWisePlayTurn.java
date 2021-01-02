package game_engine;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestClockWisePlayTurn {

	@Test
	public void test2PlayerTurns() {
		ClockWisePlayTurn clockWisePlayTurn = new ClockWisePlayTurn(Board.NORTH, Board.SOUTH);
		clockWisePlayTurn.setCurrentLocation(Board.NORTH);
		assertEquals(Board.SOUTH, clockWisePlayTurn.nextTurn());
		assertEquals(Board.NORTH, clockWisePlayTurn.nextTurn());
	}

	@Test
	public void test4PlayerTurns() {
		ClockWisePlayTurn clockWisePlayTurn = new ClockWisePlayTurn(Board.NORTH, Board.EAST, Board.SOUTH, Board.WEST);
		clockWisePlayTurn.setCurrentLocation(Board.NORTH);
		assertEquals(Board.EAST, clockWisePlayTurn.nextTurn());
		assertEquals(Board.SOUTH, clockWisePlayTurn.nextTurn());
		assertEquals(Board.WEST, clockWisePlayTurn.nextTurn());
		assertEquals(Board.NORTH, clockWisePlayTurn.nextTurn());
	}

}
