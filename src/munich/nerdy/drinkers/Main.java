package munich.nerdy.drinkers;

public class Main {

    public static void main(String[] args) {
	    int players= 3; //Game.Input.insertNumberOfPlayers();
        String names[]= {"h","a","f"}; //= GameInput.insertPlayerNames();
        Game game= new Game(players, names);

        while(game.getPlayOn()) {
            game.Output.init();
            game.Output.chosen(game.getRandomPlayer().getName());
            game.Output.story();

            System.exit(0);
        }
    }
}
