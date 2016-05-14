package munich.nerdy.drinkers.io;

import munich.nerdy.drinkers.player.Player;

import java.util.*;

/**
 * Created by leong on 14.05.2016.
 */
public class GameInput {

    private int numberOfPlayers;

    public GameInput() {
    }

    public void insertNumberOfPlayers() {
        System.out.println("Bitte geben Sie die Anzahl der Spieler an:");
        System.out.println();

        try {
            Scanner scanner = new Scanner(System.in);
            numberOfPlayers = scanner.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Falsche Eingabe, bitte geben Sie nur natürliche Zahlen ein!");
            insertNumberOfPlayers();
        }
        System.out.println("Spieler: " + numberOfPlayers);
    }

    public Map<Integer,String> createPlayerNames() {
        Map<Integer,String> players = new HashMap<>();
        try{
            Scanner nameScanner = new Scanner(System.in);
            for (int i = 1; i <= numberOfPlayers; i++) {
                System.out.println("Spieler" + i + ":");
                System.out.println("Bitte geben Sie ihren Spielernamen ein:");
                System.out.println();
                String name = nameScanner.nextLine();
                players.put(i,name);
            }
            nameScanner.close();
        }
        catch (Exception e) {
            System.out.println("Etwas ist schiefgelaufen, bitte erneut versuchen!");
            createPlayerNames();
        }
        return players;
    }
}
