package unit12.echo;

import java.io.IOException;
// import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


import unit12.duplexer.Duplexer;

public class EchoServerDuplexer {
    public static void main(String[] args) {
        System.out.println();

        try{
            ServerSocket server = new ServerSocket(54321);
            Socket client = server.accept();

            // Scanner in = new Scanner(client.getInputStream());
            Duplexer duplexer = new Duplexer(client);

            // String message = in.nextLine();
            String message = duplexer.read();
            System.out.println("Recieved: "+ message);

            // PrintWriter out = new PrintWriter(client.getOutputStream());
            System.out.println("Sending: "+ message.toUpperCase());
            // out.println(message.toUpperCase());
            // out.flush();
            duplexer.send(message.toUpperCase());


            // in.close();
            // client.close();
            duplexer.close();
            server.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        System.out.println();
    }
}
