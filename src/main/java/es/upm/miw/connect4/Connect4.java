package es.upm.miw.connect4;

public class Connect4 {

    private void play() {
        Board board = new Board();
        Player[] players = {new Player("Player 1", "Y", board), new Player("Player 2", "R", board)};
        int nextPlayer = 0;
        while(!players[nextPlayer].play()) {
            nextPlayer = (nextPlayer == players.length-1) ? 0 : nextPlayer + 1;
        }
        board.print();
        System.out.println(players[nextPlayer].getName() + " wins!");
    }

    public static void main(String[] args) {
        Connect4 connect4 = new Connect4();
        connect4.play();
    }
}
