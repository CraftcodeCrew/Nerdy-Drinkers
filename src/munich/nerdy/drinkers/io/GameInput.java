package munich.nerdy.drinkers.io;

import munich.nerdy.drinkers.player.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by leong on 14.05.2016.
 */
public class GameInput {

    private int numberOfPlayers;

    public GameInput() {
    }

    public void insertNumberOfPlayers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie die Anzahl der Spieler an:");
        System.out.println();
        try {
            numberOfPlayers = scanner.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Falsche Eingabe, bitte geben Sie nur natürliche Zahlen ein!");
            insertNumberOfPlayers();
        }
        System.out.println("Spieler: " + numberOfPlayers);
    }

    public void insertPlayerNames() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i<numberOfPlayers; i++) {
            System.out.println("Spieler" + i + ":");
            System.out.println("Bitte geben Sie ihren Spielernamen ein");

        }
    }

    public static void main(String[] args) {
       GameInput gameInput = new GameInput();
        gameInput.insertNumberOfPlayers();
    }
}
