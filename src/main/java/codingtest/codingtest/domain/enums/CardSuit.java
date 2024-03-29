package codingtest.codingtest.domain.enums;

/**
 * This enum represents the suit of a card
 */
public enum CardSuit {

    HEARTS, DIAMONDS, CLUBS, SPADES;

    @Override
    public String toString() {
        return this.name();
    }


}
