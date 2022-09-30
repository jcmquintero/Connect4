package es.upm.miw.connect4.models;

import es.upm.miw.connect4.types.Color;
import es.upm.miw.connect4.types.Direction;
import es.upm.miw.connect4.types.Interval;
import es.upm.miw.connect4.types.Position;

public class Board {
    static final int ROW_NUMBER = 6;
    static final int COLUMN_NUMBER = 7;
    Color[][] squares;

    public Board() {
        squares = new Color[COLUMN_NUMBER][ROW_NUMBER];
        initialize();
    }

    public void initialize() {
        for (int i = 0; i < COLUMN_NUMBER; i++) {
            for (int j = 0; j < ROW_NUMBER; j++) {
                squares[i][j] = Color.NONE;
            }
        }
    }

    public Position insertToken(int column, Color color) {
        int row = countFullSquaresInColumn(column);
        Position lastPosition = new Position(column, row);
        squares[lastPosition.getX()][lastPosition.getY()] = color;
        return lastPosition;
    }

    public boolean isConnectFour(Position position) {
        Color playerColor = squares[position.getX()][position.getY()];
        Direction[] directions = Direction.values();
        boolean isConnectFour;
        int i = 0;
        do {
            isConnectFour = checkDirection(position, directions[i], playerColor);
            i++;
        } while (i < directions.length && !isConnectFour);
        return isConnectFour;
    }

    private boolean checkDirection(Position position, Direction direction, Color playerColor) {
        Position startPosition = position;
        boolean isConnectFour;
        do {
            isConnectFour = checkRow(startPosition, direction, playerColor);
            if (!isConnectFour) {
                startPosition = startPosition.getPrevious(direction);
            }
        } while (!isConnectFour && position.isFourSquaresAway(startPosition) && isInsideBoundaries(startPosition));
        return isConnectFour;
    }

    private boolean checkRow(Position position, Direction direction, Color playerColor) {
        int itemsInRow = 0;
        Position nextPosition = position;
        boolean matchesColor;
        do {
            matchesColor = (getSquareColor(nextPosition) == playerColor);
            if (matchesColor) {
                itemsInRow++;
                nextPosition = nextPosition.getNext(direction);
            }
        } while (itemsInRow < 4 && matchesColor && isInsideBoundaries(nextPosition));
        return itemsInRow == 4;
    }

    private Color getSquareColor(Position position) {
        return squares[position.getX()][position.getY()];
    }

    public boolean columnHasSpace(int column) {
        return countFullSquaresInColumn(column) < ROW_NUMBER;
    }

    public boolean isInsideBoundaries(Position position) {
        return Interval.isBetween(position.getX(), 0, COLUMN_NUMBER)
                && Interval.isBetween(position.getY(), 0, ROW_NUMBER);
    }

    private int countFullSquaresInColumn(int column) {
        int fullSquares = 0;
        for (int row = 0; row < ROW_NUMBER; row++) {
            if (squares[column][row] != Color.NONE) {
                fullSquares++;
            }
        }
        return fullSquares;
    }

    public Error validateMove(int column) {
        Error error = null;
        if (!Interval.isBetween(column, 0, COLUMN_NUMBER)) {
            error = new Error("The selected column does not exist. Try another one...");
        } else if (!columnHasSpace(column)) {
            error = new Error("The selected column has no space left. Try another one...");
        }
        return error;
    }

    public Color[][] getSquares() {
        return squares;
    }
}
