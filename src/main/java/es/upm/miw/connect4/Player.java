package es.upm.miw.connect4;

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
        board.print();
        System.out.println(this.name + "'s turn");
        System.out.print("Select the column your token will be inserted into: ");
        int column = keyboard.nextInt();

        while(!board.columnIn(column)){
            System.out.print("The column you chose does not exist, try another one...");
            column = keyboard.nextInt();
        }

        while(!board.columnHasSpace(column)){
            System.out.print("The selected column has no space left, try another one...");
            column = keyboard.nextInt();
        }

        return board.insertToken(column, colorCode);
    }

    public String getName() {
        return name;
    }
}
