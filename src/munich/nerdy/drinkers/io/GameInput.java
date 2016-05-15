package munich.nerdy.drinkers.io;
import munich.nerdy.drinkers.player.Player;

import java.util.*;

/**
 * Created by leong on 14.05.2016.
 */
public class GameInput {

    public static int insertNumberOfPlayers() {
        int numberOfPlayers = 0;
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
        return numberOfPlayers;
    }

    public static List<Player> createPlayers(int numberOfPlayers) {
        List<Player> players = new ArrayList<>();
        try{
            Scanner nameScanner = new Scanner(System.in);
            for (int i = 1; i <= numberOfPlayers; i++) {
                System.out.println("Spieler" + i + ":");
                System.out.println("Bitte geben Sie ihren Spielernamen ein:");
                System.out.println();
                String name = nameScanner.nextLine();
                players.add(new Player(i,name));
            }
        }
        catch (Exception e) {
            System.out.println("Etwas ist schiefgelaufen, bitte erneut versuchen!");
            createPlayers(numberOfPlayers);
        }
        return players;
    }

    public static boolean playerWon(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hat" + name + "die Runde geschafft?(y/n)");
        String answer = scanner.nextLine();
        if (answer.equals("y")) {
            return true;
        }
        else if (answer.equals("n")) {
            return false;
        }
        else {
            System.out.println("Falsche Eingabe, bitte versuche es noch einmal!");
            playerWon(name);
        }
        return false;
    }

    public static boolean continueGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wollen Sie weiterspielen?(y/n)");
        String answer = scanner.nextLine();
        if (answer.equals("y")) {
            return true;
        }
        else if (answer.equals("n")) {
            return false;
        }
        else {
            System.out.println("Falsche Eingabe, bitte versuche es noch einmal!");
            continueGame();
        }
        return false;
    }
}
