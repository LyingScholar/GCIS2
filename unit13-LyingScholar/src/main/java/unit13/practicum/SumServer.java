package unit13.practicum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SumServer {
    private int totalSum;
    private ServerSocket serverSocket;
    private final Object lock = new Object();

    public SumServer(int port){
        try{
            serverSocket = new ServerSocket(port);
            totalSum = 0;
        }catch(IOException ioe){
            System.out.println("error in initialisation of server \n");
            ioe.printStackTrace();
        }
    } 

    public void startServer() throws IOException {
        try{
        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Thread(new ClientHandler(clientSocket)).start();
        }
        }catch(IOException ioe){
            System.out.println("error in starting server \n");
            ioe.printStackTrace();
        }
    }

    class ClientHandler implements Runnable {
        private Socket clientSocket; 
        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        } 
        public void run() {
            try (BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream())) { 
                    String line;
                while ((line = input.readLine()) != null) {
                    int num = Integer.parseInt(line);
                    System.out.println("Received: " + num);
                    synchronized (lock) {
                            totalSum += num;
                            System.out.println("Sent: " + totalSum);
                            output.println(totalSum);
                    } 
                    if (num == 0) {
                        break;
                    }
                }

                
                clientSocket.close();

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    } 
    public static void main(String[] args) throws IOException {
        SumServer server = new SumServer(9999);
        server.startServer();
    }
    }