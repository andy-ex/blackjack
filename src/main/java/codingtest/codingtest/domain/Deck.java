package codingtest.codingtest.domain;

import java.util.Queue;

/**
 * This is the class that represents a deck of cards in a card game.
 */
public class Deck {

	private Queue<Card> cards;

	public Deck(Queue<Card> cards) {
		super();
		this.cards = cards;
	}

    public Card getNextCard() {
        return cards.poll();
    }

	public Queue<Card> getCards() {
        return cards;
    }

	public void setCards(Queue<Card> cards) {
        this.cards = cards;
    }
}
