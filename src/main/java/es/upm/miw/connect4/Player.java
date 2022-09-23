package es.upm.miw.connect4;

import java.util.Scanner;

public class Player {

    Color color;
    Board board;

    public Player(Color color, Board board) {
        this.color = color;
        this.board = board;
    }

    public Player play() {
        Scanner keyboard = new Scanner(System.in);
        board.print();
        System.out.println(color + "'s turn");
        System.out.print("Select the column your token will be inserted into: ");
        int column = keyboard.nextInt();

        while (!board.columnIn(column)) {
            System.out.print("The column you chose does not exist, try another one...");
            column = keyboard.nextInt();
        }

        while (!board.columnHasSpace(column)) {
            System.out.print("The selected column has no space left, try another one...");
            column = keyboard.nextInt();
        }

        return board.insertToken(column, color) ? this : null; // TODO: No devolver player -> Gestionar victoria en board
    }

    public Color getColor() {
        return color;
    }
}
