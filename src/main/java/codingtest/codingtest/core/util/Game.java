package codingtest.codingtest.core.util;

import codingtest.codingtest.domain.Deck;
import codingtest.codingtest.domain.player.Player;

import java.util.List;

/**
 * This is the core class for game logic
 */
public class Game {

    private List<Player> players;
    private Deck deck;
    boolean isFinished;

    public void play() {
        if (players == null || players.isEmpty()) {
            throw new IllegalStateException("Please, add players to the game");
        }

        if (deck == null) {
            throw new IllegalStateException("Please, provide any deck to make the game happened");
        }


    }

    private void init() {
        DeckHelper.shuffleDeck(deck);


    }



}
