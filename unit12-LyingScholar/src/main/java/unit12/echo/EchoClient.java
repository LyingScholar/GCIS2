package unit12.echo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {
        System.out.println();

        try{
            Socket client = new Socket("localhost",54321);
            PrintWriter printer = new PrintWriter(client.getOutputStream());

            String message = "is anybody out there?";
            System.out.println("sending: " + message);
            printer.println(message);
            printer.flush();

            Scanner in = new Scanner(client.getInputStream());
            System.out.println("Recieved: "+ in.nextLine());
            
            in.close();
            client.close();
            
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        System.out.println();
    }
}
