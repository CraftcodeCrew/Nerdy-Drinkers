package munich.nerdy.drinkers.io;

import munich.nerdy.drinkers.player.Player;
import munich.nerdy.drinkers.plots.TextFetcher;
import munich.nerdy.drinkers.plots.TranslateSetting;
import munich.nerdy.drinkers.utility.ASCIIUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static munich.nerdy.drinkers.utility.Utility.readConfig;
import static munich.nerdy.drinkers.utility.Utility.withNewLine;

/**
 * Created by Domi on 14.05.2016.
 */
public class GameOutput {

    List<Player> players = new ArrayList<>();

    public GameOutput(List<Player> players) {
        this.players = players;
    }

    public static void init() {
        System.out.printf(withNewLine(ASCIIUtils.ASCII_BEER));
    }
    public void start() {
        System.out.printf(withNewLine("Es treten %d Superhelden gegeneinander an."), this.players.size());
        for (Player player : players) {
            System.out.printf(withNewLine("Superheld %s opfert sich für die Menschehit!"), player.getName());
        }
    }

    public void chosen(String name) {
        System.out.printf(withNewLine("%s, du bist der Auserwählte! Teile deine Geschichte mit der Menscheit:"), name);
    }

    public void story() {
        try {
            Properties prop = readConfig();

            TranslateSetting setting = new TranslateSetting(prop.getProperty("secretKey"), prop.getProperty("clientID"));
            TextFetcher fetcher = new TextFetcher(setting);
            String plot = fetcher.getGermanPlot();
            System.out.printf(withNewLine(plot));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void roundWon(String name) {
        System.out.printf(withNewLine("%s ist ein Badass!"), name);
        System.out.printf(withNewLine(ASCIIUtils.ASCII_SUPERMAN));
    }

    public void roundLoss(String name) {
        System.out.printf(withNewLine("Hey %s, niemand mag dich!"), name);
        System.out.printf(withNewLine(ASCIIUtils.ASCII_LEMONS));

    }

    public void blacklist() {
        System.out.printf(withNewLine("Aktuelle Blacklist: %s"), Blacklist.getBlacklist());
    }
}

