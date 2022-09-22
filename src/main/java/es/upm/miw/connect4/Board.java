package main.java.es.upm.miw.connect4;

import es.upm.miw.connect4.Token;

import java.util.Arrays;

public class Board {
    final static int ROW_NUMBER = 6;
    final static int COLUMN_NUMBER = 7;
    Token[][] squares;

    public Board() {
        squares = new Token[ROW_NUMBER][COLUMN_NUMBER];
    }

    public boolean insertToken(int column) {
        squares.
        return false;
    }

    public boolean columnHasSpace(int columnNum) {
        Token[] column = squares[columnNum];
        Arrays.stream(column).filter(x != null)
        return column.length < ROW_NUMBER;
    }
}
