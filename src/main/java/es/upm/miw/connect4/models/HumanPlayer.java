package es.upm.miw.connect4.models;

import es.upm.miw.connect4.types.Color;
import es.upm.miw.connect4.views.PlayerViewManager;

public class HumanPlayer extends Player {
    public HumanPlayer(Color color, Board board) {
        super(color, board);
    }

    @Override
    public int chooseColumn(PlayerViewManager view) {
        return view.chooseColumn(this);
    }
}
