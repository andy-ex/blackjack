package codingtest.codingtest.core;

import codingtest.codingtest.core.util.DeckHelper;
import codingtest.codingtest.domain.Deck;
import codingtest.codingtest.domain.player.Player;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

/**
 * This is the core class for game logic
 */
public class BlackjackGame implements Game {

    private static final Logger LOG = Logger.getLogger(Game.class.getName());

    @Override
    public Player play(List<Player> players, Deck deck) {
        init(players, deck);

        for (Player player : players) {
            int total = player.getTotal();
            if (players.size() == 1) {
                return player;
            }
            while (total < 17) {
                player.addCard(deck.getNextCard());
            }
            if (total > 21) {
                players.remove(player);
            }
            if (total == 21) {
                return player;
            }
        }

        return determineWinner(players);

    }

    private void init(List<Player> players, Deck deck) {
        if (players == null || players.isEmpty()) {
            throw new IllegalStateException("Please, add players to the game");
        }

        if (deck == null) {
            throw new IllegalStateException("Please, provide any deck to make the game happened");
        }

        LOG.info("Shuffling deck...");
        DeckHelper.shuffleDeck(deck);


        for (Player player : players) {
            player.addCard(deck.getNextCard());
            player.addCard(deck.getNextCard());
        }
    }

    private Player determineWinner(List<Player> players) {
        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getTotal() - o2.getTotal();
            }
        });

        return players.get(0);
    }
}
