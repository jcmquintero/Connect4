package main.java.es.upm.miw.connect4;

public class Board {
    final static int ROW_NUMBER = 6;
    final static int COLUMN_NUMBER = 7;
    Token[][] squares;

    public Board() {
        squares = new Token[ROW_NUMBER][COLUMN_NUMBER];
    }

    public boolean insertToken(int column) {
        return false;
    }

    public boolean columnHasSpace(int column) {
        Token[] column = squares[column];
        return column.length < ROW_NUMBER;
    }
}
