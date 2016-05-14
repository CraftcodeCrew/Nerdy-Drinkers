package munich.nerdy.drinkers;

/**
 * Created by Domi on 14.05.2016.
 */
public class Round {

    public static int getRandomPlayer(int players) {
        return (int)(Math.random() * ((players) + 1));
    }
}
