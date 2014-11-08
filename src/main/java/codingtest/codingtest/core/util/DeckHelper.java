package codingtest.codingtest.core.util;

import java.util.*;

import codingtest.codingtest.domain.Card;
import codingtest.codingtest.domain.Deck;
import codingtest.codingtest.domain.enums.CardSuit;
import codingtest.codingtest.domain.enums.CardType;

public class DeckHelper {

	/**
	 * creates new deck with cards
	 * 
	 * @return
	 */
	public static Deck createDeck() {
		Deck deck;
		Queue<Card> cards = new PriorityQueue<Card>();
		for (CardSuit suit : CardSuit.values()) {
			for (CardType type : CardType.values()) {
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

        Queue<Card> shuffledQueue = new PriorityQueue<Card>(cardList);

        deck.setCards(shuffledQueue);

    }

}
