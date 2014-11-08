package codingtest.codingtest.domain;

import java.util.List;

/**
 * This is the class that represents a deck of cards in a card game.
 */
public class Deck {

	private List<Card> cards;

	public Deck(List<Card> cards) {
		super();
		this.cards = cards;
	}

	public List<Card> getCards() {
        return cards;
    }

	public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
