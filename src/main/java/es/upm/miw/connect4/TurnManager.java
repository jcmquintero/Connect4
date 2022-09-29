package es.upm.miw.connect4;

public class TurnManager {
    Player[] players;
    int moveCount;

    public TurnManager(Player[] players) {
        this.players = players;
        moveCount = 0;
    }

    public Player nextPlayer() {
        return players[moveCount++ % players.length];
    }
}
