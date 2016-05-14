package munich.nerdy.drinkers.io;

import munich.nerdy.drinkers.player.Player;

import java.util.ArrayList;
import java.util.List;
import munich.nerdy.drinkers.utility.Utility;

import static munich.nerdy.drinkers.utility.Utility.withNewLine;

/**
 * Created by Domi on 14.05.2016.
 */
public class GameOutput {

    List<Player> players = new ArrayList<>();

    public GameOutput(List<Player> players) {
        this.players= players;
    }

    public void init() {
        System.out.printf(withNewLine("Es treten %d Superhelden gegeneinander an."), this.players.size());
        for(Player player : players) {
            System.out.printf(withNewLine("Superheld %s möchte die Gegner abschießen!"), player.getName());
        }
    }
}
