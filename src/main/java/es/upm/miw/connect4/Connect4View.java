package es.upm.miw.connect4;

import java.util.Scanner;

public class Connect4View implements UserIOManager{
    Scanner keyboard;

    public Connect4View() {
        keyboard = new Scanner(System.in);
    }

    public void printBoard(Color[][] squares) {
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
    }

    public void announcePlayerTurn(Player player) {
        System.out.println(player.getColor() + "'s turn");
    }

    public void announcePlayerError(String error) {
        System.out.println("-> ERROR: " + error);
    }

    public int selectPlayerNum() {
        System.out.print("Select the number of players:");
        return keyboard.nextInt();
    }

    @Override
    public int manageTokenInsertion(HumanPlayer player) {
        System.out.print("Select the column your token will be inserted into: ");
        return keyboard.nextInt();
    }

    @Override
    public int manageTokenInsertion(RandomPlayer player) {
        System.out.println("*" + player.getColor() + " is choosing a random column..." + "*");
        return player.getRandomColumn();
    }

    public void announceWinner(Player player) {
        System.out.println(player.getColor() + " wins!");
    }
}
