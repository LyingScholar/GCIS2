package unit12.tinychat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;


public class MultiThreadedTinyChatServer {
    private static final int PORT = 12410;
    private final HashMap<String, PrintWriter> clients = new HashMap<>();


    public static void main(String[] args) {
        new MultiThreadedTinyChatServer().startServer();
    }
    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on " + PORT);


        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Thread(new ClientHandler(clientSocket,clients)).start();
        }
    } catch (IOException ioe) {
        ioe.printStackTrace();
    }
    } 

}
