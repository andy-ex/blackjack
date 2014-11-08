package codingtest.codingtest.domain;

import codingtest.codingtest.domain.enums.CardSuit;
import codingtest.codingtest.domain.enums.CardType;

/**
 * This is the domain class that represents a card in a card game.
 */
public class Card {

    private CardType type;
    private CardSuit suit;

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }
}
