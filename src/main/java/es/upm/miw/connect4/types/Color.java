package es.upm.miw.connect4.types;

public enum Color {
    RED('R'),
    YELLOW('Y'),
    NONE(' ');

    char colorCode;

    Color(char colorCode) {
        this.colorCode = colorCode;
    }

    public char getColorCode() {
        return colorCode;
    }

}
