package es.upm.miw.connect4;

public class Connect4 {
    Board board;
    Player[] players;

    private void play() {
        board = new Board();
        players = new Player[]{new Player(Color.RED, board), new Player(Color.YELLOW, board)};
        int nextPlayer = 0;
        Player winner;
        do {
            winner = players[nextPlayer].play(); // TODO: Consultar si hay ganador a partir de board
            // TODO: Cambiar turno solo si no hay ganador
            nextPlayer = (nextPlayer == players.length - 1) ? 0 : nextPlayer + 1; // TODO: Cambiar por nextPlayer % players.length (o gestionar desde clase Turn)
        } while (winner == null);
        board.print();
        System.out.println(winner.getColor() + " wins!");
    }

    public static void main(String[] args) {
        Connect4 connect4 = new Connect4(); // TODO: No inicializar en una variable, hacer new y ejecutar directamente
        connect4.play();
    }
}
