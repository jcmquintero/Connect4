package es.upm.miw.connect4;

public class HumanPlayer extends Player {

    public HumanPlayer(Color color, Board board, Connect4View view) {
        super(color, board, view);
    }

    @Override
    public int chooseColumn() {
        int column;
        do {
            column = view.manageTokenInsertion(this);
        } while (!board.isValidMove(column));
        return column;
    }
}
