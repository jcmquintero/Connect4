package es.upm.miw.connect4.models;

import es.upm.miw.connect4.types.Color;
import es.upm.miw.connect4.types.Position;
import es.upm.miw.connect4.views.PlayerViewManager;

public abstract class Player {

    Color color;
    Board board;

    public Player(Color color, Board board) {
        this.color = color;
        this.board = board;
    }

    public Position insertToken(PlayerViewManager view) {
        int column = chooseColumn(view);
        return board.insertToken(column, color);
    }

    public abstract int chooseColumn(PlayerViewManager view);

    public Color getColor() {
        return color;
    }
}
