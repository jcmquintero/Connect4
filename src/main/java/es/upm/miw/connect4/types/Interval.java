package es.upm.miw.connect4.types;

public class Interval {

    public static boolean isBetween(int val, int min, int max) {
        return min <= val && val < max;
    }
}
