package codingtest.codingtest.core.util;

import codingtest.codingtest.core.util.shuffle.impl.SimpleShuffler;
import codingtest.codingtest.domain.Card;
import codingtest.codingtest.domain.Deck;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class DeckHelperTest {

    private Deck deck;

    @Before
    public void setUp() throws Exception {
        deck = DeckHelper.getInstance().createDeck();
    }

    @Test
    public void shouldCreateNotNullDeck() throws Exception {
        assertNotNull("Created deck should not be null", deck);
    }

    @Test
    public void shouldCreateDeckWithoutEqualCards() throws Exception {
        //Create a set to remove all possible equal cards
        Set<Card> cards = new HashSet<Card>(deck.getCards());

        assertEquals("Deck should not contain equal cards", deck.getCards().size(), cards.size());
    }

    @Test
    public void shouldShuffleDeck() throws Exception {
        Deck shuffledDeck = new Deck(deck.getCards());

        DeckHelper.setShuffler(new SimpleShuffler());
        DeckHelper.getInstance().shuffleDeck(shuffledDeck);

        assertEquals("Shuffled deck should be the same size as not shuffled one", deck.getCards().size(), shuffledDeck.getCards().size() );
        assertNotEquals("Deck should be shuffled as well", deck, shuffledDeck);
    }
}