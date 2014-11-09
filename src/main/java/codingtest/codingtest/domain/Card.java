package codingtest.codingtest.domain;

import codingtest.codingtest.domain.enums.CardSuit;
import codingtest.codingtest.domain.enums.CardRank;

/**
 * This is the domain class that represents a card in a card game.
 */
public class Card {

    private CardRank type;
    private CardSuit suit;

	public Card(CardRank type, CardSuit suit) {
		super();
		this.type = type;
		this.suit = suit;
	}

	public CardRank getType() {
		return type;
	}

	public void setType(CardRank type) {
        this.type = type;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (suit != card.suit) return false;
        if (type != card.type) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (suit != null ? suit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Card[" + suit + ", " + type + "]";
    }
}
