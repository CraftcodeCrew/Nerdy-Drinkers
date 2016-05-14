package munich.nerdy.drinkers;

import munich.nerdy.drinkers.io.GameInput;
import munich.nerdy.drinkers.io.GameOutput;
import munich.nerdy.drinkers.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Domi on 14.05.2016.
 */
public class Game {

    List<Player> players = new ArrayList<>();
    boolean playOn= true;
    int roundCount= 0;
    GameOutput Output;
    GameInput Input;

    public Game(int players, String names[]) {
        for (int i=0; i < players; i++) {
            this.players.add(new Player(i, names[i]));
        }
        Output= new GameOutput(this.players);
        Input= new GameInput();
    }

    public void addRound() {
        this.roundCount++;
    }

    public int getRandomPlayer() {
        return (int)(Math.random() * ((this.players.size() - 1) + 1));
    }


    // Setter and Getter

    public boolean getPlayOn() {
        return playOn;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void setPlayOn(boolean playOn) {
        this.playOn = playOn;
    }
}
