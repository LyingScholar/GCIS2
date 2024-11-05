package unit12.tinychat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

public class ClientHandler implements Runnable {
    private final Socket clientSocket; 
    private HashMap<String, PrintWriter> clients = new HashMap<>();

    public ClientHandler(Socket socket,HashMap<String, PrintWriter> cleints) {
        this.clientSocket = socket;
        this.clients = cleints;
    } 
    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            
            String name = in.readLine();
            clients.put(name, out);
            broadcastMessage(name, "Connected", out); 
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if ("Quit".equalsIgnoreCase(inputLine)) {
                    System.out.println("Closing");
                    clients.remove(name);
                    broadcastMessage(name, "QUIT", out);
                    break;
                } else {
                    broadcastMessage(name, inputLine, out);
                }
                clientSocket.close();
            }
        } catch (IOException ioe) {}
    } 
    
    private void broadcastMessage(String name, String message, PrintWriter excludeOut) {
        clients.forEach((clientName, out) -> {
            if (out != excludeOut) {
                out.println(name + ": " + message);
            }
        });
    }
}