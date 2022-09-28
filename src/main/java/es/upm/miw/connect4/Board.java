package es.upm.miw.connect4;

import es.upm.miw.connect4.Token;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Board {
    final static int ROW_NUMBER = 6;
    final static int COLUMN_NUMBER = 7;
    Map<Position, Color> squares;

    public Board() {
        squares = new HashMap<>();
        initialize();
    }

    public void initialize() {
        for (int i = 0; i < COLUMN_NUMBER; i++) {
            for (int j = 0; j < ROW_NUMBER; i++) {
                squares.put(new Position(i, j), Color.NONE);
            }
        }
    }

    public void print() {
        for (int headerNum = 0; headerNum < COLUMN_NUMBER; headerNum++) {
            System.out.print("  " + headerNum + "  ");
        }
        System.out.println();
        for (int row = ROW_NUMBER - 1; row >= 0; row--) {
            for (int column = 0; column < COLUMN_NUMBER; column++) {
                System.out.println(" [" + squares.get(new Position(column, row)) + "] ");
            }
            System.out.println();
        }
    }

    public void insertToken(int column, Color color) {
        int row = countFullSquaresInColumn(column);
        squares.put(new Position(column, row), color);
    }

    private boolean checkConnectFour(Position position) {
        Color playerColor = squares.get(position);
        Direction[] directions = Direction.values();
        boolean isConnectFour;
        int i = 0;
        do {
            isConnectFour = checkRow(position, directions[i], playerColor);
        } while (i++ < directions.length && !isConnectFour);
        return isConnectFour;
    }

    private boolean checkRow(Position position, Direction direction, Color playerColor) {
        int matchingCount = 0;
        boolean matchesColor = true;
        Position currentPosition = position;
        Position neighboringSquare;
        do {
            neighboringSquare = getNeighboringSquare(position, direction);
            matchesColor = (squares.get(neighboringSquare) == playerColor);
            if (matchesColor) {
                matchingCount++;
            } else {
                // TODO: Moverse una casilla en direccion contraria (solo si esa casilla es del color)
            }
        } while (neighboringSquare != null && matchesColor && matchingCount < 4);
        return matchesColor && matchingCount == 3;
    }

    public boolean columnHasSpace(int column) {
        return countFullSquaresInColumn(column) < ROW_NUMBER;
    }

    public boolean columnIn(int column) {
        return Interval.isBetween(column, 0, COLUMN_NUMBER);
    }

    private int countFullSquaresInColumn(int column) {
        int fullSquares = 0;
        for(int row = 0; row < ROW_NUMBER; row++) {
            if (squares.get(new Position(column, row)) != Color.NONE) {
                fullSquares++;
            }
        }
        return fullSquares;
    }

    private Position getNeighboringSquare(Position position, Direction direction) {
        int x = position.getX() + direction.getX();
        int y = position.getY() + direction.getY();
        Position neighboringSquare = null;
        if (Interval.isBetween(x, 0, COLUMN_NUMBER) && Interval.isBetween(x, 0, ROW_NUMBER)) {
            neighboringSquare = new Position(x, y);
        }
        return neighboringSquare;
    }

    public int getColumnNumber() {
        return COLUMN_NUMBER;
    }
}
