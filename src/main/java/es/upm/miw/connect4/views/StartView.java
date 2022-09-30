package es.upm.miw.connect4.views;

import es.upm.miw.connect4.models.Game;

import java.util.Scanner;

public class StartView {
    final static String SEPARATOR = "###############################################";
    final static String TITLE = "#                  CONNECT4                   #";

    Game game;
    Scanner scanner;
    public StartView(Game game, Scanner scanner) {
        this.game = game;
        this.scanner = scanner;
    }

    public void start() {
        this.printBanner();
        this.playerSetup();
        this.printSeparator();
    }

    private void printBanner() {
        System.out.println("");
        System.out.println(SEPARATOR);
        System.out.println(TITLE);
        System.out.println(SEPARATOR);
        System.out.println("");
    }

    private void printSeparator() {
        System.out.println();
        System.out.println(SEPARATOR);
        System.out.println();
    }


    public void playerSetup() {
        System.out.print("Select the number of players: ");
        int playerNum = this.scanner.nextInt();
        game.initializePlayers(playerNum);
    }
}
