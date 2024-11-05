package unit12.tinychat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class TinyChatServer {
    //felt easier to make port as an UNIVERSAL C.
    private static final int PORTNUMBER = 12410;
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORTNUMBER);
            System.out.println("Server is listening on port " + PORTNUMBER);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                String name = in.readLine();
                System.out.println(name + ": Connected");
                
                out.println("Conected");
                String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println(name + ": " + inputLine);
                        if ("QUIT".equals(inputLine.toUpperCase())) {
                            out.println("Closing");
                            out.flush();
                            serverSocket.close();
                            break;
                        }
                    }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
}

}