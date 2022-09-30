package es.upm.miw.connect4.views;

import es.upm.miw.connect4.models.Game;

import java.util.Scanner;

public class View {
    Scanner scanner;
    Game game;
    StartView startView;
    PlayView playView;

    public View(Game game) {
        this.scanner = new Scanner(System.in);
        this.game = game;
        this.startView = new StartView(game, scanner);
        this.playView = new PlayView(game, scanner);
    }

    public void play() {
        this.startView.start();
        this.playView.play();
    }

}
