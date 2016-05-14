package munich.nerdy.drinkers;

public class Main {

    public static void main(String[] args) {
	    int players= 3; //GameInput.insertNumberOfPlayers();
        String names[]= {"h","a","f"}; //= GameInput.insertPlayerNames();
        Game game= new Game(players, names);

        while(game.getPlayOn()) {
            game.Output.init();
            System.exit(0);
        }
    }
}
