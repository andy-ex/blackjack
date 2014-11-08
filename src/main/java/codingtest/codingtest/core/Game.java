package codingtest.codingtest.core;


import codingtest.codingtest.domain.Deck;
import codingtest.codingtest.domain.player.Player;

import java.util.List;

/**
 * Common interface for any game you want to implement (blackjack, poker, rummy, etc.)
 */
public interface Game {

    /**
     * Contains all the logic about the game
     * @param players Players who take part in the game
     * @param deck deck for the card game
     * @return player who won the game
     */
    public Player play(List<Player> players, Deck deck);

}
