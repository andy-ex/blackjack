package codingtest.codingtest.domain;

import java.util.List;

/**
 * This is the class that represents a deck of cards in a card game.
 */
public class Deck {

	private List<Card> cards;

	public Deck(List<Card> cards) {
		this.cards = cards;
	}

    public Card getNextCard() {
		Card card = cards.get(0);
		cards.remove(card);
		return card;
    }

	public List<Card> getCards() {
        return cards;
    }

	public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
