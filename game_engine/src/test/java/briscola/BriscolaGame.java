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
	@Test
	public void testAGame() throws Exception {
		CardPlayer<ItalianCard> playerN = new TestPlayer<>("N");
		CardPlayer<ItalianCard> playerE = new TestPlayer<>("E");
		CardPlayer<ItalianCard> playerS = new TestPlayer<>("S");
		CardPlayer<ItalianCard> playerW = new TestPlayer<>("W");
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

		ItalianCard drawCard = firstPlayer.getHand().drawCard();
		mano.add(new AzioneDellaMano(playerN, drawCard));
		assertSame(playerE, be.getPlayerWeAreWaitingOn());
	}
}
