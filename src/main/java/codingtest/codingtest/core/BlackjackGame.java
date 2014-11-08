package codingtest.codingtest.core;

import codingtest.codingtest.core.util.DeckHelper;
import codingtest.codingtest.domain.Deck;
import codingtest.codingtest.domain.player.Player;

import java.util.List;

/**
 * This is the core class for game logic
 */
public class BlackjackGame implements Game {

    @Override
    public void play(List<Player> players, Deck deck) {
        init(players, deck);

        while (!isFinished()) {

            for (Player player : players) {
                if (player.getTotal() < 17) {
                    player.addCard(deck.getNextCard());
                }
            }



        }

    }

    private void init(List<Player> players, Deck deck) {
        if (players == null || players.isEmpty()) {
            throw new IllegalStateException("Please, add players to the game");
        }

        if (deck == null) {
            throw new IllegalStateException("Please, provide any deck to make the game happened");
        }

        DeckHelper.shuffleDeck(deck);

        for (Player player : players) {
            player.addCard(deck.getNextCard());
            player.addCard(deck.getNextCard());
        }
    }


    private boolean isFinished() {
        return false;
    }
}
