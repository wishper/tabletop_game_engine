package game_engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class TestDeck {
	private Deck<Card> deck;

	@Before public void createNewDeck(){
		deck = new Deck<>();
	}

	@Test
	public void testAddCard() throws Exception {
		Card cardA = new Card();
		Card cardB = new Card();
		deck.addCard(cardA);
		deck.addCard(cardB);
		assertSame(cardA, deck.getCards().get(0));
		assertSame(cardB, deck.getCards().get(1));
	}

	@Test
	public void testDrawCard() throws Exception {
		Card cardA = new Card();
		Card cardB = new Card();
		deck.addCard(cardA);
		deck.addCard(cardB);
		assertSame(cardA, deck.getCards().get(0));
		Card drawnCard = deck.drawCard();
		assertSame(drawnCard, cardA);
		assertSame(cardB, deck.getCards().get(0));
	}

	@Test
	public void testPutCardToBack() throws Exception {
		Card cardA = new Card();
		Card cardB = new Card();
		Card cardC = new Card();
		deck.addCard(cardA);
		deck.addCard(cardB);
		deck.addCard(cardC);

		assertSame(cardA, deck.getCards().get(0));
		assertSame(cardB, deck.getCards().get(1));
		assertSame(cardC, deck.getCards().get(2));
		assertSame(cardA, deck.drawCard());
		assertEquals(2, deck.getCards().size());

		assertSame(cardB, deck.getCards().get(0));

		deck.addCardToBack(cardA);
		assertSame(cardB, deck.getCards().get(0));
		deck.drawCard();//B
		deck.drawCard();//C
		assertSame(cardA, deck.getCards().get(0));
	}
}