package codingtest.codingtest.domain;

import java.util.LinkedList;

/**
 * This is the class that represents a deck of cards in a card game.
 */
public class Deck {

	private LinkedList<Card> cards;

	public Deck(LinkedList<Card> cards) {
		super();
		this.cards = cards;
	}

	public LinkedList<Card> getCards() {
        return cards;
    }

	public void setCards(LinkedList<Card> cards) {
        this.cards = cards;
    }
}
