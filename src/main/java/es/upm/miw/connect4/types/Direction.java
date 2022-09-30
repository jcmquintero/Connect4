package es.upm.miw.connect4.types;

public enum Direction {
    SOUTH(0, -1),
    EAST(1, 0),
    NORTHEAST(1, 1),
    SOUTHEAST(1, -1);

    int x;
    int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
