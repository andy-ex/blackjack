package codingtest.codingtest.domain.player;

import java.util.List;

import codingtest.codingtest.domain.Card;

public class Player {

	private List<Card> cards;
	private boolean isActive;

	public Player(List<Card> cards, boolean isActive) {
		this.cards = cards;
		this.isActive = isActive;
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

}
