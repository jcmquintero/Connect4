package es.upm.miw.connect4;

public enum Color {
    RED('R'),
    YELLOW('Y'),
    GREEN('G'),
    BLUE('B'),
    PURPLE('P'),
    WHITE('W'),
    NONE(' ');

    char colorCode;
    private Color(char colorCode) {
        this.colorCode = colorCode;
    }

    public char getColorCode() {
        return colorCode;
    }
}
