package unit12.guessing;

import java.io.IOException;
import java.net.Socket;

public class NetworkGuessingGame {
    public static void main(String[] args) throws IOException{
        System.out.println();

        Socket server = new Socket("Localhost",12345);
        GuessingGame game = new GuessigGameProxy(server);
        GamePlayer player = new GamePlayer(game);
        player.playTheGame();

        System.out.println();
    }
}
