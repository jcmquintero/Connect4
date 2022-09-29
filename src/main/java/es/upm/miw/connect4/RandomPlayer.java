package es.upm.miw.connect4;

import java.util.Random;
import java.util.Scanner;

public class RandomPlayer extends Player {
    public RandomPlayer(Color color, Board board, Connect4View view) {
        super(color, board, view);
    }
    @Override
    public int chooseColumn() {
        int column;
        do {
            column = view.manageTokenInsertion(this);
        } while (!board.columnHasSpace(column));
        return column;
    }

    public int getRandomColumn() {
        return new Random().nextInt(7);
    }
}
