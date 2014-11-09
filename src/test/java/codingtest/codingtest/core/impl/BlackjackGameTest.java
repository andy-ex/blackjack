package codingtest.codingtest.core.impl;

import codingtest.codingtest.core.util.DeckHelper;
import codingtest.codingtest.core.util.shuffle.impl.SimpleShuffler;
import codingtest.codingtest.domain.Card;
import codingtest.codingtest.domain.Deck;
import codingtest.codingtest.domain.enums.CardRank;
import codingtest.codingtest.domain.enums.CardSuit;
import codingtest.codingtest.domain.player.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BlackjackGameTest {

    private BlackjackGame game;
    private List<Player> players;
    private Deck deck;

    @Before
    public void setUp() {
        deck = DeckHelper.getInstance().createDeck();

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");

        players = new ArrayList<Player>(Arrays.asList(player1, player2));

        game = new BlackjackGame();

        DeckHelper.setShuffler(new SimpleShuffler());
    }

    @Test
    public void initShouldHandOutCards() throws Exception {
        game.init(players, deck);

        for (Player player : players) {
            assertEquals("Each player should have 2 cards at the beginning of the game", 2, player.getCards().size());
        }
    }

    @Test
    public void determineWinnerShouldFindThePlayerWithHighestTotal() throws Exception {

        Card two = new Card(CardRank.TWO, CardSuit.HEARTS);
        Card ten = new Card(CardRank.TEN, CardSuit.CLUBS);
        Card ace = new Card(CardRank.ACE, CardSuit.DIAMONDS);

        Player player1 = players.get(0);
        Player player2 = players.get(1);

        player1.setCards(Arrays.asList(ten, two));
        player2.setCards(Arrays.asList(ten, ace));

        Player winner = game.determineWinner(players);

        assertEquals("The player with greatest total should win", player2, winner);

    }
}