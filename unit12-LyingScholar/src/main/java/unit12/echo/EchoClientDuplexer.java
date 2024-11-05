package unit12.echo;

import java.io.IOException;
// import java.io.PrintWriter;
import java.net.Socket;
// import java.util.Scanner;

import unit12.duplexer.Duplexer;

public class EchoClientDuplexer {
    public static void main(String[] args) {
        System.out.println();

        try{
            Socket client = new Socket("localhost",54321);
            // PrintWriter printer = new PrintWriter(client.getOutputStream());

            Duplexer duplexer = new Duplexer(client);
            String message = "is anybody out there?";
            System.out.println("sending: " + message);
            // printer.println(message);
            // printer.flush();
            duplexer.send(message);

            // Scanner in = new Scanner(client.getInputStream());
            String response = duplexer.read();
            System.out.println("Recieved: "+ response);
            
            // in.close();
            // client.close();
            duplexer.close();
            
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        System.out.println();
    }
}
