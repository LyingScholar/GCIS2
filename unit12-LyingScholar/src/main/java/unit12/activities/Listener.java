package unit12.activities;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Listener {
    public static void main(String[] args) {
        System.out.println();

        try{
            ServerSocket server = new ServerSocket(22);
            Socket client = server.accept();
            System.out.println("Connected!");

            client.close();
            server.close();

        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        System.out.println();
    }
}
