package codingtest.codingtest.core;

import codingtest.codingtest.core.util.DeckHelper;
import codingtest.codingtest.domain.Card;
import codingtest.codingtest.domain.Deck;
import codingtest.codingtest.domain.player.Player;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is the core class for game logic
 */
public class BlackjackGame implements Game {

    private static final Logger LOG = Logger.getLogger(Game.class.getName());

    @Override
    public Player play(List<Player> players, Deck deck) {
        LOG.info("Starting Blackjack game");

        init(players, deck);

        for (Player player : players) {
            int total = player.getTotal();
            LOG.info("Active player: " + player.getName());
            if (players.size() == 1) {
                return player;
            }
            while (total < 17) {
                Card nextCard = deck.getNextCard();
                LOG.info("Next card: " + nextCard);
                player.addCard(nextCard);
            }
            if (total > 21) {
                LOG.info("Player " + player.getName() + " went bust :(");
                players.remove(player);
            }
            if (total == 21) {
                return player;
            }
        }

        LOG.info("Game finished. Determining winner...");

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

        LOG.info("Handing initial cards...");
        for (Player player : players) {
            player.addCard(deck.getNextCard());
            player.addCard(deck.getNextCard());
            LOG.info("Player: " + player.getName() + ", Cards: " + Arrays.toString(player.getCards().toArray()));
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
