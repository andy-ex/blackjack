package codingtest.codingtest.domain.player;

import java.util.LinkedList;
import java.util.List;

import codingtest.codingtest.domain.Card;

/**
 * This is the class that represents a player to play in a card game.
 */
public class Player {

	private String name;
	private List<Card> cards = new LinkedList<Card>();
	private boolean isActive = true;

	public Player(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return total value of all cards that this player holds
	 */
	public int getTotal() {
		int total = 0;
		for (Card card : cards) {
			total += card.getType().getValue();
		}
		return total;
	}

    /**
     * Adds the card to the player's card list
     * @param card card to be added
     */
    public void addCard(Card card) {
        cards.add(card);
    }

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
