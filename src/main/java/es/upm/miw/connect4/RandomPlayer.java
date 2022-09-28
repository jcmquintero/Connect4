package es.upm.miw.connect4;

import java.util.Random;
import java.util.Scanner;

public class RandomPlayer extends Player {
    public RandomPlayer(Color color, Board board) {
        super(color, board);
    }

    @Override
    public int chooseColumn() {
        int column;
        do {
            column = new Random().nextInt(board.getColumnNumber());
        } while (!board.columnHasSpace(column));
        return column;
    }
}
