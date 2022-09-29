package es.upm.miw.connect4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Connect4 {
    Connect4View view;
    Board board;
    Player[] players;

    private void play() {
        view = new Connect4View();
        board = new Board(view);
        players = new Player[2];
        int playerNum = view.selectPlayerNum();
        createPlayers(playerNum);
        TurnManager turnManager = new TurnManager(players);
        Player winner;
        boolean win = false;
        Player nextPlayer;
        do {
            nextPlayer = turnManager.nextPlayer();
            win = nextPlayer.play();
        } while (!win);
        view.printBoard(board.getSquares());
        view.announceWinner(nextPlayer);
    }

    private void createPlayers(int playerNum) {
        if (playerNum < 2) {
            players[0] = new RandomPlayer(Color.YELLOW, board, view);
            if (playerNum == 0) {
                players[1] = new RandomPlayer(Color.RED, board, view);
            } else {
                players[1] = new HumanPlayer(Color.RED, board, view);
            }
        } else {
            players[0] = new HumanPlayer(Color.YELLOW, board, view);
            players[1] = new HumanPlayer(Color.RED, board, view);
        }
    }

    public static void main(String[] args) {
        new Connect4().play();
    }
}
