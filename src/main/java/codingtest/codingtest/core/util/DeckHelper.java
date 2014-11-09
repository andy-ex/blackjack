package codingtest.codingtest.core.util;

import java.util.LinkedList;
import java.util.List;

import codingtest.codingtest.core.util.shuffle.Shuffler;
import codingtest.codingtest.domain.Card;
import codingtest.codingtest.domain.Deck;
import codingtest.codingtest.domain.enums.CardRank;
import codingtest.codingtest.domain.enums.CardSuit;

public class DeckHelper {

	// singleton
	private static final DeckHelper INSTANCE = new DeckHelper();

	private static Shuffler shuffler;

	private DeckHelper() {
	}

	public static DeckHelper getInstance() {
		return INSTANCE;
	}

	/**
	 * creates new deck with cards
	 * 
	 * @return
	 */
	public Deck createDeck() {
		Deck deck;
		List<Card> cards = new LinkedList<Card>();
		for (CardSuit suit : CardSuit.values()) {
			for (CardRank type : CardRank.values()) {
				Card card = new Card(type, suit);
				cards.add(card);
			}
		}
		deck = new Deck(cards);
		return deck;
	}

    /**
     * Shuffles specified deck
     * @param deck deck to shuffle
     */
	public void shuffleDeck(Deck deck) {
		shuffler.shuffle(deck);
    }

	public static Shuffler getShuffler() {
		return shuffler;
	}

	public static void setShuffler(Shuffler shuffler) {
		DeckHelper.shuffler = shuffler;
	}

}
