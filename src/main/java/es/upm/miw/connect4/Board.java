package es.upm.miw.connect4;

import es.upm.miw.connect4.Token;

import java.util.Arrays;
import java.util.Objects;

public class Board {
    final static int ROW_NUMBER = 6;
    final static int COLUMN_NUMBER = 7;
    Token[][] squares;

    public Board() {
        squares = new Token[COLUMN_NUMBER][ROW_NUMBER];
    }

    public void print() {
        for (int headerNum = 0; headerNum < COLUMN_NUMBER; headerNum++) {
            System.out.print("  " + headerNum + "  ");
        }
        System.out.println();
        for (int row = ROW_NUMBER - 1; row >= 0; row--) {
            for (int column = 0; column < COLUMN_NUMBER; column++) {
                Color color = Color.NONE;
                if (squares[column][row] != null) {
                    color = squares[column][row].getColor();
                }
                System.out.print(" [" + color.getColorCode() + "] ");
            }
            System.out.println();
        }
    }

    public boolean insertToken(int column, Color color) {
        int squareNum = countFullSquaresInColumn(column);
        squares[column][squareNum] = new Token(color);
        return validateMove(column, squareNum, color);
    }

    private boolean validateMove(int column, int row, Color color) {
        int[] step = {-1, 0, 1}; // TODO: Utilizar enum Dirección
        boolean won = false;
        for (int i = 0; i < step.length; i++) {
            for (int j = 0; j < step.length; j++) {
                won = checkRow(column, row, step[i], step[j], color); // TODO: Gestionar mediante clase Coordinate
                if (won) { // TODO: No usar return -> Cambiar por while
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkRow(int column, int row, int stepX, int stepY, Color color) { // TODO: Reducir el num. de parámetros
        boolean isRow = true;
        int checkRow = row;
        int checkColumn = column;
        int itemsInRow = 0;
        while (isRow && (itemsInRow < 4) && (checkColumn < COLUMN_NUMBER) && (checkColumn >= 0) // TODO: Comprobar intervalos mediante clase Interval
                && (checkRow < ROW_NUMBER) && (checkRow >= 0) && (stepX != 0 || stepY != 0)) {
            Token token = squares[checkColumn][checkRow];
            isRow = (token != null && token.getColor() == color);
            checkColumn += stepY;
            checkRow += stepX;
            itemsInRow++;
        }
        return isRow && itemsInRow == 4;
    }

    public boolean columnIn(int columnNum) {
        return columnNum >= 0 && columnNum < COLUMN_NUMBER;
    }

    public boolean columnHasSpace(int columnNum) {
        return countFullSquaresInColumn(columnNum) < ROW_NUMBER;
    }

    private int countFullSquaresInColumn(int columnNum) {
        Token[] column = squares[columnNum];
        return (int) Arrays.stream(column).filter(Objects::nonNull).count();
    }
}
