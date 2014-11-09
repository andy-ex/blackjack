package codingtest.codingtest.core.util.shuffle.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import codingtest.codingtest.core.util.shuffle.Shuffler;
import codingtest.codingtest.domain.Card;
import codingtest.codingtest.domain.Deck;

/**
 * All shufflers in this implementation of game use one algorithm, it is now
 * only for possibility to choose
 * 
 */
public class RiffleShuffler implements Shuffler {

	public Deck shuffle(Deck deck) {
		Card[] cards = new Card[deck.getCards().size()];
		List<Card> cardList = Arrays.asList(deck.getCards().toArray(cards));
		Collections.shuffle(cardList);

		List<Card> shuffledQueue = new LinkedList<Card>(cardList);

		deck.setCards(shuffledQueue);
		return deck;
	}

}
