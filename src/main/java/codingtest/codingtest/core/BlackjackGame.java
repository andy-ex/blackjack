package codingtest.codingtest.core;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import codingtest.codingtest.core.util.DeckHelper;
import codingtest.codingtest.domain.Card;
import codingtest.codingtest.domain.Deck;
import codingtest.codingtest.domain.player.Player;

/**
 * This is the class implementing Blackjack game
 */
public class BlackjackGame implements Game {

    private static final Logger LOG = Logger.getLogger(Game.class.getName());


    public Player play(List<Player> players, Deck deck) {
        LOG.info("Starting Blackjack game");

        init(players, deck);
		int activePlayers = players.size();
        for (Player player : players) {
            int total = player.getTotal();
			LOG.info("Active player: " + player.getName() + ", Total: " + total);
			if (activePlayers == 1) {
				LOG.info("One player left in game");
                return player;
            }
            while (total < 17) {
				LOG.info("**hit**");
                Card nextCard = deck.getNextCard();
                player.addCard(nextCard);
				total = player.getTotal();
				LOG.info("Next card: " + nextCard + ", Current total: "
						+ total);
            }
            if (total > 21) {
				LOG.info("**go bust**");
				player.setActive(false);
				activePlayers--;
				continue;
            }
            if (total == 21) {
				LOG.info("BLACK JACK!");
                return player;
            }
			LOG.info("**stick**");
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
			LOG.info("Player: " + player.getName() + ", Cards: "
					+ Arrays.toString(player.getCards().toArray())
					+ ", Total: " + player.getTotal());
        }
    }

    private Player determineWinner(List<Player> players) {
		Player winner = null;
		int maxValue = 0;
		for (Player player : players) {
			if (player.isActive() && player.getTotal() > maxValue) {
				maxValue = player.getTotal();
				winner = player;
			}
		}

		return winner;
    }
}
