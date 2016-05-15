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
        System.out.printf(withNewLine(ASCIIUtils.ANSI_YELLOW + ASCIIUtils.ASCII_BEER + ASCIIUtils.ANSI_RESET));
        System.out.println();
    }

    public void start() {
        System.out.printf(withNewLine("Es treten %d Superhelden gegeneinander an."), this.players.size());
        for (Player player : players) {
            System.out.printf(withNewLine(
                    ASCIIUtils.ANSI_BLUE + "Superheld %s opfert sich für die Menschehit!" + ASCIIUtils.ANSI_RESET), player.getName()
            );
        }
    }

    public void chosen(String name) {
        System.out.printf(withNewLine(
                ASCIIUtils.ANSI_BLUE + "%s, du bist der Auserwählte! Teile deine Geschichte mit der Menscheit:" + ASCIIUtils.ANSI_RESET
        ), name);
        System.out.println();
    }

    public void story() {
        try {
            Properties prop = readConfig();
            TranslateSetting setting = new TranslateSetting(prop.getProperty("apikey"));
            TextFetcher fetcher = new TextFetcher(setting);
            String plot = fetcher.getGermanPlot();
            System.out.printf(withNewLine(plot));
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void superRound(String name) {
        System.out.println(ASCIIUtils.ANSI_YELLOW + ASCIIUtils.ASCII_SUPER_GNU);
        System.out.printf("Superrunde! %s musst jetz eine Anekdote aus deinem Leben vortragen!" + ASCIIUtils.ANSI_RESET, name);
        System.out.println();
    }

    public void roundWon(String name) {
        System.out.printf(withNewLine("%s ist ein Badass!"), name);
        System.out.printf(withNewLine(ASCIIUtils.ASCII_SUPERMAN));
        System.out.println();
    }

    public void roundLoss(String name) {
        Player currentPlayer = getPlayer(name);
        currentPlayer.incrementFailed();
        System.out.printf(withNewLine("Hey %s, niemand mag dich!"), name);
        System.out.printf(withNewLine(ASCIIUtils.ASCII_LEMONS));
        System.out.println();
    }

    public void blacklist() {
        System.out.printf(withNewLine(ASCIIUtils.ANSI_RED + "Aktuelle Blacklist: %s" + ASCIIUtils.ANSI_RESET), Blacklist.getBlacklist());
        System.out.println();
    }

    public void summary(int roundCount) {
        Summary summary = new Summary(players, roundCount);
        System.out.println(summary.toString());
    }

    private Player getPlayer(String name) {
        for(Player currentPlayer : players) {
            if(currentPlayer.getName().equals(name)) return currentPlayer;
        }
        return null;
    }
}

