package es.upm.miw.connect4;

import java.util.Scanner;

public abstract class Player {

    Color color;
    Board board;

    public Player(Color color, Board board) {
        this.color = color;
        this.board = board;
    }

    public void play() {
            board.print();
            System.out.println(color + "'s turn");
            int column = chooseColumn();
            board.insertToken(column, color);
    }

    public abstract int chooseColumn();

    public Color getColor() {
        return color;
    }
}
