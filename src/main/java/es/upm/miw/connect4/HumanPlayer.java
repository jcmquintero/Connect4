package es.upm.miw.connect4;

import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(Color color, Board board) {
        super(color, board);
    }

    @Override
    public int chooseColumn() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Select the column your token will be inserted into: ");
        int column;
        boolean validColumn = true;
        do {
            column = keyboard.nextInt();
            if (!board.columnIn(column)) {
                System.out.print("The column you chose does not exist, try another one...");
                validColumn = false;
            } else if (!board.columnHasSpace(column)){
                System.out.print("The selected column has no space left, try another one...");
                validColumn = false;
            }
        } while (!validColumn);
        return column;
    }
}
