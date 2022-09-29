package es.upm.miw.connect4;

public abstract class Player {

    Color color;
    Board board;
    Connect4View view;

    public Player(Color color, Board board, Connect4View view) {
        this.color = color;
        this.board = board;
        this.view = view;
    }

    public boolean play() {
        view.announcePlayerTurn(this);
        board.print();
        int column = chooseColumn();
        return board.insertToken(column, color);
    }

    public abstract int chooseColumn();

    public Color getColor() {
        return color;
    }
}
