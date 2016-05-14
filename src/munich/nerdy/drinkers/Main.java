package munich.nerdy.drinkers;

public class Main {

    public static void main(String[] args) {
	    int players= 0; //GameInput.insertNumberOfPlayers();
        String names[]= {}; //= GameInput.insertPlayerNames();

        Game game= new Game(players, names);

        while(game.getPlayOn()) {

        }

    }
}
