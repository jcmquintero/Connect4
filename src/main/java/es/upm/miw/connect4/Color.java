package es.upm.miw.connect4;

public enum Color {
    RED('R'),
    YELLOW('Y'),
    NONE(' ');

    char colorCode;
    private Color(char colorCode) {
        this.colorCode = colorCode;
    }

    public char getColorCode() {
        return colorCode;
    }
}
