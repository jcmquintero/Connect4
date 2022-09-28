package es.upm.miw.connect4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Connect4 {
    Board board;
    List<Player> players;

    private void play() {
        board = new Board();
        players = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Select the number of players:");
        int playerNum = keyboard.nextInt();
        createPlayers(playerNum);
        TurnManager turnManager = new TurnManager(players);
        Player winner;
        do {
            Player nextPlayer = turnManager.nextPlayer();
            nextPlayer.play();
        } while (); // TODO: Mirar si es winner
        board.print();
        System.out.println(winner.getColor() + " wins!");
    }

    private void createPlayers(int playerNum) {
        if (playerNum < 2) {
            players.add(new RandomPlayer(Color.values()[0], board));
            if (playerNum == 0) {
                players.add(new RandomPlayer(Color.values()[1], board));
            }
        }
        for (int i = 2; i < playerNum; i++) {
            players.add(new HumanPlayer(Color.values()[i], board));
        }
    }

    public static void main(String[] args) {
        new Connect4().play();
    }
}
