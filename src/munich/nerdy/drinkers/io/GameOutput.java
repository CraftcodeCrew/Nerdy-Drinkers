package munich.nerdy.drinkers.io;

import munich.nerdy.drinkers.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Domi on 14.05.2016.
 */
public class GameOutput {

    List<Player> players = new ArrayList<>();

    public GameOutput(List<Player> players) {
        this.players= players;
    }

    public void init() {
        System.out.printf("Es spielen %d Spieler.", this.players.size());
        for(Player player : players) {
            System.out.printf("Spieler %s nimmt am Spiel teil!", player.getName());
        }
    }
}
