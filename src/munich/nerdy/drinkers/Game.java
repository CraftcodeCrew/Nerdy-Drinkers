package munich.nerdy.drinkers;

/**
 * Created by Domi on 14.05.2016.
 */
public class Game {

    int players;
    String names[];
    int failed[];

    boolean playOn= true;
    int roundCount= 0;

    public Game(int players, String names[]) {
        this.players= players;
        this.names= names;
        this.failed= new int[players];
    }

    public void addRound() {
        this.roundCount++;
    }


    // Setter and Getter
    public int getPlayers() {
        return players;
    }

    public String[] getNames() {
        return names;
    }

    public int[] getFailed() {
        return failed;
    }

    public boolean getPlayOn() {
        return playOn;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void setFailed(int[] failed) {
        this.failed = failed;
    }

    public void setPlayOn(boolean playOn) {
        this.playOn = playOn;
    }
}
