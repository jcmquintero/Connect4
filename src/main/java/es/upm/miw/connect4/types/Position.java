package es.upm.miw.connect4.types;

public class Position {

    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position getNext(Direction direction) {
        return new Position(x + direction.getX(), y + direction.getY());
    }

    public Position getPrevious(Direction direction) {
        return new Position(x - direction.getX(), y - direction.getY());
    }

    public boolean isFourSquaresAway(Position secondPosition) {
        return Math.abs(x - secondPosition.getX()) < 4 && Math.abs(y - secondPosition.getY()) < 4;
    }
}
