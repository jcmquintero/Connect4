package es.upm.miw.connect4.views;

import es.upm.miw.connect4.models.Board;
import es.upm.miw.connect4.types.Color;

public class BoardView {
    Board board;

    public BoardView(Board board) {
        this.board = board;
    }

    public void print() {
        Color[][] squares = board.getSquares();
        for (int headerNum = 0; headerNum < squares.length; headerNum++) {
            System.out.print("  " + headerNum + "  ");
        }
        System.out.println();
        for (int row = squares[0].length - 1; row >= 0; row--) {
            for (int column = 0; column < squares.length; column++) {
                System.out.print(" [" + squares[column][row].getColorCode() + "] ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
