package es.upm.miw.connect4.models;

import es.upm.miw.connect4.types.Position;
import es.upm.miw.connect4.views.PlayerViewManager;

public class Turn {
    Player[] players;
    int moveCount;
    int activePlayer;

    public Turn() {
        moveCount = 0;
        activePlayer = 1;
    }

    public void nextPlayer() {
        this.activePlayer = moveCount++ % players.length;
    }

    public Position insertToken(PlayerViewManager view) {
        assert players != null;
        return this.players[activePlayer].insertToken(view);
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Player getActivePlayer() {
       return players[activePlayer];
    }
}
