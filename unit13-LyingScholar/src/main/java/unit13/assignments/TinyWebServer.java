package unit13.assignments;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TinyWebServer {

    private static void handleClient(Socket clientSocket) {
        try {
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            byte[] requestBytes = new byte[1024];
            int bytesRead =  input.read(requestBytes);
            String request = new String(requestBytes, 0, bytesRead);
            String[] requestLines =  request.split("\r\n", 3);

            for (String line : requestLines) {
                System.out.println(line);
            }

            String response = "HTTP/1.1 200 OK\r\n" +
                    "Content-Length: 12\r\n" +
                    "Content-Type: text/plain; charset=utf-8\r\n\r\n" +
                    "Hello World!\r\n";

            output.write(response.getBytes());
            output.flush();
            clientSocket.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server listening on port 8080");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread clientThread  = new Thread(() -> handleClient(clientSocket));
                clientThread.start();
            }
        }catch(IOException ioe){}
    }
}