package codingtest.codingtest.core.util.shuffle;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import codingtest.codingtest.domain.Card;
import codingtest.codingtest.domain.Deck;

/**
 * This name is just for 
 *
 */
public class SimpleShuffler implements Shuffler {

	public void shuffle(Deck deck) {
		Card[] cards = new Card[deck.getCards().size()];
		List<Card> cardList = Arrays.asList(deck.getCards().toArray(cards));
		Collections.shuffle(cardList);

		List<Card> shuffledQueue = new LinkedList<Card>(cardList);

		deck.setCards(shuffledQueue);
	}

}
