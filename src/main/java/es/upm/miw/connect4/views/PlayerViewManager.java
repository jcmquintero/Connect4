package es.upm.miw.connect4.views;

import es.upm.miw.connect4.models.HumanPlayer;
import es.upm.miw.connect4.models.RandomPlayer;

public interface PlayerViewManager {
    public int chooseColumn(HumanPlayer player);
    public int chooseColumn(RandomPlayer player);
}
