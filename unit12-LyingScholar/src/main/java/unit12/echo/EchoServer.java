package unit12.echo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) {
        System.out.println();

        try{
            ServerSocket server = new ServerSocket(54321);
            Socket client = server.accept();

            Scanner in = new Scanner(client.getInputStream());
            String message = in.nextLine();
            System.out.println("Recieved: "+ message);

            PrintWriter out = new PrintWriter(client.getOutputStream());
            out.println(message.toUpperCase());
            out.flush();


            in.close();
            client.close();
            server.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        System.out.println();
    }
}
