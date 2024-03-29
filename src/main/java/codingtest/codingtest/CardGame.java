package codingtest.codingtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import codingtest.codingtest.core.Game;
import codingtest.codingtest.core.impl.BlackjackGame;
import codingtest.codingtest.core.util.DeckHelper;
import codingtest.codingtest.core.util.shuffle.Shuffler;
import codingtest.codingtest.core.util.shuffle.impl.FaroShuffler;
import codingtest.codingtest.core.util.shuffle.impl.RiffleShuffler;
import codingtest.codingtest.core.util.shuffle.impl.SimpleShuffler;
import codingtest.codingtest.domain.Deck;
import codingtest.codingtest.domain.player.Player;

/**
 * Class that handles the playing of a card game from a simple command line interface,
 * and echoes back a step-by-step description of the game to the console.
 */
public class CardGame {
	private static final Logger LOG = Logger
			.getLogger(CardGame.class.getName());

	private static Scanner inputReader = new Scanner(System.in);

    /**
	 * Main. Plays a card game from a command line interface.
	 * 
	 * @param first
	 *            parameter - the number of players
	 */
    public static void main(String[] args) {

		// determining number of players
		int numberOfPlayers;
		if (args.length == 0) {
			LOG.info("No number of players was specified, so number of players set to 3");
			numberOfPlayers = 3;
		} else {
			numberOfPlayers = Integer.parseInt(args[0]);
			if (numberOfPlayers <= 1 || numberOfPlayers > 6) {
				LOG.info("Number of players could be only between 2 and 6");
				System.exit(1);
			}
		}

		// initializing players
		List<Player> players = new ArrayList<Player>();
		for (int i = 0; i < numberOfPlayers; i++) {
			Player player = new Player("Player" + i);
			players.add(player);
		}

		Deck deck = DeckHelper.getInstance().createDeck();

		// here you can put other shuffling mechanisms you want.
		// put them under case 2, case 3 etc.
		Shuffler shuffler = null;
		while (shuffler == null) {
			LOG.info("Choose game: 1 - Simple Shuffle; 2 - Riffle Shuffle; 3 - Faro Shuffle");
			if (!inputReader.hasNextInt()) {
				LOG.info("Incorrect shuffle method number");
				inputReader.next();
				continue;
			}
			int shuffleMethodNumber = inputReader.nextInt();
			switch (shuffleMethodNumber) {
			case 1:
				shuffler = new SimpleShuffler();
				break;
			case 2:
				shuffler = new RiffleShuffler();
				break;
			case 3:
				shuffler = new FaroShuffler();
				break;
			default:
				LOG.info("Incorrect shuffle method number");
				break;
			}
		}
		DeckHelper.setShuffler(shuffler);

		// here you can put other games you want like poker, rummy;
		// put them under case 2, case 3 etc.
		Game game = null;
		while (game == null) {
			LOG.info("Choose game: 1 - Black Jack");
			if (!inputReader.hasNextInt()) {
				LOG.info("Incorrect game number");
				inputReader.next();
				continue;
			}
			int gameNumber = inputReader.nextInt();
			switch (gameNumber) {
			case 1:
				game = new BlackjackGame();
				break;
			default:
				LOG.info("Incorrect game number");
				break;
		}
		}

		// start the game and get a winner
		Player winner = game.play(players, deck);
		LOG.info("WINNER: " + winner.getName() + ", Total: "
				+ winner.getTotal());

    }
}
