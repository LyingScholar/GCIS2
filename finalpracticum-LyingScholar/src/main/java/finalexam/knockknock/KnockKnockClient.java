package finalexam.knockknock;

import java.io.IOException;
import java.net.Socket;

import finalexam.duplexer.Duplexer;

public class KnockKnockClient {
    private Duplexer duplexer;

    public KnockKnockClient(Socket socket) throws IOException{
        this.duplexer = new Duplexer(socket);
    }

    public void knockKnock() {
        String lineFromServer = duplexer.receive();
        System.out.println("Server: " + lineFromServer);

        if ("Knock, Knock.".equals(lineFromServer)) {
            duplexer.send("Who's there?");
            System.out.println("Client: Who's there?");
        }

        String setup = duplexer.receive();
        System.out.println("Server: " + setup);

        duplexer.send(setup + ", who?");
        System.out.println("Client: " + setup + ", who?");

        String punchline = duplexer.receive();
        System.out.println("Server: " + punchline);
    }

    public void close() throws IOException {
        duplexer.close();
    }

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 54322);
            KnockKnockClient client = new KnockKnockClient(socket);
            client.knockKnock();
            client.close();

        } catch (IOException ioe) {
            //System.out.println("oops");
            ioe.printStackTrace();
        }
    }
}
