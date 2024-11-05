package unit12.tinychat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class TinyChatClient {


    private static final String SERVR_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 12410;
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
            Socket socket = new Socket(SERVR_ADDRESS, SERVER_PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream())) {
            System.out.print("Enter your name to connect to tinychat: ");
            System.out.println(scanner.nextLine());
            String serverResponse = in.readLine();
            System.out.println(serverResponse); 

            while (true) {
                String message = scanner.nextLine();
                System.out.println(message);
                if ("QUIT".equals(message.toUpperCase())) {
                    System.out.println(in.readLine());
                    break;
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}