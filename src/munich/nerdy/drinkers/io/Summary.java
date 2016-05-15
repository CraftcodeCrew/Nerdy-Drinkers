package munich.nerdy.drinkers.io;

import munich.nerdy.drinkers.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leong on 15.05.2016.
 */
public class Summary {

    private List<Player> players = new ArrayList<>();
    private String winnerInfo;
    private String loserInfo;
    private int roundCount;

    public Summary(List<Player> players, int roundCount) {
        this.players = players;
        this.roundCount = roundCount;
        getGameInfo(players);
    }

    private void getGameInfo(List<Player> players) {
        int loserCount = 0;
        int winnerCount = 100;
        Player loser  = new Player();
        Player winner = new Player();
        for(Player player: players) {
            if(player.getFailed() < winnerCount){
                winnerCount = player.getFailed();
                winner = player;
            }
            if(player.getFailed() > loserCount) {
                loserCount = player.getFailed();
                loser = player;
            }
        }

        winnerInfo = winner.getName() + " musste nur " + winner.getFailed() + " mal trinken!";
        loserInfo = loser.getName() + " die Lusche musste " + loser.getFailed() + " mal trinken!";
    }

    private String getPlayerNames(List<Player> players) {
        String playerNames = "";
        for(Player player:players) {
            playerNames += "'" + player.getName() + "'; ";
        }
        return playerNames;
    }

    @Override
    public String toString() {
        return "Spielzusammenfassung: " + "\n" +
                "Spieler =" + getPlayerNames(players) + "\n" +
                "Gewinner='" + winnerInfo + '\'' + "\n" +
                "Verlierer='" + loserInfo + '\'' + "\n" +
                "gespielte Runden= " + roundCount + "\n" +
                "Blacklist = " + Blacklist.getBlacklist();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getWinnerInfo() {
        return winnerInfo;
    }

    public void setWinnerInfo(String winnerInfo) {
        this.winnerInfo = winnerInfo;
    }

    public String getLoserInfo() {
        return loserInfo;
    }

    public void setLoserInfo(String loserInfo) {
        this.loserInfo = loserInfo;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(int roundCount) {
        this.roundCount = roundCount;
    }
}
