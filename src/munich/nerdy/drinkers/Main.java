package munich.nerdy.drinkers;

import munich.nerdy.drinkers.io.Blacklist;
import munich.nerdy.drinkers.io.GameInput;
import munich.nerdy.drinkers.io.GameOutput;

public class Main {

    public static void main(String[] args) {
        GameOutput.init();

	    int players= GameInput.insertNumberOfPlayers();
        Game game= new Game(GameInput.createPlayers(players));

        game.Output.start();
        while(game.getContinueGame()) {
            game.Output.blacklist();
            String playerOfTheRound= game.getRandomPlayer().getName();
            game.Output.chosen(playerOfTheRound);
            if (!game.isSuperRound) {
                game.Output.story();
            }
            else game.Output.superRound();

            if (GameInput.playerWon(playerOfTheRound)) {
                game.Output.roundWon(playerOfTheRound);
                GameInput.addWordToBlacklist();
            } else {
                game.Output.roundLoss(playerOfTheRound);
            }

            game.addRound();
            if (game.getRoundCount() % players == 0) {
                if (!GameInput.continueGame()) {
                    game.setContinueGame(false);
                    Blacklist.clearBlacklist();
                }
            }
        }
    }
}
