package briscola;

import static org.junit.Assert.assertSame;

import game_engine.Board;
import game_engine.CardPlayer;
import game_engine.DefaultCardPlayer;
import game_engine.TestPlayer;
import game_engine.standard_cards.ItalianCard;
import java.util.Random;
import org.junit.Test;

public class BriscolaGame {
	private static final class AlwaysPlayFirstCardPlayer extends TestPlayer<ItalianCard> {
		private AlwaysPlayFirstCardPlayer(String pName) {
			super(pName);
		}

		@Override
		public void askForMove(Object pContext) {
			if (pContext instanceof Mano) {
				Mano mano = (Mano) pContext;
				mano.add(new AzioneDellaMano(AlwaysPlayFirstCardPlayer.this, getHand().drawCard()));
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testAGame() throws Exception {
		CardPlayer<ItalianCard> playerN = new AlwaysPlayFirstCardPlayer("N");
		CardPlayer<ItalianCard> playerE = new AlwaysPlayFirstCardPlayer("E");
		CardPlayer<ItalianCard> playerS = new AlwaysPlayFirstCardPlayer("S");
		CardPlayer<ItalianCard> playerW = new AlwaysPlayFirstCardPlayer("W");
		BriscolaEngine be = new BriscolaEngine(new Random(0), playerN, playerE, playerS, playerW);
		be.prepareGame();
		be.startGame();

		be.getBoard().getPlayTurn().setCurrentLocation(Board.NORTH);
		DefaultCardPlayer<ItalianCard> firstPlayer = (DefaultCardPlayer<ItalianCard>)be.getBoard().getPlayerAt(Board.NORTH);
		assertSame(playerN, firstPlayer);
		System.out.println("---");
		System.out.println(firstPlayer.getHand());

		Mano mano = be.nuovaMano();
		be.askPlayerForMove(firstPlayer, mano);
		assertSame(playerE, be.getPlayerWeAreWaitingOn());
	}
}
