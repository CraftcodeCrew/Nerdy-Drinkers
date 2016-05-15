package munich.nerdy.drinkers;

import munich.nerdy.drinkers.io.GameInput;

public class Main {

    public static void main(String[] args) {
	    int players= GameInput.insertNumberOfPlayers();

        Game game= new Game(GameInput.createPlayers(players));

        while(game.getContinueGame()) {
            game.Output.init();
            String playerOfTheRound= game.getRandomPlayer().getName();
            game.Output.chosen(playerOfTheRound);
            game.Output.story();

            if (GameInput.playerWon(playerOfTheRound)) {
                game.Output.roundWon(playerOfTheRound);
            } else {
                game.Output.roundLoss(playerOfTheRound);
            }

            if (game.getRoundCount() % players == 0) game.setContinueGame(true);
            System.exit(0);
        }
    }
}
