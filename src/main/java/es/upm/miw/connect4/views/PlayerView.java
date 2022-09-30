package es.upm.miw.connect4.views;

import es.upm.miw.connect4.models.Board;
import es.upm.miw.connect4.models.Game;
import es.upm.miw.connect4.models.HumanPlayer;
import es.upm.miw.connect4.models.RandomPlayer;

import java.util.Scanner;

public class PlayerView implements PlayerViewManager{
    Game game;
    Board board;
    PlayerErrorView playerErrorView;
    Scanner scanner;

    public PlayerView(Game game, Board board, Scanner scanner) {
        this.game = game;
        this.board = board;
        this.scanner = scanner;
        this.playerErrorView = new PlayerErrorView();
    }

    @Override
    public int chooseColumn(HumanPlayer player) {
        int column;
        Error playerError;
        do {
            System.out.print("Select the column your token will be inserted into: ");
            column = scanner.nextInt();
            playerError = board.validateMove(column);
            if(playerError != null) {
                this.playerErrorView.print(playerError);
            }
        } while (playerError != null);
        return column;
    }

    @Override
    public int chooseColumn(RandomPlayer player) {
        System.out.println("*" + player.getColor() + " is choosing a random column..." + "*");
        return player.getRandomColumn();
    }
}
