package unit12.guessing;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import unit12.duplexer.Duplexer;

public class GuessingGameServer extends Duplexer implements Runnable{
    private GuessingGameImpl game;

    public GuessingGameServer(Socket sock) throws IOException{
        super(sock);
        game = new GuessingGameImpl();
    }

    public void run(){
        String request = "";
        while (!request.equals("QUIT")) {
            request = read();
            System.out.println("RECV: "+request);
            String[] tokens = request.split(" ");
            String response = "";

            switch (tokens[0]) {
                case "QUIT":
                    game.quit();
                    response = "GAME_OVER";
                    break;
                case "RESTART":
                    game.restart();
                    response = "RESTARTED";
                    break;
                case "GUESS":
                    GuessResult res = game.guess(Integer.parseInt(tokens[1]));
                    response = res.toString();
                    break;
                default:
                    response = "ERROR: Unknown Command - "+ request;
                    break;
            }
            System.out.println("SEND: "+ response);
            send(response);
        }
        return;//stub
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println();

        @SuppressWarnings("resource")
        ServerSocket server = new ServerSocket(12345);
        while (true) {
            System.out.println("Waiting for a client...");
            Socket client = server.accept();
            GuessingGameServer gameServer = new GuessingGameServer(client);
            System.out.println("Starting new game...");
            // gameServer.run();
            new Thread(gameServer).start();

        }
        
    }
}
