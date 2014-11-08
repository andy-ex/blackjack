package codingtest.codingtest.core;


import codingtest.codingtest.domain.Deck;
import codingtest.codingtest.domain.player.Player;

import java.util.List;

public interface Game {

    public void play(List<Player> players, Deck deck);

}
