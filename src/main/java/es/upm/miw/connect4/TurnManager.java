package es.upm.miw.connect4;

import java.util.List;

public class TurnManager {
    List<Player> players;
    int moveCount;

    public TurnManager(List<Player> players) {
        this.players = players;
        moveCount = 0;
    }

    public Player nextPlayer() {
        return players.get(moveCount++ % players.size());
    }
}
