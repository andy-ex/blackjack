package codingtest.codingtest.core.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import codingtest.codingtest.domain.Card;
import codingtest.codingtest.domain.Deck;
import codingtest.codingtest.domain.enums.CardSuit;
import codingtest.codingtest.domain.enums.CardRank;

public class DeckHelper {

	/**
	 * creates new deck with cards
	 * 
	 * @return
	 */
	public static Deck createDeck() {
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

	public static void shuffleDeck(Deck deck) {
        Card[] cards = new Card[deck.getCards().size()];
        List<Card> cardList = Arrays.asList(deck.getCards().toArray(cards));
        Collections.shuffle(cardList);

		List<Card> shuffledQueue = new LinkedList<Card>(cardList);

        deck.setCards(shuffledQueue);
    }

}
