package finalexam.knockknock;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import finalexam.duplexer.Duplexer;

public class KnockKnockServer {
    private Duplexer duplexer;
    private String setup;
    private String punchline;

    public KnockKnockServer(Socket socket, String setup, String punchline) throws IOException {
        this.duplexer = new Duplexer(socket);
        this.setup = setup;
        this.punchline = punchline;
    }

    public void tellKnockKnock() throws IOException {
        // System.out.println("Starts");
        duplexer.send("Knock, Knock.");
        System.out.println("Server: Knock, Knock.");
        System.out.println("Client: " + duplexer.receive());
        duplexer.send(setup);
        System.out.println("Server: " + setup);
        System.out.println("Client: " + duplexer.receive());

        
        duplexer.send(punchline);
        System.out.println("Server: " + punchline);
        // System.out.println("banaanana");
    }

    public void close() throws IOException {
        duplexer.close();
    }

        public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(54322)) {
            System.out.println("Server waiting for connection on port 54322...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to client");
            KnockKnockServer server = new KnockKnockServer(clientSocket, "Broccoli",
                    "Broccoli doesn't have a last name, silly!");
            server.tellKnockKnock();
            server.close();
        } catch (IOException iOe) {
            iOe.printStackTrace();
        }
    }

    //enjoy the summer, bye
}
