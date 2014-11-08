package codingtest.codingtest.core.util;

import java.util.Collections;
import java.util.LinkedList;

import codingtest.codingtest.domain.Card;
import codingtest.codingtest.domain.Deck;
import codingtest.codingtest.domain.enums.CardSuit;
import codingtest.codingtest.domain.enums.CardType;

public class DeckHelper {

	/**
	 * creates new deck with cards
	 * 
	 * @return
	 */
	public static Deck createDeck() {
		Deck deck;
		LinkedList<Card> cards = new LinkedList<Card>();
		for (CardSuit suit : CardSuit.values()) {
			for (CardType type : CardType.values()) {
				Card card = new Card(type, suit);
				cards.add(card);
			}
		}
		deck = new Deck(cards);
		return deck;
	}

	public static void shuffleDeck(Deck deck) {
        Collections.shuffle(deck.getCards());
    }

}
