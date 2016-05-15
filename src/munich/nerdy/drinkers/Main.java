package munich.nerdy.drinkers;

import munich.nerdy.drinkers.io.Blacklist;
import munich.nerdy.drinkers.io.GameInput;
import munich.nerdy.drinkers.io.GameLog;
import munich.nerdy.drinkers.io.GameOutput;

public class Main {

    public static void main(String[] args) {
        GameOutput.init();

	    int players= GameInput.insertNumberOfPlayers();
        Game game= new Game(GameInput.createPlayers(players));

        game.Output.start();
        GameLog.log("Spiel gestartet. Es nehmen " + players + " Spieler teil.");
        while(game.getContinueGame()) {
            GameLog.log("Wörter in der Blacklist: " + Blacklist.getBlacklist());
            game.Output.blacklist();
            String playerOfTheRound= game.getRandomPlayer().getName();
            GameLog.log("Runde " + game.getRoundCount() + ". Spieler " + playerOfTheRound + " ist an der Reihe!");
            game.Output.chosen(playerOfTheRound);
            if (!game.isSuperRound) {
                game.Output.story();
            }
            else game.Output.superRound(playerOfTheRound);

            if (GameInput.playerWon(playerOfTheRound)) {
                game.Output.roundWon(playerOfTheRound);
                GameLog.log(playerOfTheRound + " hat gewonnen.");
                GameInput.addWordToBlacklist();
            } else {
                game.Output.roundLoss(playerOfTheRound);
                game.incrementFailed(playerOfTheRound);
                GameLog.log(playerOfTheRound + " hat verloren.");
            }

            game.addRound();
            if (game.getRoundCount() % players == 0) {
                if (!GameInput.continueGame()) {
                    game.setContinueGame(false);
                    GameLog.log("Das Spiel wurde beendet.");
                    Blacklist.clearBlacklist();
                }
            }
        }
        game.Output.summary(game.getRoundCount());
        Blacklist.clearBlacklist();
    }
}
