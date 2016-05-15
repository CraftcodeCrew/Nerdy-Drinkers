package munich.nerdy.drinkers;

import munich.nerdy.drinkers.io.GameInput;

public class Main {

    public static void main(String[] args) {
	    int players= GameInput.insertNumberOfPlayers();
        String names[]= {"h","a","f"}; //= GameInput.insertPlayerNames();

        Game game= new Game(players, names);

        while(game.getPlayOn()) {
            game.Output.init();
            String playerOfTheRound= game.getRandomPlayer().getName();
            game.Output.chosen(playerOfTheRound);
            game.Output.story();

            boolean playerWon= true;

            if (playerWon) {
                game.Output.roundWon(playerOfTheRound);
            } else {
                game.Output.roundLoss(playerOfTheRound);
            }

            System.exit(0);
        }
    }
}
