package es.upm.miw.connect4.models;

import es.upm.miw.connect4.types.Color;
import es.upm.miw.connect4.views.PlayerViewManager;

import java.util.Random;

public class RandomPlayer extends Player {
    public RandomPlayer(Color color, Board board) {
        super(color, board);
    }

    @Override
    public int chooseColumn(PlayerViewManager view) {
        int column;
        do {
            column = view.chooseColumn(this);
        } while (!board.columnHasSpace(column));
        return column;
    }

    public int getRandomColumn() {
        return new Random().nextInt(7);
    }
}
