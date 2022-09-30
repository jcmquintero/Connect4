package es.upm.miw.connect4.models;

import es.upm.miw.connect4.models.Board;
import es.upm.miw.connect4.models.Player;
import es.upm.miw.connect4.models.Turn;
import es.upm.miw.connect4.types.Color;
import es.upm.miw.connect4.types.Position;
import es.upm.miw.connect4.views.PlayerView;
import es.upm.miw.connect4.views.PlayerViewManager;

public class Game {
    Board board;
    Turn turn;
    PlayerView playerView;

    public Game() {
        board = new Board();
        turn = new Turn();
    }

    public Position insertToken(PlayerViewManager view) {
        return turn.insertToken(view);
    }

    public void initializePlayers(int playerNum) {
        Player[] players = new Player[2];
        if (playerNum < 2) {
            players[0] = new RandomPlayer(Color.YELLOW, board);
            if (playerNum == 0) {
                players[1] = new RandomPlayer(Color.RED, board);
            } else {
                players[1] = new HumanPlayer(Color.RED, board);
            }
        } else {
            players[0] = new HumanPlayer(Color.YELLOW, board);
            players[1] = new HumanPlayer(Color.RED, board);
        }
        turn.setPlayers(players);
    }

    public void nextPlayer() {
        turn.nextPlayer();
    }

    public Player getActivePlayer() {
        return this.turn.getActivePlayer();
    }

    public Board getBoard() {
        return this.board;
    }

    public boolean isConnectFour(Position position) {
        return board.isConnectFour(position);
    }

    public Color getActivePlayerColor() {
        return this.getActivePlayer().getColor();
    }
}
