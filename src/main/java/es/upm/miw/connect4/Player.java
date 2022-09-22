package main.java.es.upm.miw.connect4;

import java.util.Scanner;

public class Player {

    String name;
    String colorCode;
    Board board;

    public Player(String name, String colorCode, Board board) {
        this.name = name;
        this.colorCode = colorCode;
        this.board = board;
    }

    public boolean play() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(this.name + "'s turn");
        System.out.print("Select the column your token will be inserted into: ");
        int column = keyboard.nextInt();
        while(!board.columnHasSpace(column)) {
            System.out.print("The selected column has no space left, try another one...");
        }
        return board.insertToken(column);
    }

    public String getName() {
        return name;
    }
}
