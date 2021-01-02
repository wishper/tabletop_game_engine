/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package briscola;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import game_engine.Board;
import game_engine.CardPlayer;
import game_engine.standard_cards.ItalianCard;
import java.util.List;
import java.util.Random;
import org.junit.Test;

public class BriscolaSetup {
	@Test public void giocoCon4Giocatori() {
		BriscolaEngine briscola = new BriscolaEngine(4);
		briscola.prepareGame();
		List<CardPlayer<ItalianCard>> players = briscola.getPlayers();
		assertEquals(4, players.size());
	}

	@Test public void giocoCon2Giocatori() {
		BriscolaEngine briscola = new BriscolaEngine(2);
		briscola.prepareGame();
		List<CardPlayer<ItalianCard>> players = briscola.getPlayers();
		assertEquals(2, players.size());
	}

	@Test(expected = IllegalArgumentException.class) public void giocoCon3GiocatoriLancaEccezione() {
		new BriscolaEngine(3);
	}

	@Test public void giocoIniziaConMazzoCompleto() {
		BriscolaEngine briscolaEngine = new BriscolaEngine(4);
		briscolaEngine.prepareGame();
		assertEquals(40, briscolaEngine.getDeck().getCards().size());
	}

	@Test public void giocoHa4o2Posizioni() {
		BriscolaEngine briscolaEngine4 = new BriscolaEngine(4);
		briscolaEngine4.prepareGame();
		assertNotNull(briscolaEngine4.getBoard().getPlayerAt(Board.NORTH));
		assertNotNull(briscolaEngine4.getBoard().getPlayerAt(Board.EAST));
		assertNotNull(briscolaEngine4.getBoard().getPlayerAt(Board.SOUTH));
		assertNotNull(briscolaEngine4.getBoard().getPlayerAt(Board.WEST));

		BriscolaEngine briscolaEngine2 = new BriscolaEngine(2);
		briscolaEngine2.prepareGame();
		assertNotNull(briscolaEngine2.getBoard().getPlayerAt(Board.NORTH));
		assertNull(briscolaEngine2.getBoard().getPlayerAt(Board.EAST));
		assertNotNull(briscolaEngine2.getBoard().getPlayerAt(Board.SOUTH));
		assertNull(briscolaEngine2.getBoard().getPlayerAt(Board.WEST));
	}

	@Test public void giocoParteConMazzoAlCentro() {
		BriscolaEngine briscolaEngine4 = new BriscolaEngine(4, new Random(0));
		briscolaEngine4.prepareGame();
		assertEquals(Board.CENTER, briscolaEngine4.getDeck().getBoardLocation());
		ItalianCard topCard = briscolaEngine4.getDeck().getCards().get(0);
		briscolaEngine4.startGame();
		assertEquals(topCard.getSeme(), briscolaEngine4.getBriscola());
		assertEquals(ItalianCard.Seme.BASTONI, briscolaEngine4.getBriscola());
	}

	@Test public void giocoParteConManoDiTreCartePerOgniGiocatore() {
		BriscolaEngine briscolaEngine4 = new BriscolaEngine(4);
		briscolaEngine4.prepareGame();
		briscolaEngine4.startGame();
		assertEquals(40-4*3, briscolaEngine4.getDeck().getCards().size());
		for (CardPlayer<ItalianCard> player: briscolaEngine4.getPlayers()) {
			assertEquals(3, player.getHand().getCards().size());
		}
	}

}