package es.upm.miw.connect4;

import es.upm.miw.connect4.models.*;
import es.upm.miw.connect4.views.View;

public class Connect4 {
    View view;
    private void play() {
        view = new View(new Game());
        view.play();
    }

    public static void main(String[] args) {
        new Connect4().play();
    }
}
