package es.upm.miw.connect4.views;

import es.upm.miw.connect4.models.Board;
import es.upm.miw.connect4.models.Game;
import es.upm.miw.connect4.models.HumanPlayer;
import es.upm.miw.connect4.models.RandomPlayer;
import es.upm.miw.connect4.types.Position;

import java.util.Scanner;

public class PlayView {
    Game game;
    Scanner scanner;
    PlayerView playerView;
    BoardView boardView;

    public PlayView(Game game, Scanner scanner) {
        this.game = game;
        this.scanner = scanner;
        this.playerView = new PlayerView(this.game, this.game.getBoard(), this.scanner);
        this.boardView = new BoardView(game.getBoard());

    }


    public void play() {
        Position position;
        do {
            System.out.println();
            System.out.println(game.getActivePlayer().getColor() + "'s Turn");
            boardView.print();
            position = game.insertToken(this.playerView);
            boardView.print();
            if(!game.isConnectFour(position)) {
                game.nextPlayer();
            }
        } while (!game.isConnectFour(position));
        System.out.println(game.getActivePlayerColor() + " wins!");
    }
}
